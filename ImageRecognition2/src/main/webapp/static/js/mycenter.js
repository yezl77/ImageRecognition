var curWwwPath=window.document.location.href;  
//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp  
var pathName=window.document.location.pathname;  
var pos=curWwwPath.indexOf(pathName);  
//获取主机地址，如： http://localhost:8083  
var localhostPaht=curWwwPath.substring(0,pos);  
//获取带"/"的项目名，如：/uimcardprj  
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
var baseRoot = localhostPaht+projectName; 
window.onload=function(){
	
	$.ajax({
		url : baseRoot+"/User/getInfo",
		type : "post",
		data : JSON.stringify({
			
		}),
		contentType:"application/json",
		dataType:"json",
		success : function(data) {
			document.getElementById('name').value = data.name;
			document.getElementById('phonenum').value = data.phonenum;
			document.getElementById('workunit').value = data.workunit;
			document.getElementById('department').value = data.department;
			document.getElementById('address').value = data.address;
			document.getElementById('email').value = data.email;
			document.getElementById('QQ').value = data.QQ;
			document.getElementById('duty').value = data.duty;
		},
		error: function(e) {
			alert("失败");
			}
	});
	
}

function reviseMess(){
	var name=$("#name").val();
	var workunit=$("#workunit").val();
	var department=$("#department").val();
	var address=$("#address").val();
	var email=$("#email").val();
	var QQ=$("#QQ").val();
	var duty=$("#duty").val();
	$.ajax({
		url : baseRoot+"/User/setInfo",
		type : "post",
		data : JSON.stringify({
			"name" : name,
			"workunit" : workunit,
			"department" : department,
			"address" : address,
			"email" : email,
			"QQ" : QQ,
			"duty" : duty 
		}),
		contentType:"application/json",
		dataType:"json",
		success : function(data) {
			if(data.flag==1000){
				alert("修改成功！");
				window.location.href=baseRoot+"/View/mycenter"; 
			}
			else
				alert("修改失败！");
				
		},
		error: function(e) {
			alert("失败");
			}
	});
}

function check(){
	var password=$("#sourcepassword").val();
	$.ajax({
		url : baseRoot+"/User/getPassword",
		type : "post",
		data : JSON.stringify({
			"password" : password
		}),
		contentType:"application/json",
		dataType:"json",
		success : function(data) {
			if(data.flag==1000){
				$("#source").hide();
			}
			else
				$("#source").show();  
		},
		error: function(e) {
			alert("失败");
			}
	});
}

function revisePassword(){
	
	var password=$("#newpassword").val();
	$.ajax({
		url : baseRoot+"/User/setpassword",
		type : "post",
		data : JSON.stringify({
			"password" : password
		}),
		contentType:"application/json",
		dataType:"json",
		async : false,
		success : function(data) {
			if(data.flag==1000){
				alert("密码修改成功！请重新登录");
				setTimeout(function(){
				    window.location.href = baseRoot+"/View/login";
				},1);
			}
			else
				alert("修改失败！");
				
		},
		error: function(e) {
			alert("resetpassword失败");
			}
	});
}