<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>搜索</title>
		<%
			String path =request.getContextPath();
			String basePath=request.getScheme()+"://"
			+request.getServerName()+":"+request.getServerPort()
			+path+"/";
		%>
		<link rel="stylesheet" href="<%=basePath%>/static/css/mjjstyle.css" />
		<link rel="stylesheet" href="<%=basePath%>/static/css/history.css" />
		<link rel="stylesheet" href="<%=basePath%>/static/css/lbstyle.css" />
		<script type="text/javascript" src="<%=basePath%>/static/js/menuskip.js"></script>
		<link rel="stylesheet" href="<%=basePath%>/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"> 
		<script src="<%=basePath%>/static/js/jquery-1.11.3.min.js"></script>
		<script src="<%=basePath%>/static/js/searchImage.js"></script>
		<script>
		$(document).ready(function(){
		  /*点击链接图标显示/隐藏复选框、确定、取消按钮*/
		  $("#link").click(function(){
		    $("#cancel").toggle();
		    $("#confirm").toggle();
		    $("#th-1").toggle();
		    $(".check-box").toggle();
		    
		    /*点击确定按钮弹出发送界面*/
		    $("#confirm").click(function(){
			$("#send").fadeIn(300);
				});
				
				/*点击X按钮退出*/
		  	$("#remove-btn").click(function(){
			$("#send").fadeOut(300);
				});	
				
			});
		
		
		  /*点击取消按钮清除已选择的复选框*/
		  $("#cancel").click(function(){
		   $("[name='checkbox']").removeAttr("checked");
		  });
			
	   });  
	</script>
	</head>
	<body>
		<div id="send" class="send none">
			<div class="">
				<button class="btn-remove" id="remove-btn">
					<span class="glyphicon glyphicon-remove"></span>
				</button>
			</div>
			<label>共选择一项,发送至</label>
			<div class="">
				<button class="background-no marg"><img class="icon-size" src="<%=basePath%>/static/img/qq.jpg"></button>
				<button class="background-no marg"><img class="icon-size" src="<%=basePath%>/static/img/WeChat.jpg"></button>
				<button class="background-no marg"><img class="icon-size" src="<%=basePath%>/static/img/mail.jpg"></button>
			</div>
	
		</div>
		
		
		
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
					<li data-id="my-center" class="block">
						<button onclick="mycenter()" class="none-button">
							<span class="glyphicon glyphicon-user">&nbsp;个人中心
								<span class="glyphicon glyphicon-menu-right"></span>
							</sapn>
						</button>
					</li>
					<li data-id="search" class="block active">
						<button onclick="search()" class="none-button">
							<span class="glyphicon glyphicon-search">&nbsp;&nbsp;搜索&nbsp;
								<span class="glyphicon glyphicon-menu-right"></span>
							</sapn>
						</button>
					</li>
				</ul>		
			</div>
			
			<div class="body-right">
				<div class="time-key">
				<input name="uploadtime1" id="startTime" type="datetime-local" value="2017-06-11T13:25:24"  />
				<label>至</label>
				<input name="uploadtime2"  id="endTime" type="datetime-local" value="2017-06-11T13:25:24"  />
				<input class="marg-left" id="keyword" type="text" placeholder="请输入关键字"/>
				<button class="background-no" onclick="getHistoryByCondition(0,7)"><span class="glyphicon glyphicon-search"></span></button>		
			    </div>
	
	         	<table id="SearchTable"  class="my-table table-striped center">
							<thead>
								<tr>
									<th id="th-1" class="center none">请选择</th>
									<th class="center">上传时间</th>
									<th class="center">图片</th>
									<th class="center">样品种类</th>
									<th class="center">细菌种属</th>
								</tr>
							</thead>
							<tbody>
	
							</tbody>
						</table>
			</div>		
			
			<div class="body-bottom">
					<dl>
						<dd><a href="#">&laquo;</a></dd>
						<dd><a href="#" onclick="getHistoryByCondition(0,7)">1</a></dd>
						<dd><a href="#" onclick="getHistoryByCondition(7,7)">2</a></dd>
						<dd><a href="#" onclick="getHistoryByCondition(14,7)">3</a></dd>
						<dd><a href="#" onclick="getHistoryByCondition(21,7)">4</a></dd>
						<dd><a href="#" onclick="getHistoryByCondition(28,7)">5</a></dd>
						<dd><a href="#" onclick="getHistoryByCondition(35,7)">6</a></dd>
						<dd><a href="#" onclick="getHistoryByCondition(42,7)">7</a></dd>
						<dd><a href="#" onclick="getHistoryByCondition(49,7)">8</a></dd>
						<dd><a href="#" onclick="getHistoryByCondition(56,7)">9</a></dd>
						<dd><a href="#" onclick="getHistoryByCondition(63,7)">10</a></dd>
						<dd><a href="#">&raquo;</a></dd>
					</dl>
			</div>


			
		
		</div>
			<button id="link" class="fixed-link"><span class="glyphicon glyphicon-new-window linkimg"></span></button>
			<button id="confirm" class="fixed-confirm none" >确定</button>
			<button id="cancel" class="fixed-cancel none">取消</button>
	</body>
</html>
