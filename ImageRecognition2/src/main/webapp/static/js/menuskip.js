var curWwwPath=window.document.location.href;  
//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp  
var pathName=window.document.location.pathname;  
var pos=curWwwPath.indexOf(pathName);  
//获取主机地址，如： http://localhost:8083  
var localhostPaht=curWwwPath.substring(0,pos);  
//获取带"/"的项目名，如：/uimcardprj  
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
var baseRoot = localhostPaht+projectName;  

function uploadimage(){
	window.location.href=baseRoot+"/View/uploadimage";
}

function history(){
	window.location.href=baseRoot+"/View/history";
}

function mycenter(){
	window.location.href=baseRoot+"/View/mycenter";
	
	
}

function search(){
	window.location.href=baseRoot+"/View/search";
}

function quit(){
	window.location.href=baseRoot+"/View/login";
}