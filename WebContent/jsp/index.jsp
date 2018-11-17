<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BookShare</title>
<link rel="stylesheet" type="text/css"
	href="/BookShare/css/htmleaf-demo.css">
<link rel="stylesheet" type="text/css" href="/BookShare/css/style.css">
<link rel="stylesheet" type="text/css"
	href="/BookShare/css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="/BookShare/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/BookShare/css/main01.css" />
<link rel="stylesheet" type="text/css"
	href="/BookShare/css/magic.min.css" />
<link href="/BookShare/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<c:if test="${param.resCode eq '301'}"><script>alert("骚年，你想多了！")</script></c:if>

<header>
<input type="hidden" id="juwenzheoffset" value="">
	<div class="htmleaf-container">
		<div class="mobile">
			<div class="mobile-inner">
				<div class="mobile-inner-header">
					<button id="titlebookshare" class="titlebookshare">BookShare</button>
					
					<!-- 登录注册 -->
					<c:if test="${empty sessionScope.user}">
					<a href="/BookShare/register?lastpage=/BookShare/welcome">注册</a><a href="/BookShare/login?lastpage=/BookShare/welcome">登录</a></c:if>
					<c:if test="${!empty sessionScope.user}">
					<a href="/BookShare/self">您好，${user.username}</a>
					</c:if>
					
					<div class="mobile-inner-header-icon mobile-inner-header-icon-out">
						<span></span><span></span>
					</div>
				</div>
				<div class="mobile-inner-nav">
					<a href="#">购书车</a> <a href="#">消息中心</a><a href="#">个人中心</a>
					<c:if test="${!empty sessionScope.user}"><a href="LogoutServlet">注销</a></c:if>
				</div>
			</div>
		</div>
		<!-- -------------------------------------------------------------------------------------------------------- -->
		<div class="container">
			<div class="box">
				<div class="box-content">
					<div class="box-wrapper">
						Java in Creation<span class="name">Three Billion</span>
						<div class="row">let's see its magic.</div>
					</div>
				</div>
				<div class="box-overlay magictime" data-hover="rotateRight"
					data-return="">
					<img src="/BookShare/img/1.jpg" alt="" />
				</div>
				<a class="link" href="#" target="_blank"></a>
			</div>

			<div class="box">
				<div class="box-content">
					<div class="box-wrapper">
						JQuery<span class="name">Powerful Function</span>
						<div class="row">let's learn it!</div>
					</div>
				</div>
				<div class="box-overlay magictime" data-hover="rotateUp"
					data-return="">
					<img src="/BookShare/img/2.jpg" alt="" />
				</div>
				<a class="link" href="#" target="_blank"></a>
			</div>

			<div class="box">
				<div class="box-content">
					<div class="box-wrapper">
						HTML 5<span class="name">Full of Magic</span>
						<div class="row">just Go ahead!</div>
					</div>
				</div>
				<div class="box-overlay magictime" data-hover="rotateLeft"
					data-return="">
					<img src="/BookShare/img/3.jpg" alt="" />
				</div>
				<a class="link" href="#" target="_blank"></a>
			</div>


			<div class="box">
				<div class="box-content">
					<div class="box-wrapper">
						Linux<span class="name">Magic System</span>
						<div class="row">Debian、RedHat、Slackware</div>
					</div>
				</div>
				<div class="box-overlay magictime" data-hover="rotateRight"
					data-return="">
					<img src="/BookShare/img/4.jpg" alt="" />
				</div>
				<a class="link" href="#" target="_blank"></a>
			</div>

			<div class="box">
				<div class="box-content">
					<div class="box-wrapper">
						Cloud Computing<span class="name">Information Explosion</span>
						<div class="row">Vigorous development</div>
					</div>
				</div>
				<div class="box-overlay magictime" data-hover="rotateDown"
					data-return="">
					<img src="/BookShare/img/5.jpg" alt="" />
				</div>
				<a class="link" href="#" target="_blank"></a>
			</div>

			<div class="box">
				<div class="box-content">
					<div class="box-wrapper">
						Big Data<span class="name">Big Data Era</span>
						<div class="row">Volume、Velocity、Variety、Value、Veracity</div>
					</div>
				</div>
				<div class="box-overlay magictime" data-hover="rotateLeft"
					data-return="">
					<img src="/BookShare/img/6.jpg" alt="" />
				</div>
				<a class="link" href="#" target="_blank"></a>
			</div>
		
	
		</div>
		<!-- -------------------------------------------------------------------------------------------------------- -->
	
	</div>
	<div id="contactUs">
		<div id="countrySelection">
			<div id="countrySelection-wrapper">
				<ul id="countrySelection-items" style="">
					<div id="countrySelector"></div>
					<li id="wel" class="countrySelection-item active"><a href="/BookShare/welcome">BookShare首页</a></li>
					<li id="sea" class="countrySelection-item"><a href="/BookShare/search">书籍搜索</a></li>
					<li id="sha" class="countrySelection-item"><a href="/BookShare/share">分享书籍</a></li>
					<li id="boo" class="countrySelection-item"><a href="/BookShare/goodbooks">好书推荐</a></li>
					<li id="ide" class="countrySelection-item"><a href="/BookShare/ideas">读书心得</a></li>
					<li id="sel" class="countrySelection-item"><a href="/BookShare/self">个人中心</a></li>
					<li id="ord" class="countrySelection-item"><a href="/BookShare/order">订单中心</a></li>
					<li id="mon" class="countrySelection-item"><a href="/BookShare/money">充值中心</a></li>
					<li id="intro" class="countrySelection-item"><a href="/BookShare/introduction">开发人员</a></li>
					<li id="callus" class="countrySelection-item"><a href="/BookShare/callus">联系我们</a></li>
					<li id="goo" class="countrySelection-item active"><a href="/BookShare/goods">周边商城</a></li>
				</ul>
				<div class="countrySelection-paddles">
					<button class="countrySelection-paddle-left icon-chevronleft"
						aria-hidden="true"></button>
					<button class="countrySelection-paddle-right icon-chevronright"
						aria-hidden="true"></button>
				</div>
			</div>
		</div>
	</div>
	</header>
	<footer>
		<img src="/BookShare/img/line.jpg" class="last-line" /><br/><p>© 2016 BookShare HEBUT 网站最终解释权归 [津] <a href="#">河北工业大学</a> <a href="#">鞠文哲</a> 所有</p>
	</footer>
	<script>
		window.jQuery
				|| document
						.write('<script src="/BookShare/scripts/jquery-2.1.1.min.js"><\/script>')
	</script>
	<script src='/BookShare/scripts/jquery-ui.min.js'></script>
	<script src='/BookShare/scripts/index.js'></script>
	<script src="/BookShare/scripts/main.js"></script>
	<script src="/BookShare/scripts/page.js"></script>
</body>
</html>