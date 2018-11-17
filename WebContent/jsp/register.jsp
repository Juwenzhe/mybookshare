<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BookShare注册页面</title>
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css"
	href="/BookShare/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/BookShare/css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="/BookShare/css/component.css" />
<link rel="stylesheet" type="text/css"
	href="/BookShare/css/styles02.css">
<script src="/BookShare/scripts/modernizr.custom.25376.js"></script>
</head>
<body>
<!-- 容错区 -->
<c:if test="${param.resCode eq '201'}"><script>alert("注册失败，请稍后重试！")</script></c:if>
<c:if test="${param.resCode eq '502'}"><script>alert("系统故障，注册失败，请稍后重试！")</script></c:if>


	<div id="perspective" class="perspective effect-laydown">
		<div class="container">
			<div class="wrapper">
				<!-- wrapper needed for scroll -->

				<header class="codrops-header"> </header>
				<div class="main clearfix">
					<div class="column">

						<canvas id="canvas" width="920" height="400">您的浏览器不支持canvas技术哦~</canvas>
						<p>
							<button id="showMenu">注&nbsp;&nbsp;册</button>
							<button  id="regret">返&nbsp;&nbsp;回</button>
						</p>

					</div>
				</div>
				<!-- /main -->
			</div>
			<!-- wrapper -->
		</div>
		<!-- /container -->
		<nav class="outer-nav top horizontal">

			<div class="htmleaf-container">
				<div class="wrapper01">
					<form class="form" method="post" action="/BookShare/RegisterServlet">
						<div class="container01">
							<div class="details-info">
								<h1>Welcome</h1>
								<input id="username" name="username" type="text" placeholder="请输入用户名" required="required">
								<input id="password" name="password" type="password" placeholder="请输入密码" required="required">
								<input id="repassword" name="repassword" type="password" placeholder="请确认密码" required="required" readonly="readonly">
								<input id="phone" name="phone" type="text" placeholder="联系电话" required="required"><br/>
								<button type="button" id="details-info">详细信息</button>
								<button type="button" id="reg-button">确认注册</button>
							</div>
							<div class="btn-back">
								<p>您的详细信息</p>
								<input id="truename" name="truename" type="text" placeholder="真实姓名">
								<input type="text" placeholder="出生日期请选择" readonly="readonly"> 
								<input id="birthday" name="birth" class="input-date" type="date" >
								<select class="select-question">
									<option>----请选择问题----</option>
									<option>你喜欢什么电影</option>
									<option>你喜欢什么运动</option>
									<option>你最想去的地方</option>
									<option>你最最好的老师</option>
									<option>你最最喜欢的人</option>
								</select> 
								<input id="question" name="question" type="text" placeholder="问题答案">
								<input id="cityaddress" name="cityaddress" type="text" placeholder="居住城市">
								<button id="details-yes" type="button" class="details-yes">确定</button>
								<button id="details-no" type="button" class="details-no">取消</button>
							</div>
						</div>
						
					</form>
					<ul class="bg-bubbles">
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<script src="/BookShare/scripts/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="/BookShare/scripts/register.js"></script>
	<script src="/BookShare/scripts/regdetail.js"></script>
	<script src="/BookShare/scripts/classie.js"></script>
	<script src="/BookShare/scripts/menu.js"></script>
	<script src="/BookShare/scripts/time.js"></script>
</body>
</html>