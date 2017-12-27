package com.ssm.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.entity.Image;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ImageTest {
	@Autowired
	private ImageService imageService;
	
//	@Test
    public void testImageRecognize() {


    	Image image = new Image();
    	image.setBacterial("1");
    	image.setOrigin("2");
    	image.setSeparateposition("3");
    	image.setMethod("96孔板");
    	image.setRemark("4");
    	image.setProvince("5");
    	image.setCity("6");
    	image.setLocation("7");
		image.setUserId(1);
		
		String tFile = GetImageStr();
		
      
      String path = "C:\\Users\\Administrator\\Desktop"; // 此处为测试，假设用户ID为1
      
      String[][] tempresulttable = new String[12][8]; 
      tempresulttable = imageService.identifyImage(image, tFile, path);
      
      
      String resulttable = new String();
      for(int i=0;i<8;i++){
          resulttable = resulttable.concat("\n第"+i+"行孔板：");
//          System.out.println(resulttable);
          for(int j=0; j<12; j++){
              
              if(j>0){
                  if(!tempresulttable[j-1][i].equals(tempresulttable[j][i]))
                  resulttable = resulttable.concat("|");
              }
              else{
                  resulttable = resulttable.concat(" ");
              }
              if(tempresulttable[j][i].equals("clear"))
                  resulttable = resulttable.concat("○");
              else
                  resulttable = resulttable.concat("●");
                  
              
          }
      }
      System.out.println(resulttable);
    }
    
    public static String GetImageStr()  
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        String imgFile = "C:\\Users\\Administrator\\Desktop\\WeChat Image_20171114195815.jpg";//待处理的图片  
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try   
        {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
    }  
    
    @Test
    public void toImage()
    {
    	try {
	    	String source = "C:\\Users\\Administrator\\Desktop\\base64(2).txt";
	    	File file = new File(source);
	    	InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file));
			
			BufferedReader inputData = new BufferedReader(inputStream);
			StringBuilder image = new StringBuilder();
			String data = inputData.readLine();
			while(data != null)
			{
				image.append("\n");
				image.append(data);
				data = inputData.readLine();
			}
	    	
	    	BufferedWriter outputStream = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\base64.txt"));
			outputStream.write(image.toString());
			outputStream.close();
	    	
	    	int mark = image.indexOf("base64");
	    	String fileString = image.substring(mark + 7);
	    	
	    	String path = "C:\\Users\\Administrator\\Desktop\\base64(2).jpg";
				BASE64Decoder decoder = new BASE64Decoder(); 
				byte[] b = decoder.decodeBuffer(fileString);
				
				for(int i=0; i<b.length; ++i)
					if(b[i]<0)
						b[i]+=256;
				
				OutputStream out = new FileOutputStream(path);      
	            out.write(b);  
	            out.flush();  
	            out.close();  
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
