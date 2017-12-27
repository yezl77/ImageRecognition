package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/View")

public class View {
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/result")
	public String result(){
		return "result";
	}
	
	@RequestMapping(value="/uploadimage")
	public String uploadimage(){
		return "uploadimage";
	}
	
	@RequestMapping(value="/history")
	public String history(){
		return "history";
	}
	
	@RequestMapping(value="/mycenter")
	public String mycenter(){
		return "mycenter";
	}
	
	@RequestMapping(value="/findPassword")
	public String findPassword(){
		return "findPassword";
	}
	
	@RequestMapping(value="/checkout")
	public String checkout(){
		return "checkout";
	}
	@RequestMapping(value="/search")
	public String search(){
		return "search";
	}
}
