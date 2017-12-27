var curWwwPath=window.document.location.href;  
//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp  
var pathName=window.document.location.pathname;  
var pos=curWwwPath.indexOf(pathName);  
//获取主机地址，如： http://localhost:8083  
var localhostPaht=curWwwPath.substring(0,pos);  
//获取带"/"的项目名，如：/uimcardprj  
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
var baseRoot = localhostPaht+projectName; 
var phonenum;

function sendEmail(){
	phonenum=$("#phone").val();
	$.ajax({
		url : baseRoot+"/User/password",
		type : "post",
		data : JSON.stringify({
			"phonenum" : phonenum
			
		}),
		contentType:"application/json",
		dataType:"json",
		success : function(data) {
			alert("验证码已发送到对应邮箱,请查收");
		},
		error: function(e) {
			alert("失败");
			}
	});
	
}

function findPassword(){
	var verificationCode=$("#verificationCode").val();
	phonenum=$("#phone").val();
	$.ajax({
		url : baseRoot+"/User/verify",
		type : "post",
		data : JSON.stringify({
			"verificationCode" : verificationCode,
			"phonenum" : phonenum
		}),
		contentType:"application/json",
		dataType:"json",
		success : function(data) {
			if(data.flag==1000)
				window.location.href=baseRoot+"/View/findPassword";
			else
				alert("验证码不正确");
		},
		error: function(e) {
			alert("失败");
			}
	});
	
}

function changePassword(){
	var password=$("#password").val();
	$.ajax({
		url : baseRoot+"/User/resetpassword",
		type : "post",
		data : JSON.stringify({
			"password" : password,
			"phonenum" : phonenum
		}),
		contentType:"application/json",
		dataType:"json",
		success : function(data) {
			if(data.flag==1000){
				alert("重置成功！请重新登录。");
				window.location.href=baseRoot+"/View/login";
			}
			else
				alert("重置失败");
		},
		error: function(e) {
			alert("失败");
			}
	});
	
}