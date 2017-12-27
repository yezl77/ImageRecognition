<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	//测试
    int userid=1;
    String origin="样品来源";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>图像识别</title>
		<link rel="stylesheet" href="<%=basePath%>/static/css/mjjstyle.css" />
		<link rel="stylesheet" href="<%=basePath%>/static/css/lbstyle.css" />
		<link rel="stylesheet" href="<%=basePath%>/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<!-- 导入自定义的css样式文件 -->
		<link href="<%=basePath%>/static/css/uploadImage.css" rel="stylesheet" type="text/css">
		<!-- 导入高德地图的javascriptAPI -->
		<script type="text/javascript"
			src="http://webapi.amap.com/maps?v=1.3&key=9e4f29c75ecafeeb491f7812e5bb4bdb&plugin=AMap.Geocoder"></script>
		<script type="text/javascript"
			src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
		<!-- 导入自定义的javascript事件 -->
		<script type="text/javascript" src="<%=basePath%>/static/js/upload.js"></script>
		<script type="text/javascript" src="<%=basePath%>/static/js/uploadImage.js"></script>
		<script type="text/javascript" src="<%=basePath%>/static/js/select.js"></script>
		<script type="text/javascript" src="<%=basePath%>/static/js/menuskip.js"></script>
		<script src="<%=basePath%>/static/js/jquery-1.11.3.min.js"></script>
		<script>
			$(document).ready(function(){
				$("#re-btn").click(function(){
					$("#result").fadeIn(300);
				});
			});
		</script>
		<script>
			$(document).ready(function(){
				$("#remove-btn").click(function(){
					$("#result").fadeOut(300);
				});
			});
		</script>
	</head>
	<body>
		<div class="result" id="result" style="display: none;">
			<div class="buttom">
				<button class="btn-remove" id="remove-btn">
					<span class=" glyphicon glyphicon-remove"></span>
				</button>
			</div>
			<div class="row top">
				<div class="col-lg-4 center">
					<div>
						<img class="imageResult" id="resultImage" onerror="errorImage();" src="<%=basePath%>/static/img/preview1.png"/>
					</div>
					<span class="h3 int-top">缩略图</span>
				</div>
				<div class="col-lg-5">
					<table class="re-table">
						<thead>
							<th>药名</th>
							<th>MIC值</th>
							<th>结果</th>
						</thead>
						<tbody>
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-lg-3">
					<form action=<%=path +"/identifyImaged" %> enctype="multipart/form-data" method="post">
					<input type="hidden" name="user_id" value=<%=userid %>>
						<div>
						    <label>样品来源:</label>
						    <input type="text" class="re-int" id="" value="xxx" name="origin" disabled="disabled">
						</div>
						<div>
						    <label>分离部位:</label>
						    <input type="text" class="re-int" id="" value="xxx" name="separatePosition" disabled="disabled">
						</div>
						<div>
						  	<label>细菌种属:</label>
						    <input type="text" class="re-int" id="" value="xxx" name="bacterial" disabled="disabled">
						</div>
						<div>
						    <label>备注:</label>
						    <input type="text" class="re-int" id="" value="xxx"  name="remark" disabled="disabled">
						</div>
						<div>
						  	<label>时间:</label>
						    <input type="text" class="re-int" id="" value="xxx" disabled="disabled">
						</div>
						<div>
						    <label>位置:</label>
						    <input type="text" class="re-int" id="" value="xxx" name="location" disabled="disabled">
					    </div>
					</form>
				</div>
			</div>
		</div>
		<div class="wrap">
			
			<div class="head">
				<span class="head-font-user">
					基于WEB的微孔板药敏检测结果快速识别系统
				</span>
				<button onclick="quit()" style="color:red" class="float-right padd none-button">退出</button>
				<label class="float-right padd-top">,欢迎你</label>
				<label id="user-name" class="float-right padd-top">xxx</label>
			</div>

        	<div class="body-left">
         		<ul class="ul-body">
					<li data-id="img-recog" class="block active">
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
				<!-- content -->
				<!-- 对内容进行栅格化，对称分为两栏 -->
				<div class="row">
				<!-- 设置拍照按钮 -->
					<div class="col-sm-6 text-center">
						<button id="btCamera" type="button" onclick="getPic();"
							class="btn btn-default btn-lg glyphicon glyphicon-camera btUpload">&nbsp;点击拍摄
						</button>
					</div>
					<!-- 设置从电脑上传图片按钮 -->
					<div class="col-sm-6 text-center">
						<label for="btImageChose"
							class="btn btn-default btn-lg glyphicon glyphicon-open btUpload">&nbsp;选择图片
						</label>
						<!-- 将input file 设为隐藏 -->
						<input type="file" id="btImageChose" accept="image/*"
							style="position: absolute; clip: rect(0, 0, 0, 0);"
						onchange="selectImage(this);">
					</div>
					<!-- 设置预览窗口，大小为240px*240px -->
					<div class="col-sm-6 text-center">
						<div>
							<h3>预览</h3>
							<img class="imageWindow" id="viewImage" onerror="errorImage();" src="<%=basePath%>/static/img/preview1.png"/>
						</div>
					</div>
					<!-- 设置图片信息 -->
					<div class="col-sm-6">
						<div class="imageMes">
							<!-- 设置样品种类 -->
							<div class="row">
								<label class="mesFont col-lg-3 mesHeight">样品来源：</label>
								<div class="col-lg-9 mesHeight">
									<select class="select" id="s1" name="s1" >
 										<option selected></option>
									</select>
									<select class="select" id="s2" name="s2" >
										<option selected></option>
									</select>
									<select class="select" id="s3" name="s3" >
										<option selected></option>
									</select>
								</div>
							</div>
							<!-- 设置分离部位 -->
							<div class="row">
								<label class="mesFont col-lg-3 mesHeight">分离部位：</label>
								<div class="col-lg-9 mesHeight">
									<select class="mesForm">
										<option>唾液</option>
										<option>呕吐物</option>
										<option>胃内容物</option>
										<option>粪便</option>
										<option>小肠内容物</option>
										<option>尿液</option>
										<option>生殖道分泌物</option>
										<option>鼻涕</option>
										<option>痰</option>
										<option>血液</option>
										<option>组织液</option>
										<option>淋巴液</option>
										<option>脑脊液</option>
										
									</select>
								</div>
							</div>
							<!-- 设置细菌种类 -->
							<div class="row">
								<label class="mesFont col-lg-3 mesHeight">细菌种类：</label> 
								<div class="col-lg-9 mesHeight">
									<select class="select" id="x1" name="x1" >
 										<option selected></option>
									</select>
									<select class="select" id="x2" name="x2" >
										<option selected></option>
									</select>
								</div>
							</div>
							<!-- 设置备注信息 -->
							<div class="row">
								<label class="mesFont col-lg-3 mesHeight">&nbsp;&nbsp;&nbsp;&nbsp;备注:</label> 
								<div class="col-lg-9 mesHeight">
									<input class="mesForm" type="text" placeholder="      请填写图片信息" name="信息" />
								</div>
							</div>
							<!-- 自动定位位置信息 -->
							<div class="mesFont row">
								<div class="col-lg-3 mesHeight">
									<label>上传位置：</label>
								</div>
								<div class="col-lg-6 mesHeight">
									<span id="position"></span>
								</div>
								<div class="col-lg-3 mesHeight">
								 	<button class="btn btn-danger btWidth" onclick="setpos();">修改</button>
								</div>
							</div>
							<!-- 自动获取上传时间 -->
							<div class="mesFont row">
								<div class="col-lg-3 mesHeight">
									<label>上传时间：</label>
								</div>
								<div class="col-lg-9 mesHeight" id="autoTime">
									<script type="text/javascript">
										getTime()
									</script>
								</div>
							</div>
							<!-- 确认按钮，只有所有信息填完，按钮才被激活 -->
							<div class="row center">
								<button id="re-btn" class="btn-refuse mesFont btWidth" onclick="uploadImage()">确定</button>
								<button id="" class="btn-refuse mesFont btWidth">取消</button>
							</div>
						</div>
					</div>
				</div>
			</div>
	</body>
</html>
