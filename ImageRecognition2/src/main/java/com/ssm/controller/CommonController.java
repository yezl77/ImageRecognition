package com.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ssm.entity.User;
import com.ssm.service.CommonService;
import com.ssm.util.StatusCode;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/User")
public class CommonController {
	@Autowired
	CommonService userService;

	@RequestMapping(value = "/login")
	@ResponseBody
	public JSONObject login(@RequestBody JSONObject js, HttpSession session) {
		User user = new User();
		user.setPhonenum(js.getString("phonenum"));
		user.setPassword(js.getString("password"));

		JSONObject json = new JSONObject();
		User res = userService.login(user);

		if (res != null) {
			session.setAttribute("user", userService.getInfo(js.getString("phonenum")));
			json.put("flag", StatusCode.PASS.getState());
			String path = this.getClass().getResource("/").getPath();
			System.out.println(path);
		} else
			json.put("flag", StatusCode.REJECT.getState());
		// return json.toString();
		return json;
	}

	@RequestMapping(value = "/register")
	@ResponseBody
	public JSONObject register(@RequestBody JSONObject js) {
		User newUser = new User();
		newUser.setPhonenum(js.getString("phonenum"));
		newUser.setPassword(js.getString("password"));
		newUser.setName(js.getString("name"));
		newUser.setWorkunit(js.getString("workunit"));
		newUser.setDepartment(js.getString("department"));
		newUser.setDuty(js.getString("duty"));
		String s = js.getString("address");
		newUser.setProvince(s);
		newUser.setCity(s);
		newUser.setAddress(s);
		newUser.setEmail(js.getString("email"));
		newUser.setQq(js.getString("QQ"));

		StatusCode res = userService.register(newUser);

		JSONObject json = new JSONObject();
		json.put("flag", res.getState());

		return json;
	}

	// 找回密码
	@RequestMapping(value = "/password")
	@ResponseBody
	public JSONObject password(@RequestBody JSONObject js, HttpSession session) {
		String phonenum = js.getString("phonenum");
		User user = userService.getInfo(phonenum);

		JSONObject jObject = new JSONObject();
		if (user == null) {
			// 用户不存在时的操作
			jObject.put("flag", StatusCode.REJECT.getState());
		} else {
			session.setAttribute("reset", user);
			System.out.println("放入" + user.getPhonenum());

			// 发送邮件（找回密码）
			try {
				// 验证码
				int num = userService.sendMail(user);
				session.setAttribute("verificationCode", num);
				jObject.put("code", num);
				jObject.put("flag", StatusCode.PASS.getState());
			} catch (Exception e) {
				System.out.println("----邮件发送失败!!!----");
				jObject.put("flag", StatusCode.REJECT.getState());
				e.printStackTrace();
			}
		}
		return jObject;
	}

	// 验证验证码
	@RequestMapping(value = "/verify")
	@ResponseBody
	public JSONObject verification(@RequestBody JSONObject js, HttpSession session) {
		int codei = (int) session.getAttribute("verificationCode");
		String code = String.valueOf(codei);
		String code2 = js.getString("verificationCode");

		JSONObject jObject = new JSONObject();
		if (code.equals(code2)) {
			jObject.put("flag", StatusCode.PASS.getState());
		} else {
			jObject.put("flag", StatusCode.REJECT.getState());
		}
		return jObject;
	}

	// 重设密码
	@RequestMapping(value = "/resetpassword")
	@ResponseBody
	public JSONObject resetPassword(@RequestBody JSONObject js, HttpSession session) {
		String password = js.getString("password");
		User user = (User) session.getAttribute("reset");

		String phonenum = user.getPhonenum();
		int ok = userService.resetPassword(phonenum, password);
		JSONObject jObject = new JSONObject();
		if (ok == 1) {
			// 重设密码成功
			jObject.put("flag", StatusCode.PASS.getState());
		} else {
			// 重设密码失败
			jObject.put("flag", StatusCode.REPEATED.getState());
		}

		return jObject;
	}

	// 判断是否为原密码
	@RequestMapping(value = "/getPassword")
	@ResponseBody
	public JSONObject getPassword(@RequestBody JSONObject js, HttpSession session) {
		String password = js.getString("password");
		User user = (User) session.getAttribute("user");
		String phonenum = user.getPhonenum();
		String mypassword = userService.getPassword(phonenum);
		JSONObject jObject = new JSONObject();
		if (password.equals(mypassword)) {
			// 为原密码
			jObject.put("flag", StatusCode.PASS.getState());
		} else {
			// 非原密码
			jObject.put("flag", StatusCode.REJECT.getState());
		}
		return jObject;
	}

	// 重设密码
	@RequestMapping(value = "/setpassword")
	@ResponseBody
	public JSONObject setPassword(@RequestBody JSONObject js, HttpSession session) {
		String password = js.getString("password");
		User user = (User) session.getAttribute("user");

		String phonenum = user.getPhonenum();
		int ok = userService.resetPassword(phonenum, password);
		JSONObject jObject = new JSONObject();
		if (ok == 1) {
			// 重设密码成功
			jObject.put("flag", StatusCode.PASS.getState());
		} else {
			// 重设密码失败
			jObject.put("flag", StatusCode.REPEATED.getState());
		}

		return jObject;
	}

	@RequestMapping(value = "/getInfo")
	@ResponseBody
	public JSONObject getInfo(@RequestBody JSONObject js, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String phonenum = user.getPhonenum();
		User newUser = userService.getInfo(phonenum);
		JSONObject jObject = new JSONObject();
		jObject.put("phonenum", newUser.getPhonenum());
		jObject.put("password", newUser.getPassword());
		jObject.put("address", newUser.getAddress());
		jObject.put("city", newUser.getCity());
		jObject.put("department", newUser.getDepartment());
		jObject.put("name", newUser.getName());
		jObject.put("workunit", newUser.getWorkunit());
		jObject.put("duty", newUser.getDuty());
		jObject.put("email", newUser.getEmail());
		jObject.put("QQ", newUser.getQq());
		return jObject;
	}

	// 重设信息
	@RequestMapping(value = "/setInfo")
	@ResponseBody
	public JSONObject setInfo(@RequestBody JSONObject js, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String phonenum = user.getPhonenum();
		User newUser = userService.getInfo(phonenum);
		JSONObject jObject = new JSONObject();
		newUser.setName(js.getString("name"));
		newUser.setWorkunit(js.getString("workunit"));
		newUser.setDepartment(js.getString("department"));
		newUser.setDuty(js.getString("duty"));
		String s = js.getString("address");
		newUser.setProvince(s);
		newUser.setCity(s);
		newUser.setAddress(s);
		newUser.setEmail(js.getString("email"));
		newUser.setQq(js.getString("QQ"));
		int ok = userService.setInfo(newUser);
		if (ok == 1) {
			// 修改信息成功
			jObject.put("flag", StatusCode.PASS.getState());
		} else {
			// 修改信息失败
			jObject.put("flag", StatusCode.REJECT.getState());
		}
		return jObject;
	}

}