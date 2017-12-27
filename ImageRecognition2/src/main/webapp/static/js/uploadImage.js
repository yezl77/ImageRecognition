//定位
var map, geolocation,pos="";
//加载地图，调用浏览器定位服务
map = new AMap.Map('iCenter');
map.plugin('AMap.Geolocation', function() {
	geolocation = new AMap.Geolocation({
		enableHighAccuracy : true,//是否使用高精度定位，默认:true
		timeout : 10000, //超过10秒后停止定位，默认：无穷大
		maximumAge: 0,           //定位结果缓存0毫秒，默认：0
        convert: true,           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
	});
	map.addControl(geolocation);
	geolocation.getCurrentPosition();
	AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
	AMap.event.addListener(geolocation, 'error', onError); //返回定位出错信息
});

//解析定位结果
function onComplete(data) {
	 pos =data.formattedAddress.toString();//标准地址格式
	 document.getElementById("position").innerHTML=pos;//将地址写进html文件
}

//解析定位错误信息
function onError(data) {
	document.getElementById("position").innerHTML = '定位失败';
}

//手动修改定位信息
function setpos(){
	var newpos = document.getElementById("position");
	var str = prompt("请修改你的当前地址：",pos);//修改地址，把原地址信息作为默认内容
	if(str.match("\\S")!=null){//防止用户恶意操作
		pos=str;
		newpos.innerHTML=str;
	}
}

//获得时间日期
function getTime(){
	var time = document.getElementById("autoTime");
	time.innerHTML=new Date().toLocaleString()+"&nbsp;星期"+
							"日一二三四五六".charAt(new Date().getDay());
}



//拍照事件
function getPic(){
	alert("你的电脑没有外接摄像头，请检查USB接口");
}


//上传图片
function getImage(){
	 var myimage=document.getElementById("viewImage");
	 var resultImage=document.getElementById("resultImage");
	 var choose=document.getElementById("btImageChose"); 
	 myimage.src = window.URL.createObjectURL(choose.files[0]);//获取文件路径
	 resultImage.src = window.URL.createObjectURL(choose.files[0]);//获取文件路径
	 //alert(myimage.src);
}



//防止照片恶意上传
function errorImage(){
		var myimage=document.getElementById("viewImage");
		myimage.alt="你还没有选择图片，请拍摄或从本地上传一张图片！";
		alert("上传失败，可能所选文件为非图片文件或图片文件已损坏，请重新选择上传。");
}



