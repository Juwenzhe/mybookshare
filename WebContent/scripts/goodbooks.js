$(document).ready(function(){
//	ShowCategory();//分类展示
//	showBookcnt();
	showpercentbyCate();
	downloadtip();
	guess();
	showPeoplecntAndBooks();
	$("#onatherGroup").click(guess);
});
//---------书籍分类比例-------
function showpercentbyCate(){
	$.ajax({
		url:"/BookShare/ShowPercentByCate",
		dataType:'json',
		success:function(data){
			var jsondata = eval(data);
			var catedata = jsondata.catedata;
			var catesdetails = jsondata.catesdetails;
			
			option = {
				    title : {
				        text: '书库中图书类别比例',
				        textStyle: {  
			                fontWeight: 'normal',              //标题颜色  
			                color: '#ffffff'  
			            },  
				        x:'center'
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    legend: {
				        orient: 'vertical',
				        left: 'left',
				        data: catedata,
				        textStyle: {  
			                fontWeight: 'normal',              //标题颜色  
			                color: '#ffffff'  
			            },
				    },
				    series : [
				        {
				            name: '图书种类',
				            type: 'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            data:catesdetails,
				            itemStyle: {
				                emphasis: {
				                    shadowBlur: 10,
				                    shadowOffsetX: 0,
				                    shadowColor: 'rgba(0, 0, 0, 0.5)'
				                }
				            }
				        }
				    ]
				};
			var myChart01 = echarts.init(document.getElementById("showpercentbyCate"));
			myChart01.setOption(option);
		}
	})
}
//---------下载总榜------------
function downloadtip(){
	$.ajax({
		url:"/BookShare/BooksDldCntServlet",
		dataType:'json',
		success:function(data){
			var jsondata = eval(data);
			var ydata = jsondata.ydata;
			var dldcnt = jsondata.dldcnt;
			
			option = {
				    title: {
				        text: '图书下载总量排行',
				        subtext: '书名',
				        textStyle:{
				        	color:'#fff',
				        }
				    },
				    tooltip: {
				        trigger: 'axis',
				        axisPointer: {
				            type: 'shadow'
				        }
				    },
				    legend: {},
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    xAxis: {
				        type: 'value',
				        boundaryGap: [0, 0.01]
				    },
				    yAxis: {
				        type: 'category',
				        data: ydata,
				    },
				    series: [
				        {
				            name: '下载总次数',
				            type: 'bar',
				            data: dldcnt,
				        }
				    ]
				};
			var myChart02 = echarts.init(document.getElementById("BooksDldCnt"));
			myChart02.setOption(option);
		}
	})
}
//---------猜你喜欢-------
function guess(){
	$.ajax({
		url:"/BookShare/Guess4BooksServlet",
		dataType:'json',
		success:function(data){
			var jsondata = eval(data);
			var bookid = jsondata.bookid;
			var path = "/BookShare/img/";
			for (var i = 0; i < jsondata.bookid.length; i++) {
				console.log(jsondata.bookid[i]);
				$("#guessbooks0"+i+" img").attr("src",path+jsondata.bookid[i]+".jpg");
			}
		}
	})
}
//---------书籍总量增长-------
function showPeoplecntAndBooks(){
	$.ajax({
		url:"/BookShare/ShowPeoBooCntServlet",
		dataType:'json',
		success:function(data){
			var jsondata = eval(data);
			
			var date = jsondata.date;
			var sque = (date.length%2==1)?((date.length-1)/2):((date.length)/2);
			for(i=0;i<sque;i++){
				var temp = date[i];
				date[i] = date[date.length-1-i];
				date[date.length-1-i] = temp;
			}
			var peopledata = jsondata.peopledata;
			for(i=0;i<sque;i++){
				var temp = peopledata[i];
				peopledata[i] = peopledata[peopledata.length-1-i];
				peopledata[peopledata.length-1-i] = temp;
			}
			var bookscnt = jsondata.bookscnt;
			for(i=0;i<sque;i++){
				var temp = bookscnt[i];
				bookscnt[i] = bookscnt[bookscnt.length-1-i];
				bookscnt[bookscnt.length-1-i] = temp;
			}
			
			option = {
				    title: {
				        text: '网站最新注册人数和藏书图',
				        textStyle:{
				        	color:'#fff',
				        }
				    },
				    tooltip: {
				        trigger: 'axis'
				    },
				    legend: {
				        data:['注册人数','藏书量']
				    },
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    toolbox: {
				        feature: {
				            saveAsImage: {}
				        }
				    },
				    xAxis: {
				        type: 'category',
				        boundaryGap: false,
				        data: date
				    },
				    yAxis: {
				        type: 'value'
				    },
				    series: [
				        {
				            name:'注册人数',
				            type:'line',
				            stack: '总量',
				            smooth: true,
				            showSymbol: false,
				            symbol: false,
				            lineStyle: {
				                normal: {
				                    color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
				                        offset: 0.7, color: '#993CED' // 0% 处的颜色
				                    }, {
				                        offset: 1, color: '#56D9FC' // 100% 处的颜色
				                    }], false),
				                    width: 2,
				                },
				            },
				            data:peopledata,
				        },
				        {
				            name:'藏书量',
				            type:'line',
				            stack: '总量',
				            smooth: true,
				            showSymbol: false,
				            symbol: false,
				            lineStyle: {
				                normal: {
				                    color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
				                        offset: 0.7, color: '#009900' // 0% 处的颜色
				                    }, {
				                        offset: 1, color: '#119900' // 100% 处的颜色
				                    }], false),
				                    width: 2,
				                },
				            },
				            data:bookscnt,
				        }
				    ]
				};
			var myChart03 = echarts.init(document.getElementById("line-pic"));
			myChart03.setOption(option);
		}
	})
}
