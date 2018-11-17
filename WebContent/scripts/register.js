var usernameflag = false;
var passwordflag = false;
var phoneflag = false;

function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
} 


$("#phone").blur(function(){
	if($("#phone").val()!=""){
		var regexc = /^1[34578]\d{9}$/;
		if(!regexc.test($("#phone").val())){
			$("#phone").val("");
			$("#phone").attr('placeholder',"手机格式不正确！请重试！");
		}else{
			phoneflag = true;
		}
	}else{
		$("#phone").attr('placeholder',"手机号必填！");
	}
	
});


$("#regret").click(function(){
	var lastpage = getQueryString("lastpage");
	if(lastpage != null){
		location.href=lastpage;
	}else{
		location.href="welcome";
	}
});

$("#username").blur(function(){
	if($("#username").val().length<=20 && $("#username").val().length!=0){
		$.ajax({
			url:"/BookShare/TestUsernameServlet?username="+$("#username").val(),
			success:function(data){
				if(data=="true"){
					$("#username").val("");
					$("#username").attr("placeholder","用户名已存在！");
				} else{
					usernameflag = true;
				} 
			}
		});
	}else{
		$("#username").val("");
		$("#username").attr('placeholder',"用户名长度大于20字符！请重输！");
	}

});

$("#password").blur(function(){

	if($("#password").val().length<6 &&$("#password").val().length !=0){
		$("#password").val("");
		$("#password").attr('placeholder',"密码长度过短！请重输入！");
	}else if($("#password").val().length>40){
		$("#password").val("");
		$("#password").attr('placeholder',"密码长度过长！请重输入！");
	}else {
		var reg = /^\w+$/;
		if(!reg.test($("#password").val())){
			$("#password").val("");
			$("#password").attr('placeholder',"密码限数字、字母、下划线");
		}else{
			$("#repassword").removeAttr("readonly");
		}
	}
});

$("#repassword").blur(function(){
	if($("#password").val() != $("#repassword").val()){
		$("#repassword").val("");
		$("#repassword").attr('placeholder',"两次输入的密码不一致！请重输入！");
	}else if($("#repassword").val()!=""){
		passwordflag = true;
	}
});

$('#reg-button').click(function() {
//	alert(passwordflag+"[]"+usernameflag+"[]"+phoneflag);
	if($("#password").val() != $("#repassword").val()){
		$("#repassword").val("");
		$("#repassword").attr('placeholder',"两次输入的密码不一致！请重输入！");
	}else if($("#repassword").val()!=""){
		passwordflag = true;
	}
	if(passwordflag && usernameflag && phoneflag){
		$('form').fadeOut(500);
		$('.wrapper01').addClass('form-success');
		setTimeout(function(){
			$('#reg-button').attr("type","submit");
			$('#reg-button').click();//实现了form表单提交前的确认信息！！！强大！耶~
			/* location.href="/BookShare/RegisterServlet"; */
		}, 800);
	}else{
//		alert(passwordflag+"[]"+usernameflag+"[]"+phoneflag);
		location.href="/BookShare/register?resCode=201";
	}

});

/*$("#details-yes").click(function(){
	
});*/