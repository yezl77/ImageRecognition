window.onload=function(){
	// 路径配置
	require.config({
		paths : {
			 echarts: 'http://echarts.baidu.com/build/dist'
		}
	});
	
	// 使用
	require(
		[ 
		  'echarts', 
		  'echarts/chart/map' // 使用柱状图就加载bar模块，按需加载
		], function(ec) {
		// 基于准备好的dom，初始化echarts图表
		var myChart = ec.init(document.getElementById('main'));
		var ecConfig = require('echarts/config');
		var zrEvent = require('zrender/tool/event');
		option = {
		    
		    // 工具提示
		    tooltip : {
		    	// 显示策略，可选为：true（显示） | false（隐藏）
		    	show: true,
		    	// tooltip主体内容显示策略，只需tooltip触发事件或显示axisPointer而不需要显示内容时可配置该项为false
		    	showContent: true,
		    	// 触发类型，默认数据触发，见下图，可选为：'item' | 'axis'
		        trigger: 'item',
		        // 位置指定，传入{Array}，如[x, y]， 固定位置[x, y]；传入{Function}，如function([x, y]) {return [newX,newY]}，默认显示坐标为输入参数，用户指定的新坐标为输出返回。
		        // position: getTooltipPosition(0,0),
		        // 内容格式器：{string}（Template） | {Function}，支持异步回调
		        /*formatter: function(data){
		            console.log(data);
		            return data[1]+"："+data[5].count;
		        }*/
		        // 拖拽重计算独有，数据孤岛内容格式器：{string}（Template） | {Function}，见表格下方
		        // islandFormatter:
		        // 显示延迟，添加显示延迟可以避免频繁切换，特别是在详情内容需要异步获取的场景，单位ms
		        showDelay: 0,
		        // 隐藏延迟，单位ms
		        hideDelay: 0,
		        // 动画变换时长，单位s，如果你希望tooltip的跟随实时响应，showDelay设置为0是关键，同时transitionDuration设0也会有交互体验上的差别。
		        transitionDuration: 0,
		        // 鼠标是否可进入详情气泡中，默认为false，如需详情内交互，如添加链接，按钮，可设置为true。
		        //enterable: false,
		        // 提示背景颜色，默认为透明度为0.7的黑色
		        backgroundColor: 'rgba(0,0,0,0.5)',
		        // 提示边框颜色
		        borderColor: '#FF7F50',
		        // 提示边框圆角，单位px，默认为4
		        borderRadius: 10,
		        // 提示边框线宽，单位px，默认为0（无边框）
		        borderWidth: 2,
		        // 提示内边距，单位px，默认各方向内边距为5，接受数组分别设定上右下左边距，同css
		        padding: [0,0,0,0],
		        // 坐标轴指示器
		        /*axisPointer:{
		        	// 默认type为line，可选为：'line' | 'cross' | 'shadow' | 'none'(无)，指定type后对应style生效
		        	type: 'line',
		        	// lineStyle设置直线指示器
		        	lineStyle: {
		        		// 颜色
		        		color:'#48b',
		        		// 线条样式，可选为：'solid' | 'dotted' | 'dashed'， 树图还可以选：'curve' | 'broken'
		        		type:'solid',
		        		// 线宽
		        		width:10,
		        		// 折线主线(IE8+)有效，阴影色彩，支持rgba
		        		shadowColor:'rgba(0,0,0,0)',
		        		// 折线主线(IE8+)有效，阴影模糊度，大于0有效
		        		shadowBlur:5,
		        		// 折线主线(IE8+)有效，阴影横向偏移，正值往右，负值往左
		        		shadowOffsetX:3,
		        		// 折线主线(IE8+)有效，阴影纵向偏移，正值往下，负值往上
		        		shadowOffsetY:3
		            },
		            // crossStyle设置十字准星指示器
		            crossStyle:{
		            	// 颜色
		        		color:'#48b',
		        		// 线条样式，可选为：'solid' | 'dotted' | 'dashed'， 树图还可以选：'curve' | 'broken'
		        		type:'solid',
		        		// 线宽
		        		width:10,
		        		// 折线主线(IE8+)有效，阴影色彩，支持rgba
		        		shadowColor:'rgba(0,0,0,0)',
		        		// 折线主线(IE8+)有效，阴影模糊度，大于0有效
		        		shadowBlur:5,
		        		// 折线主线(IE8+)有效，阴影横向偏移，正值往右，负值往左
		        		shadowOffsetX:3,
		        		// 折线主线(IE8+)有效，阴影纵向偏移，正值往下，负值往上
		        		shadowOffsetY:3
		            },
		            // shadowStyle设置阴影指示器，areaStyle.size默认为'auto'自动计算，可指定具体宽度
		            shadowStyle:{
		            	// 颜色
		            	color: 'rgba(150,150,150,0.3)',
		                width: 'auto',
		                // 填充样式，目前仅支持'default'(实填充)
		                type: 'default'
		            }
		        },*/
		        // 文本样式，默认为白色字体
		        textStyle:{
		        	// 颜色
		        	color: '#FF7F50',
		        	// 水平对齐方式，可选为：'left' | 'right' | 'center'
		        	align: 'left',
		        	// 垂直对齐方式，可选为：'top' | 'bottom' | 'middle'
		        	baseline: 'bottom',
		        	// 字体系列
		        	fontFamily: 'Arial, 宋体, sans-serif',
		        	// 字号 ，单位px
		        	fontSize: 20,
		        	// 样式，可选为：'normal' | 'italic' | 'oblique'
		        	fontStyle: 'italic',
		        	// 粗细，可选为：'normal' | 'bold' | 'bolder' | 'lighter' | 100 | 200 |... | 900
		        	fontWeight: 'normal'
		        }
		    },
		    // 值域选择，每个图表最多仅有一个值域控件
		    dataRange: {
		    	// 显示策略，可选为：true（显示） | false（隐藏）
		    	show: true,
		    	// 布局方式，默认为垂直布局，可选为：'horizontal' | 'vertical'
		    	orient: 'horizontal',
		    	// 水平安放位置，默认为全图左对齐，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
		    	x: 'left',
		    	// 垂直安放位置，默认为全图底部，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
		    	y: 'bottom',
		    	// 值域控件背景颜色，默认透明
		    	backgroundColor: 'rgba(255,255,255,0.1)',
		    	// 图例边框颜色
		        borderColor: 'rgba(255,255,255,0.1)',
		        // 图例边框线宽，单位px，默认为0（无边框）
		        borderWidth: 1,
		        // 图例内边距，单位px，默认各方向内边距为5，接受数组分别设定上右下左边距，同css
		        padding: [0,0,0,0],
		        // 各个item之间的间隔，单位px，默认为10，横向布局时为水平间隔，纵向布局时为纵向间隔
		        itemGap: 15,
		        // 图例图形宽度
		        itemWidth: 20,
		        // 图例图形高度
		        itemHeight: 10,
		        // 指定的最小值，eg: 0，默认无，必须参数，唯有指定了splitList时可缺省min。
		        min: 0,
		        // 指定的最大值，eg: 100，默认无，必须参数，唯有指定了splitList时可缺省max
		        max: 100,
		        // 小数精度，默认为0，无小数点，当 min ~ max 间在当前精度下无法整除splitNumber份时，精度会自动提高以满足均分，不支持不等划分
		        precision: 0,
		        // 分割段数，默认为5，为0时为线性渐变，calculable为true是默认均分100份
		        splitNumber: 10,
		        // 自定义分割方式，支持不等距分割。splitList被指定时，splitNumber将被忽略。
		        /*splitList: [
                    {start: 1500},
                    {start: 900, end: 1500},
                    {start: 310, end: 1000},
                    {start: 200, end: 300},
                    {start: 10, end: 200, label: '10 到 200（自定义label）'},
                    {start: 5, end: 5, label: '5（自定义特殊颜色）', color: 'black'},
                    {end: 10}
		        ],*/
		        // 用于设置dataRange的初始选中范围。calculable为true时有效。
		        range: {start: 0, end: 100},
		        // 选择模式，默认开启值域开关，可选single，multiple
		        selectedMode: 'multiple',
		        // 是否启用值域漫游，启用后无视splitNumber和splitList，值域显示为线性渐变
		        calculable : true,
		        // 是否启用地图hover时的联动响应
		        hoverLink: true,
		        // 值域漫游是否实时显示，在不支持Canvas的浏览器中该值自动强制置为false
		        realtime:true,
		        // 值域颜色标识，颜色数组长度必须>=2，颜色代表从数值高到低的变化，即颜色数组低位代表数值高的颜色标识 ，支持Alpha通道上的变化（rgba）
		        color:['#FF0000','#ffff00'],
		        // 内容格式器：{string}（Template） | {Function}，模板变量为'{value}'和'{value2}'，代表数值起始值和结束值，函数参数两个，含义同模板变量，当calculable为true时模板变量仅有'{value}'
		        /*formatter : function(v, v2){
		            if (v2 < 1000) { return '低于' + v2;}
		            else if (v > 1000) { return '高于' + v;}
		            else { return '中'; }
		        },*/
		        // 	值域文字显示，splitNumber生效时默认以计算所得数值作为值域文字显示，可指定长度为2的文本数组显示简介的值域文本，如['高', '低']，'\n'指定换行
		        text:['高','低'],
		        // 默认只设定了值域控件文字颜色
		        textStyle:{
		        	// 颜色
		        	color: '#000',
		        	// 水平对齐方式，可选为：'left' | 'right' | 'center'
		        	align: 'left',
		        	// 垂直对齐方式，可选为：'top' | 'bottom' | 'middle'
		        	baseline: 'bottom',
		        	// 字体系列
		        	fontFamily: 'Arial, 宋体, sans-serif',
		        	// 字号 ，单位px
		        	fontSize: 15,
		        	// 样式，可选为：'normal' | 'italic' | 'oblique'
		        	fontStyle: 'italic',
		        	// 粗细，可选为：'normal' | 'bold' | 'bolder' | 'lighter' | 100 | 200 |... | 900
		        	fontWeight: 'normal'
		        }
		    },
		    
		    // 缩放漫游组件，仅对地图有效
		    roamController: {
		    	// 显示策略，可选为：true（显示） | false（隐藏）
		        show: true,
		        // 水平安放位置，默认为左侧，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
		        x: 'right',
		        // 垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
		        y: 'bottom',
		        // 指定宽度，决定4向漫游圆盘大小，可指定 {number}（宽度，单位px）
		        width: 70,
		        // 指定高度，缩放控制键默认会在指定高度的最下方最大化显示，可指定 {number}（高度，单位px）
		        height:100,
		        // 缩放漫游组件背景颜色，默认透明
		        backgroundColor:'rgba(255,255,255,0.1)',
		        // 缩放漫游组件边框颜色
		        borderColor: 'rgba(255,255,255,0.1)',
		        // 缩放漫游组件边框线宽，单位px，默认为0（无边框）
		        borderWidth: 1,
		        // 缩放漫游组件内边距，单位px，默认各方向内边距为5，接受数组分别设定上右下左边距，同css
		        padding: [0,0,0,0],
		        // 漫游组件文字填充颜色
		        fillerColor:'#fff',
		        // 控制手柄主体颜色
		        handleColor:'#0066CC',
		        // 4向漫游移动步伐，单位px
		        step:20,
		        // 必须，指定漫游组件可控地图类型
		        mapTypeControl: {
		            'china': true
		        }
		    },
		    series : [
		        {
		        	// 图表类型，必要参数！如为空或不支持类型，则该系列数据不被显示。可选为： 
		        	// 'line'（折线图） | 'bar'（柱状图） | 'scatter'（散点图） | 'k'（K线图） 
		        	// 'pie'（饼图） | 'radar'（雷达图） | 'chord'（和弦图） | 'force'（力导向布局图） | 'map'（地图）
		        	type: 'map',
		        	// 系列名称
		        	name: '耐药性',
		        	// 地图类型，支持world，china及全国34个省市自治区
		        	mapType: 'china',
		        	// 是否开启滚轮缩放和拖拽漫游,默认为false（关闭），其他有效输入为true（开启），'scale'（仅开启滚轮缩放），'move'（仅开启拖拽漫游）
		            roam: false,
		            // 图形样式
		            itemStyle:{
		            	// 默认状态下地图的文字
		                normal:{label:{show:true}},
		                // 鼠标放到地图上面显示文字
		                emphasis:{label:{show:true}}
		            },
		            data:[
		                {name: '北京',value: Math.round(Math.random()*100)},
		                {name: '天津',value: Math.round(Math.random()*100)},
		                {name: '上海',value: Math.round(Math.random()*100)},
		                {name: '重庆',value: Math.round(Math.random()*100)},
		                {name: '河北',value: Math.round(Math.random()*100)},
		                {name: '河南',value: Math.round(Math.random()*100)},
		                {name: '云南',value: Math.round(Math.random()*50)},
		                {name: '辽宁',value: Math.round(Math.random()*50)},
		                {name: '黑龙江',value: Math.round(Math.random()*100)},
		                {name: '湖南',value: Math.round(Math.random()*100)},
		                {name: '安徽',value: Math.round(Math.random()*50)},
		                {name: '山东',value: Math.round(Math.random()*100)},
		                {name: '新疆',value: Math.round(Math.random()*100)},
		                {name: '江苏',value: Math.round(Math.random()*100)},
		                {name: '浙江',value: Math.round(Math.random()*50)},
		                {name: '江西',value: Math.round(Math.random()*100)},
		                {name: '湖北',value: Math.round(Math.random()*100)},
		                {name: '广西',value: Math.round(Math.random()*100)},
		                {name: '甘肃',value: Math.round(Math.random()*100)},
		                {name: '山西',value: Math.round(Math.random()*100)},
		                {name: '内蒙古',value: Math.round(Math.random()*100)},
		                {name: '陕西',value: Math.round(Math.random()*50)},
		                {name: '吉林',value: Math.round(Math.random()*100)},
		                {name: '福建',value: Math.round(Math.random()*50)},
		                {name: '贵州',value: Math.round(Math.random()*100)},
		                {name: '广东',value: Math.round(Math.random()*100)},
		                {name: '青海',value: Math.round(Math.random()*100)},
		                {name: '西藏',value: Math.round(Math.random()*50)},
		                {name: '四川',value: Math.round(Math.random()*100)},
		                {name: '宁夏',value: Math.round(Math.random()*100)},
		                {name: '海南',value: Math.round(Math.random()*100)},
		                {name: '台湾',value: Math.round(Math.random()*100)},
		                {name: '香港',value: Math.round(Math.random()*50)},
		                {name: '澳门',value: Math.round(Math.random()*100)}
		            ]
		        },
		    ]
		};
		myChart.setOption(option);
	});
}