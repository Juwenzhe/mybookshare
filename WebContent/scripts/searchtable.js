$(function(){

	$(".boo-details").each(function(index){
//		console.log(".boo-details["+index+"]:"+this.id);
		$(this).click(function(){
			var bookid = this.id;
			window.location="/BookShare/ShowCommentByPageServlet?bookid="+bookid;
		})
	});
	$("table tbody tr").each(function(index){
		if(index%2==1){
			$(this).addClass("background01")
		}else if(index%2!=1){
			$(this).addClass("background02")
		}
	});
	/*点击事件的处理*/
	$("#searchbtn").click(function(){
		var searchbookname = $("#searchbookname").val();
		var searchpress = $("#searchpress").val();
		var searchshareuser = $("#searchshareuser").val();
		var minprice = $("#minprice").val();
		var maxprice = $("#maxprice").val();
		var currentPage = getQueryString(currentPage);
		/*对搜索价格预处理*/
		if(minprice >= 0 && maxprice>=0 &&　minprice <=1000 && maxprice <=1000){
			if(minprice =="" && maxprice ==""){
				minprice = 0;maxprice = 0;
			}else if(minprice !="" && maxprice !="" && minprice >= maxprice){
				var temp = minprice;
				minprice = maxprice;
				maxprice = temp;
			}
		
			var url = "/BookShare/ShowBookByConditionServlet?";
			if(searchbookname !=""){
				url+="searchbookname="+searchbookname+"&";
			}
			if(searchpress !=""){
				url+="searchpress="+searchpress+"&";
			}
			if(searchshareuser !=""){
				url+="searchshareuser="+searchshareuser+"&";
			}
			if(minprice !=""){
				url+="minprice="+minprice+"&";
			}
			if(maxprice !=""){
				url+="maxprice="+maxprice+"&";
			}
			if(currentPage !=null){
				url+="currentPage="+currentPage+"&";
			}
			url = url.substring(0,url.length-1);
			console.log(url);
			
//			$("#searchform").attr("action", url);
//			$("#searchbtn").attr("type", "submit");
//			$("#searchbtn").click();
			window.location=url;
		
		}else{
			alert("输入的价格区间有误！")
		}
	});
});

function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
} 