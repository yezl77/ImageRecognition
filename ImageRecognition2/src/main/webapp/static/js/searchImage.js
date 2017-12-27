
function getHistoryByCondition(start,length){
	var curWwwPath=window.document.location.href;  
	//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp  
	var pathName=window.document.location.pathname;  
	var pos=curWwwPath.indexOf(pathName);  
	//获取主机地址，如： http://localhost:8083  
	var localhostPaht=curWwwPath.substring(0,pos);  
	//获取带"/"的项目名，如：/uimcardprj  
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
	var baseRoot = localhostPaht+projectName;  
	
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
	var keyword=$("#keyword").val();
	$.ajax({
		url : baseRoot+"/Search/getHistoryByCondition",
		type : "post",
		data : JSON.stringify({
			"startTime" : startTime,
			"endTime" : endTime,
			"keyword" : keyword,
			"start":start,
			"length":length
		}),
		contentType:"application/json",
		dataType:"json",
		success : function(data) {
			var table = document.getElementById("SearchTable");
			table.innerHTML="<thead>"
								+"<tr>"
								+"	<th class=center>上传时间</th>"
								+"	<th class=center>图片</th>"
								+"	<th class=center>样品种类</th>"
								+"	<th class=center>细菌种属</th>"
								+"	</tr>"
								+"	</thead>"
								+"	<tbody>"
								+"	</tbody>";
			
			
			var table = document.getElementById("SearchTable");
		   
			for(var id in data.result){
				var date=formatDate(data.result[id].uploadtime,'yyyy-MM-ddHH:mm:ss');
				var tr = document.createElement("tr");
				var td = document.createElement("td");
				var td1 = document.createElement('img');
				td1.setAttribute("style","width:100px;height:75px");
				var td2 = document.createElement("td");
				var td3 = document.createElement("td");
				td.innerHTML = date;
				td.className="award-name";
			//	td1.src = data.result[id].url;
				//alert("读取图片");
				td1.src=baseRoot+"/Search/outputPic?id="+data.result[id].id;
				td1.className="award-name";
				td2.innerHTML = data.result[id].origin;
				td2.className="award-name";
				td3.innerHTML = data.result[id].bacterial;
				td3.className="award-name";
				tr.appendChild(td);
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				table.appendChild(tr);
			}
		},
		error: function(e) {
			alert("失败");
			}
	});
}
function formatDate(date,format)
{
	if(!date)
	{
		return '';
	}
	else if(typeof(date) == "string")
	{
		if("null"==date)
		{
			return '';
		}
		return date;
	}
	else if(typeof(date) == "undefined" || "undefined"==date)
	{
		return '';
	}
	else if(typeof(date) == "object")
	{
		var year = date.year + 1900;
		var month = (date.month + 1)>=10 ? (date.month + 1):"0"+(date.month + 1);
		var day = date.date>=10 ? date.date:"0"+date.date;
		var hours = date.hours>=10 ? date.hours:"0"+date.hours;
		var minutes = date.minutes>=10 ? date.minutes:"0"+date.minutes;
		var seconds = date.seconds>=10 ? date.seconds:"0"+date.seconds;
		if(format && "hh:mi:ss" == format)
		{
			return hours+":"+minutes+":"+seconds
		}
		else if(format && "yyyy-mm-dd" == format)
		{
			return year+"-"+month+"-"+day
		}
		else if(format && "yyyy-mm-dd hh:mi:ss" == format)
		{
			return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds
		}
		else if(format && "yyyy/mm/dd" == format)
		{
			return year+"/"+month+"/"+day
		}
		else if(format && "yyyy/mm/dd hh:mi:ss" == format)
		{
			return year+"/"+month+"/"+day+" "+hours+":"+minutes+":"+seconds
		}
		return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
	}
	return date;
}