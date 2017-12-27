<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>登录</title>
		<%
			String path =request.getContextPath();
			String basePath=request.getScheme()+"://"
			+request.getServerName()+":"+request.getServerPort()
			+path+"/";
			request.setAttribute("basePath", basePath);
		%>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="<%=basePath%>/static/css/mjjstyle.css" /> 
		<link rel="stylesheet" href="<%=basePath%>/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
		<script src="<%=basePath%>/static/js/jquery-1.11.3.min.js"></script>
		<script src="<%=basePath%>/static/js/login.js"></script>
		<script src="<%=basePath%>/static/js/findPassword.js"></script>
		<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" ></script>
		<script>
			$(document).ready(function(){		
	    
	    	$("#register").click(function(){
		    $("#register-body").show();
		    $("#login-body").hide();
		    $("#login").removeClass("active");
		    $("#register").addClass("active");
		    
		  });
	    	    
	     $("#login").click(function(){
		   $("#login-body").show();
		   $("#register-body").hide();
		   $("#login").addClass("active")
		   $("#register").removeClass("active");
		   
		  });		 
	  }); 	
			
			//验证只能为数字 
			function checkNumber(obj){ 
			var reg = /^[0-9]+$/; 
			if(obj!=""&&!reg.test(obj)){ 
				$("#number").show();
				$("#login").attr("disabled",true);  
			} 
			else{
				$("#number").hide();
				$("#login").attr("disabled",false);
			}  
			}
			
			//验证只能是字母和数字 
			function checkZmOrNum(zmnum){ 
			var zmnumReg=/^[0-9a-zA-Z]*$/; 
			if(zmnum!=""&&!zmnumReg.test(zmnum)){ 
				$("#letternumber").show();
			} 
			else 
				$("#letternumber").hide();
			} 
		</script>
	</head>
	<body>
		<div class="wrap bg">			
			<h1 class="my-h1"><strong>基于WEB的微孔板药敏检测结果快速识别系统</strong></h1>			
			<div class="login-register">
				<div class="my-nav center">
				<label id="login" class="nav-r active">登录</label>
			    <label id="register" class="nav-r">注册</label>
			    </div>
			    
			    <div id="login-body" class="center">
				<br>
				<label>账号：<input type="text" id="phone" name="phone" onblur="checkNumber(this.value)"></label><br>
				<span style="color:red" class="none" id="number">只能输入数字</span>
				<br>
				<br>
			    <label>密码：<input type="password" id="password" name="password" onblur="checkZmOrNum(this.value)"></label><br>
			    <span style="color:red" class="none" id="letternumber">只能输入字母或数字</span>
			    <br>
			    <button  style="color:red;margin-left:170px" class=" none-button" onclick="checkout()">忘记密码？</button>
			    <br><br>
			    <div class="center">
				<button type="button" class="btn btn-primary" onclick="login()" id="login">
					<i style="color:white;padding-left:60px;padding-right:60px">登录</i></button>
				</div>
				
				</div>
				
				
				
				<div id="register-body" class="center none">
				<label>账号：<input type="text" id="phone1"></label>
			    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码：<input type="password" id="password1"></label>
			    <br>
			    
				<label>姓名：<input type="text" id="user-name"></label>
				<label>再次确认：<input type="password" id="password-agin"></label>				
				<hr>
			    
				<label>单位：<input type="text" id="enterprise"></label>
				<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部门：<input type="text" id="depart"></label>
				<br>
				 	
			    <label>邮箱：<input type="text" id="email"></label>
			    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;职务：<input type="text" id="position"></label>
			    <br>
			     		
			    <label>地址：<input type="text" id="address"></label>
			    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;QQ：<input type="text" id="QQ"></label>
			    <br>
			    <br>
			    <div class="center">
				<button type="button" class="btn btn-primary" onclick="register()">
					<i style="color:white;padding-left:80px;padding-right:80px">注册</i></button>
				</div>				  			    
				</div>	
				
			</div>		
		</div>
	</body>
</html>
