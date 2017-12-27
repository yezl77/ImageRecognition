package com.ssm.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stool.tensorflowClassifier.Classifier;

import com.cnng.work.sources.app.login.ImageRecognizer;
import com.ssm.dao.ImageMapper;
import com.ssm.dao.ResultMapper;
import com.ssm.entity.Image;
import com.ssm.entity.ImageExample;
import com.ssm.entity.Result;
import com.ssm.service.ImageService;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import sun.misc.BASE64Decoder;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageMapper imageMapper;

	@Autowired
	private ResultMapper resultMapper;

	@Override
	public String[][] identifyImage(Image image, String fileString, String path) {

		BASE64Decoder decoder = new BASE64Decoder();

		// 生成图片名
		String imageName = UUID.randomUUID().toString();
		image.setName(imageName);
		// 生成图片和缩略图路径
		String imageURL = path + File.separator + imageName + ".jpg";
		String imageMiniURL = path + File.separator + imageName + "_m.jpg";
		image.setUrl(imageURL);
		image.setUrlMini(imageMiniURL);

		// 设置图片上传时间
		image.setUploadtime(new Date(System.currentTimeMillis()));

		// 把图片存到本地
		File imagePath = new File(path);
		if (!imagePath.exists()) {
			imagePath.mkdirs();
		}
		try {
			byte[] b = decoder.decodeBuffer(fileString);

			for (int i = 0; i < b.length; ++i)
				if (b[i] < 0)
					b[i] += 256;

			OutputStream out = new FileOutputStream(imageURL);
			out.write(b);
			out.flush();
			out.close();

			// 保存缩略图
			Thumbnails.of(imageURL).size(640, 480).toFile(imageMiniURL);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// 图片信息存数据库
		imageMapper.insert(image);

		// 调用算法识别图片
		String[][] identityRes = new String[12][8];
		if (image.getMethod().equals("96孔板"))
			identityRes = this.method1(image.getUrl());
		else
			;

		// 处理图片识别出的结果
		;
		;
		;

		/* 若算法顺利执行，往结果表插入一条记录以作标识 */
		ImageExample ie = new ImageExample();
		ImageExample.Criteria iec = ie.createCriteria();
		iec.andNameEqualTo(image.getName());
		List<Image> list = imageMapper.selectByExample(ie);
		Result result = new Result();
		result.setImageId(list.get(0).getId());
		result.setMedicine("test");
		result.setMic("0");
		result.setResult("x");
		resultMapper.insert(result);

		return identityRes;
	}

	private String[][] method1(String imagePath) {
		String[][] result = new String[12][8];

		byte[][][] imageByteArray;

		String path = this.getClass().getResource("/").getPath();
		System.out.println(path);
		String modelpath = path.substring(1, path.length()) + "model";

		try {
			imageByteArray = ImageRecognizer.getROIData(0, imagePath);
			// ImageRecognizer.testImgRec(0, imagePath);

			/* 显示切图 */
			// String url = "C:\\Users\\Administrator\\Desktop\\Test\\";
			// for (int i = 0; i < 12; i++) {
			// for (int j = 0; j < 8; j++)
			// {
			// String l = url + i + j + ".jpg";
			// byte[] pic = imageByteArray[i][j];
			// OutputStream out = new FileOutputStream(l);
			// out.write(pic);
			// out.flush();
			// out.close();
			// }
			// }

			Classifier turbidityModel = new Classifier(modelpath, "input", "output");

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 8; j++) {
					byte[] image = imageByteArray[i][j];

					org.stool.tensorflowClassifier.Result classifierresult = turbidityModel.predict(image);

					result[i][j] = classifierresult.getName();
				}
			}
			turbidityModel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

}
