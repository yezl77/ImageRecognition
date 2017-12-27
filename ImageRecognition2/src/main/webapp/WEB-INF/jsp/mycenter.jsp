<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>个人中心</title>
		<%
			String path =request.getContextPath();
			String basePath=request.getScheme()+"://"
			+request.getServerName()+":"+request.getServerPort()
			+path+"/";
		%>
		<link rel="stylesheet" href="<%=basePath%>/static/css/mjjstyle.css" />
		<link rel="stylesheet" href="<%=basePath%>/static/css/lbstyle.css" />
		<script type="text/javascript" src="<%=basePath%>/static/js/menuskip.js"></script>
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="<%=basePath%>/static/js/jquery-1.11.3.min.js"></script>
		<script src="<%=basePath%>/static/js/jquery.validate.min.js"></script>
		<script src="<%=basePath%>/static/js/mycenter.js"></script>
		
	</head>
	<body>
		<div class="wrap">			
			<div class="head">
				<span class="head-font-user">
					<strong>基于WEB的微孔板药敏检测结果快速识别系统</strong>
				</span>
				<button onclick="quit()" style="color:red" class="float-right padd none-button">退出</button>
				<label class="float-right padd-top">,欢迎你</label>
				<label id="user-name" class="float-right padd-top">xxx</label>
			</div>

        	<div class="body-left">
         		<ul class="ul-body">
					<li data-id="img-recog" class="block">
						<button onclick="uploadimage()" class="none-button">
							<span class="glyphicon glyphicon-camera">&nbsp;图像识别
								<span class="glyphicon glyphicon-menu-right"></span>
							</span>
						</button>
					</li>
					<li data-id="history" class="block">
						<button onclick="history()" class="none-button">
							<span class="glyphicon glyphicon-time">&nbsp;历史记录
								<span class="glyphicon glyphicon-menu-right"></span>
							</sapn>	
						</button>
					</li>
					<li data-id="my-center" class="block active">
						<button onclick="mycenter()" class="none-button">
							<span class="glyphicon glyphicon-user">&nbsp;个人中心
								<span class="glyphicon glyphicon-menu-right"></span>
							</sapn>
						</button>
					</li>
					<li data-id="search" class="block">
						<button onclick="search()" class="none-button">
							<span class="glyphicon glyphicon-search">&nbsp;&nbsp;搜索&nbsp;
								<span class="glyphicon glyphicon-menu-right"></span>
							</sapn>
						</button>
					</li>
				</ul>			
			</div>
			
			<div class="body-right">
				<div class="">
					<!--标题“未审核名单”-->
					<p class="title">个人信息</p>
					<!--个人信息块-->
					<div class="list-person">
						<div class="row center">
							<div class="col-lg-6">
								<label class="la-person">姓名:</label>
								<input type="text" id="name" class="int-person" value="张三"/>
							</div>
						</div>
	         			<div class="row int-top center">
							<div class="col-lg-6">
								<label class="la-person">手机:</label>
								<input type="text" id="phonenum" class="int-person" value="18888888888" disabled/>
							</div>
						</div>
						<div class="row int-top center">
							<div class="col-lg-6">
								<label class="la-person">单位:</label>
								<input type="text" id="workunit" class="int-person" value="华农华山养殖场"/>
							</div>
						</div>
						<div class="row int-top center">
							<div class="col-lg-6">
								<label class="la-person">部门:</label>
								<input type="text" id="department" class="int-person" value="检查部"/>
							</div>
						</div>
						<div class="row int-top center">
							<div class="col-lg-6">
								<label class="la-person">地址:</label>
								<input type="text" id="address" class="int-person" value="广东省广州市天河区华南农业大学x号楼"/>
							</div>
						</div>
						<div class="row int-top center">
							<div class="col-lg-6">
								<label class="la-person">邮箱:</label>
								<input type="text" id="email" class="int-person" value="18888888888@163.com"/>
							</div>
						</div>
						<div class="row int-top center">
							<div class="col-lg-6">
								<label class="la-person">Q&nbsp;Q:</label>
								<input type="text" id="QQ" class="int-person" value="888888888"/>
							</div>
						</div>
						<div class="row int-top center">
							<div class="col-lg-6">
								<label class="la-person">职务:</label>
								<input type="text" id="duty" class="int-person" value="xxxxx"/>
							</div>
						</div>
						<div class="row int-top center">
							<div class="col-lg-2 center">
								<button class="btn-agree" onclick="reviseMess()">修改</button>
							</div>
							<div class="col-lg-2 center">
								<button class="btn-refuse">取消</button>
							</div>
						</div>
					</div>
				</div>
				<div class="top">
					<!--标题“修改密码”-->
					<p class="title">修改密码</p>	
					<!--修改密码块-->
					<div class="list-person">
						<!--修改密码表单-->
						<form method="post"  class="form-horizontal" id="passwordForm" role="form">
							<!--填写原密码-->
							<div class="form-group">
							    <label for="password" class="col-sm-2 control-label">原密码：</label>
							    <div class="col-sm-3">
							     	<input type="password" class="form-control"  id="sourcepassword" onblur="check()">
							     	<span style="color:red" class="none" id="source">原密码不正确</span>
							    </div>
							</div>
							<!--填写新密码-->
							<div class="form-group">
							    <label for="number" class="col-sm-2 control-label">新密码：</label>
							    <div class="col-sm-3">
							    	<input type="password" class="form-control"   id="newpassword" >
							    </div>
							</div>
							<!--再次填写新密码-->
							<div class="form-group">
							    <label for="number" class="col-sm-2 control-label">确认密码：</label>
							    <div class="col-sm-3">
							      <input type="password" class="form-control" name="confirm_password" id="confirm_password">
							    </div>
							</div>
							<!--确定与取消按钮-->
							<div class="form-group">
								<div class="col-lg-offset-1 col-lg-2 center">
									<button class="btn-agree" onclick="revisePassword()">确定</button>
								</div>
								<div class="col-lg-2 center">
									<button class="btn-refuse">取消</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>			
	</body>
</html>
