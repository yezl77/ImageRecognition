package com.ssm.controller;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.entity.Image;
import com.ssm.entity.User;
import com.ssm.service.SearchService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/Search")
public class SearchController {

	@Autowired
	SearchService searchService;

	@RequestMapping(value = "/getHistory")
	@ResponseBody
	public JSONObject getHistory(@RequestBody JSONObject js, HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println(js.getString("start"));
		int start = js.getInt("start");
		int length = js.getInt("length");
		JSONObject json = new JSONObject();
		List<Image> list = searchService.getHistory(user, start, length);
		json.put("result", list);
		System.out.println(json);
		return json;
	}

	@RequestMapping(value = "/getHistoryByCondition")
	@ResponseBody
	public JSONObject getHistoryByCondition(@RequestBody JSONObject js, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String startTime = js.getString("startTime");
		String endTime = js.getString("endTime");
		String keyword = js.getString("keyword");
		int start = js.getInt("start");
		int length = js.getInt("length");
		JSONObject json = new JSONObject();
		List<Image> list = searchService.getHistoryByCondition(user, startTime.replace("T", " "),
				endTime.replace("T", " "), keyword, start, length);
		json.put("result", list);
		System.out.println(json);
		return json;
	}

	@RequestMapping("/outputPic")
	public void picToJSP(@PathParam("id") int id, HttpServletResponse response) {
		System.out.println("开始载入图片");
		System.out.println(id);
		Image img = searchService.getImage(id);
		FileInputStream in;
		response.setContentType("application/octet-stream;charset=UTF-8");
		try {
			// 图片读取路径
			// in=new FileInputStream("E:\\picture\\"+photoName);
			in = new FileInputStream(img.getUrl());
			// in=new FileInputStream("E:\\test.jpg");
			int i = in.available();
			byte[] data = new byte[i];
			in.read(data);
			in.close();
			System.out.println("写图片");
			// 写图片
			OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
			outputStream.write(data);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
