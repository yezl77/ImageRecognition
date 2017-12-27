window.onload=function(){
	//样品来源
	var array=new Array();
	 array[0]=new Array("人","根目录","人"); //数据格式 ID，父级ID，名称
	 array[1]=new Array("动物","根目录","动物");
	 array[2]=new Array("环境","根目录","环境");
	 array[3]=new Array("禽类","动物","禽类");
	 array[4]=new Array("哺乳动物","动物","哺乳动物");
	 array[5]=new Array("水产类动物","动物","水产类动物");
	 array[6]=new Array("候鸟","动物","候鸟");
	 array[7]=new Array("留鸟","动物","留鸟");
	 array[8]=new Array("鸡","禽类","鸡");
	 array[9]=new Array("鸭","禽类","鸭");
	 array[10]=new Array("鹅","禽类","鹅");
	 array[11]=new Array("猪","哺乳动物","猪");
	 array[12]=new Array("牛","哺乳动物","牛");
	 array[13]=new Array("羊","哺乳动物","羊");
	 array[14]=new Array("鼠","哺乳动物","鼠");
	 array[15]=new Array("犬","哺乳动物","犬");
	 array[16]=new Array("猫","哺乳动物","猫");
	 array[17]=new Array("鱼","水产类动物","鱼");
	 array[18]=new Array("龟","水产类动物","龟");
	 array[19]=new Array("虾","水产类动物","虾");
	 array[20]=new Array("蟹","水产类动物","蟹");
	 array[21]=new Array("蛙","水产类动物","蛙");
	 array[22]=new Array("贝类","水产类动物","贝类");
	 array[23]=new Array("鳄鱼","水产类动物","鳄鱼");
	 array[24]=new Array("土壤","环境","土壤");
	 array[25]=new Array("水","环境","水");
	 array[26]=new Array("空气","环境","空气");
 
 //--------------------------------------------
 //这是调用代码
 var liandong=new CLASS_LIANDONG_YAO(array) //设置数据源
 var s1 = document.getElementById(s1);
 var s2 = document.getElementById(s2);
 var s3 = document.getElementById(s3);
 liandong.firstSelectChange("根目录","s1"); //设置第一个选择框
 liandong.subSelectChange("s1","s2"); //设置子级选择框
 liandong.subSelectChange("s2","s3");
 
 //细菌种类-------------------------------------------------------------
 //数据源 
 var array2=new Array();//数据格式 ID，父级ID，名称
 array2[0]=new Array("革兰氏阳性菌","根目录","革兰氏阳性菌");
 array2[1]=new Array("革兰氏阴性菌","根目录","革兰氏阴性菌");
 array2[2]=new Array("葡萄球菌","革兰氏阳性菌","葡萄球菌");
 array2[3]=new Array("链球菌","革兰氏阳性菌","链球菌");
 array2[4]=new Array("猪链球菌","革兰氏阳性菌","猪链球菌");
 array2[5]=new Array("肠球菌","革兰氏阳性菌","肠球菌"); 
 array2[6]=new Array("李斯特菌","革兰氏阳性菌","李斯特菌");
 array2[7]=new Array("芽孢杆菌属","革兰氏阳性菌","芽孢杆菌属");
 array2[8]=new Array("产气荚膜梭菌","革兰氏阳性菌","产气荚膜梭菌");
 array2[9]=new Array("艰难梭菌","革兰氏阳性菌","艰难梭菌");
 array2[10]=new Array("大肠杆菌","革兰氏阴性菌","大肠杆菌");
 array2[11]=new Array("沙门菌","革兰氏阴性菌","沙门菌");
 array2[12]=new Array("布氏杆菌","革兰氏阴性菌","布氏杆菌");
 array2[13]=new Array("铜绿假单胞菌","革兰氏阴性菌","铜绿假单胞菌");
 array2[14]=new Array("不动杆菌属","革兰氏阴性菌","不动杆菌属");
 array2[15]=new Array("肺炎克雷伯菌","革兰氏阴性菌","肺炎克雷伯菌");
 array2[16]=new Array("奇异变形杆菌","革兰氏阴性菌","奇异变形杆菌");
 array2[17]=new Array("巴氏杆菌","革兰氏阴性菌","巴氏杆菌");
 array2[18]=new Array("副猪嗜血杆菌","革兰氏阴性菌","副猪嗜血杆菌");
 array2[19]=new Array("空肠弯曲杆菌","革兰氏阴性菌","空肠弯曲杆菌");
 
 
 //--------------------------------------------
 //这是调用代码
 //设置数据源
 var liandong2=new CLASS_LIANDONG_YAO(array2);
 var x1 = document.getElementById(x1);
 var x2 = document.getElementById(x2);
 //设置第一个选择框
 liandong2.firstSelectChange("根目录","x1");
 //设置子选择框
 liandong2.subSelectChange("x1","x2");
}

//处理多级选项函数
function CLASS_LIANDONG_YAO(array)
 {
 //数组，联动的数据源
  this.array=array; 
  this.indexName='';
  this.obj='';
  //设置子SELECT
 // 参数：当前onchange的SELECT ID，要设置的SELECT ID
 this.subSelectChange=function(selectName1,selectName2)
  {
  //try
  //{
 var obj1=document.all[selectName1];
 var obj2=document.all[selectName2];
 var objName=this.toString();
 var me=this;
 obj1.onchange=function()
 {
  me.optionChange(this.options[this.selectedIndex].value,obj2.id)
 }
  }
  //设置第一个SELECT
 // 参数：indexName指选中项,selectName指select的ID
  this.firstSelectChange=function(indexName,selectName) 
  {
  this.obj=document.all[selectName];
  this.indexName=indexName;
  this.optionChange(this.indexName,this.obj.id)
  }
 // indexName指选中项,selectName指select的ID
  this.optionChange=function (indexName,selectName)
  {
 var obj1=document.all[selectName];
 var me=this;
 obj1.length=0;
 for(var i=0;i<this.array.length;i++)
 { 
  if(this.array[i][1]==indexName)
  {
  //alert(this.array[i][1]+" "+indexName);
 obj1.options[obj1.length]=new Option(this.array[i][2],this.array[i][0]);
  }
 }
  } 
 }
 
