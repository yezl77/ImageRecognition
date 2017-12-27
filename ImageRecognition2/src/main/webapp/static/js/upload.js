
var image = '';
function selectImage(file) {
	if (!file.files || !file.files[0]) {
		return;
	}
	var reader = new FileReader();
	reader.onload = function(evt) {
		document.getElementById('viewImage').src = evt.target.result;
		image = evt.target.result;
	}
	reader.readAsDataURL(file.files[0]);
}
function uploadImage() {
	var curWwwPath = window.document.location.href;
	//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp  
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8083  
	var localhostPaht = curWwwPath.substring(0, pos);
	//获取带"/"的项目名，如：/uimcardprj  
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	var baseRoot = localhostPaht + projectName;

	$.ajax({

		type : 'POST',

		url : baseRoot + '/Image/identify',

		data : JSON.stringify({
			"bacterial" : "1",
			"origin" : "2",
			"separateposition" : "3",
			"method" : "96孔板",
			"remark" : "4",
			"province" : "5",
			"city" : "6",
			"location" : "7",
			"image" : image
		}),

		async : false,

		contentType : "application/json",

		dataType : 'json',

		success : function(data) {
//			if (data.success) {
				alert(data.result);
//				alert('成功');
//
//			} else {
//				alert(image);
//				alert('失败');
//
//			}

		},

		error : function(err) {
			alert('故障');

		}

	});

}