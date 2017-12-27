//设计一个函数，根据不同数据类型显示不同扇形图
function getPieChart(id, chartName, chartData){
	var chart = echarts.init(document.getElementById(id));
    //图表样式设定
	chart.setOption({
    	//设置背景颜色
    	backgroundColor: '#e5eefd',
    	
    	//设置图表标题及位置 
    	title : {
 	        text: chartName,
 	        //subtext: '基于。。。平台',
 	        x:'center'
 	    },
 	    
 	    //鼠标停在相应的项目下将显示相关比例
 	   tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    
 	    //图表显示内容
 	   series : [
	        {
	            name: chartName,
	            type: 'pie', //扇形图显示
	            radius : '55%', //扇形半径
	            center: ['50%', '60%'], //扇形中心点
	            data:chartData,  //后台传进的数据
	            itemStyle: {     //每个数据的样式
	                //设置阴影效果及鼠标停在上面会放大显示数据
	            	emphasis: {
	                    shadowBlur: 10,  
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'//阴影颜色
	                }
	            }
	        }
	    ]
    });
}

//以表格形式显示数据，其中将json数据拼接成字符串以显示在页面上，拼接格式和网页的表格形式参不多，可作为模板
function getTable(id,item1Name,item2Name,tableData){
	var userTable = document.getElementById(id);
	var html='<table class="tableData"><thead>';
	html = html+'<th class="center">'+item1Name+'</th>'+
			'<th class="center">'+item2Name+'</th>'+
			'</thead><tbody>';
	for(i in tableData){
		// 字符串拼接，注意格式
			html = html + '<tr><td>' + tableData[i].name + '</td>'+
			'<td>' + tableData[i].value + '</td></tr>';
	}
	html = html + '</tbody></table>';
	userTable.innerHTML = html ;
}