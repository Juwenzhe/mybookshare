$(window).load(function(){
	//定义变量区
	var booknameflag=false;
	var pressnameflag=false;
	$("#bookname").blur(function(){
		if($("#bookname").val().length>15){
			$("#bookname-warning").removeClass("noselect").addClass("select");
			$("#bookname-info").removeClass("select").addClass("noselect");
			booknameflag=false;
		}else if($("#bookname").val().length!=0){
			$("#bookname-warning").removeClass("select").addClass("noselect");
			$("#bookname-info").removeClass("noselect").addClass("select");
			booknameflag=true;
		}else{
			$("#bookname-info").addClass("noselect");
			$("#bookname-warning").addClass("noselect");
			booknameflag=false;
		}
	});
	
//	$("#bookname").change(function(){
//		if($("#bookname").val().length>15){
//			$("#bookname-warning").removeClass("noselect").addClass("select");
//			$("#bookname-info").removeClass("select").addClass("noselect");
//			booknameflag=false;
//		}else if($("#bookname").val().length!=0){
//			$("#bookname-warning").removeClass("select").addClass("noselect");
//			$("#bookname-info").removeClass("noselect").addClass("select");
//			booknameflag=true;
//		}else{
//			$("#bookname-info").addClass("noselect");
//			$("#bookname-warning").addClass("noselect");
//			booknameflag=false;
//		}
//	});
	
	$("#bookprice").blur(function(){
		if($("#bookprice").val()>15){
			$("#bookprice-warning").removeClass("noselect").addClass("select");
			$("#bookprice-info").removeClass("select").addClass("noselect");
		}else if($("#bookprice").val()<=15 && $("#bookprice").val()!="" && $("#bookprice").val()>=0){
			$("#bookprice-warning").removeClass("select").addClass("noselect");
			$("#bookprice-info").removeClass("noselect").addClass("select");
		}else{
			$("#bookprice").val("");
			$("#bookprice-info").addClass("noselect");
			$("#bookprice-warning").addClass("noselect");
		}
	});
	
	$("#bookscore").blur(function(){
		if($("#bookscore").val()>100){
			$("#bookscore-warning").removeClass("noselect").addClass("select");
			$("#bookscore-info").removeClass("select").addClass("noselect");
		}else if($("#bookscore").val()<=100 && $("#bookscore").val()!="" && $("#bookscore").val()>=0){
			$("#bookscore-warning").removeClass("select").addClass("noselect");
			$("#bookscore-info").removeClass("noselect").addClass("select");
		}else{
			$("#bookscore").val("");
			$("#bookscore-info").addClass("noselect");
			$("#bookscore-warning").addClass("noselect");
		}
	});
	
	$("#pressname").blur(function(){
		if($("#pressname").val().length>15){
			$("#pressname-warning").removeClass("noselect").addClass("select");
			$("#pressname-info").removeClass("select").addClass("noselect");
			pressnameflag=false;
		}else if($("#pressname").val().length!=0){
			$("#pressname-warning").removeClass("select").addClass("noselect");
			$("#pressname-info").removeClass("noselect").addClass("select");
			pressnameflag=true;
		}else{
			$("#pressname-info").addClass("noselect");
			$("#pressname-warning").addClass("noselect");
			pressnameflag=false;
		}
	});
	
	$("#submi").click(function(){
		var options = $("#select-options")[0].options;
		var hasuser = $("#hidden-name").val()==""?false:true;
		if(hasuser){
			for (var i = 0; i < options.length; i++) {
				if(options[i].selected){
					$("#cateid").val(options[i].value);
					break;
				};
			}
			if(booknameflag && pressnameflag){
				$("#submi").attr("type","submit");
				$("#submi").click;
			}
		}else{
			window.location="/BookShare/login?resCode=301&lastpage=welcome"
		}
		
	});
})