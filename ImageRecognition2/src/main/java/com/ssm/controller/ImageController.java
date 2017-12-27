package com.ssm.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.entity.Image;
import com.ssm.entity.User;
import com.ssm.service.ImageService;

import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Controller
@RequestMapping(value = "Image")
public class ImageController {

	@Autowired
	private ImageService imageService;

	@RequestMapping(value = "/identify", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject identifyImage(@RequestBody JSONObject js, HttpServletRequest request) // @RequestParam("file")
																							// MultipartFile file,
	{
		HttpSession seesion = request.getSession();
		User user = (User) seesion.getAttribute("user");

		// 获取图片保存路径
		String path = request.getServletContext().getRealPath("uploadfile/" + user.getId());
		System.out.println(path);

		// 设置好图片的基本信息
		Image image = new Image();
		image.setOrigin(js.getString("origin"));
		image.setSeparateposition(js.getString("separateposition"));
		image.setBacterial(js.getString("bacterial"));
		image.setMethod(js.getString("method"));
		image.setRemark(js.getString("remark"));
		image.setProvince("A");
		image.setCity("B");
		image.setLocation("C");
		image.setUserId(user.getId());
		// 图片文件
		String imageString = js.getString("image");
		int mark = imageString.indexOf("base64");
		String fileString;
		if (mark > -1)
			fileString = imageString.substring(mark + 7);
		else
			fileString = imageString;

		String[][] result = new String[12][8];
		result = imageService.identifyImage(image, fileString, path);

		/* 测试时用于显示 */
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 12; ++j)
				System.out.print(result[j][i] + " ");
			System.out.println();
		}

		String resTrans = new String();
		for (int i = 0; i < 8; i++) {
			resTrans = resTrans.concat("\n第" + (i + 1) + "行孔板：");
			// System.out.println(resulttable);
			for (int j = 0; j < 12; j++) {

				if (j > 0) {
					if (!result[j - 1][i].equals(result[j][i]))
						resTrans = resTrans.concat("|");
				} else {
					resTrans = resTrans.concat(" ");
				}
				if (result[j][i].equals("muddy"))
					resTrans = resTrans.concat("○");
				else
					resTrans = resTrans.concat("●");
			}
		}

		System.out.println(resTrans);

		JSONObject json = new JSONObject();
		json.put("result", resTrans);

		return json;
	}
}
