<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>找回密码</title>
		<%
			String path =request.getContextPath();
			String basePath=request.getScheme()+"://"
			+request.getServerName()+":"+request.getServerPort()
			+path+"/";
		%>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="<%=basePath%>/static/css/mjjstyle.css" /> 
		<link rel="stylesheet" href="<%=basePath%>/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
		<script src="<%=basePath%>/static/js/findPassword.js"></script>
		<script src="<%=basePath%>/static/js/jquery-1.11.3.min.js"></script>
	</head>
	<body>
		<div class="wrap bg">			
			<h1 class="my-h1"><strong>基于WEB的微孔板药敏检测结果快速识别系统</strong>
				<h2 class="center">请设置新密码</h2>
			</h1>
			
			<div class="find-pass">

			    <div id="login-body" class="center">
				<a href="checkout.html"><span class="glyphicon glyphicon-circle-arrow-left text-primary" style="font-size: 25px;float:left;margin:10px 0px 0px 25px"></span></a>
				<br><br>
				<label>&nbsp;&nbsp;新密码：<input type="password" id="password"></label>
				<br><br>
				<label>再次输入：<input type="password" id="passwordCopy"></label>
				<br><br>
			    <div class="center">
				<button type="button" class="btn btn-primary" onclick="changePassword()">
					<i style="color:white;padding-left:60px;padding-right:60px">确定</i></a></button>
				</div>				
				</div>
	
			</div>		
		</div>
	</body>
</html>
