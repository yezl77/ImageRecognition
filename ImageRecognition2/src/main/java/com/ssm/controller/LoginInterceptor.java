package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, 
			Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			ModelAndView mv)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 获取访问的url
		String url = request.getRequestURI();
		
		//如果是登录
		if(url.indexOf("/User/login")>=0)
			return true;
		
		//如果是登录
		if(url.indexOf("/User/register")>=0)
			return true;
		
		//判断是否已登录
		HttpSession seesion = request.getSession();
		if(seesion.getAttribute("user") != null)
			return true;
		
		/*若不满足以上，拦截，跳转到首页*/
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

}
