<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<%
			String path =request.getContextPath();
			String basePath=request.getScheme()+"://"
			+request.getServerName()+":"+request.getServerPort()
			+path+"/";
			request.setAttribute("basePath", basePath);
		%>
</head>
<body>
	<img id="image" src="" />
	<br />
	<input type="file" onchange="selectImage(this);" />
	<br />
	<input type="button" onclick="uploadImage();" value="提交" />
	
	<script src="<%=basePath%>/static/js/jquery-1.11.3.min.js"></script>
	<script src="<%=basePath%>/static/js/upload.js"></script>
</body>
</html>