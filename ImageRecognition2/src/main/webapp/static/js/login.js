var curWwwPath=window.document.location.href;  
	//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp  
	var pathName=window.document.location.pathname;  
	var pos=curWwwPath.indexOf(pathName);  
	//获取主机地址，如： http://localhost:8083  
	var localhostPaht=curWwwPath.substring(0,pos);  
	//获取带"/"的项目名，如：/uimcardprj  
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
	var baseRoot = localhostPaht+projectName;  


function login(){
	var phonenum=$("#phone").val();
	var password=$("#password").val();
	
	var phone=document.getElementById("phone");
	
	$.ajax({
		url : baseRoot+"/User/login",
		type : "post",
		data : JSON.stringify({
			"phonenum" : phonenum,
			"password":password
		}),
		contentType:"application/json",
		dataType:"json",
		success : function(data) {
			if(data.flag==1000)
			window.location.href=baseRoot+"/View/uploadimage"; 
			else
				{
				alert("账号密码错误或审核未通过");
				window.location.href=baseRoot+"/View/login"; 
				}
			
		},
		error: function(e) {
			alert("失败");
			}
	});
}

function register(){
	
	var phonenum=$("#phone1").val();
	var password=$("#password1").val();
	var name=$("#user-name").val();
	var workunit=$("#enterprise").val();
	var department=$("#depart").val();
	var duty=$("#position").val();
	var address=$("#address").val();
	var email=$("#email").val();
	var QQ=$("#QQ").val();
	$.ajax({
		url : baseRoot+"/User/register",
		type : "post",
		data : JSON.stringify({
			"phonenum" : phonenum,
			"password":password,
			"name" : name,
			"workunit" : workunit,
			"department" : department,
			"duty" : duty,
			"address" : address,
			"email" : email,
			"QQ" : QQ
		}),
		contentType:"application/json",
		//dataType:"json",
		success : function(data) {
			if(data.flag==1000){
				alert("注册申请已提交,请等待管理员审核");
				window.location.href=baseRoot+"/View/login"; 
			}
			else
			{
				alert(data.flag);
			}
			
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
		
			 alert(XMLHttpRequest.status);
			 alert(XMLHttpRequest.readyState);
			 alert(textStatus);
			 alert(errorThrown);
		}
	});
}

function checkout(){
	window.location.href=baseRoot+"/View/checkout"; 
}