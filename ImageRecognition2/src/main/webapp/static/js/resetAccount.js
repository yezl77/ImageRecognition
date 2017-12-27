
function resetAccount(){
	var curWwwPath=window.document.location.href;  
	//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp  
	var pathName=window.document.location.pathname;  
	var pos=curWwwPath.indexOf(pathName);  
	//获取主机地址，如： http://localhost:8083  
	var localhostPaht=curWwwPath.substring(0,pos);  
	//获取带"/"的项目名，如：/uimcardprj  
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
	var baseRoot = localhostPaht+projectName;  
	
	var name=$("#user-name").val();
	var workunit=$("#enterprise").val();
	var department=$("#depart").val();
	var duty=$("#position").val();
	var address=$("#address").val();
	var email=$("#email").val();
	var QQ=$("#QQ").val();
	
	$.ajax({
		url : baseRoot+"/User/account",
		type : "post",
		data : JSON.stringify({
			"name" : name,
			"workunit" : workunit,
			"department" : department,
			"duty" : duty,
			"address" : address,
			"email" : email,
			"QQ" : QQ
		}),
		contentType:"application/json",
		dataType:"json",
		success : function(data) {
			if(data.flag==1000)
				//设置信息成功
				//TODO
				window.location.href=baseRoot+"/View/..."; 
			else
			{
				//设置信息失败
				//TODO
				alert(data.flag);
			}
			
		},
		error: function(e) {
			alert("失败");
			}
	});
}