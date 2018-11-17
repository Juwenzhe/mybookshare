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
<link href="/BookShare/css/goodbooks.css" rel="stylesheet" type="text/css" />
</head>
<body>
<header>
	<div class="htmleaf-container">
		<div class="mobile">
			<div class="mobile-inner">
				<div class="mobile-inner-header">
					<button id="titlebookshare" class="titlebookshare">BookShare</button>
					
					<!-- 登录注册 -->
					<c:if test="${empty sessionScope.user}">
					<a href="/BookShare/register?lastpage=/BookShare/goodbooks">注册</a><a href="/BookShare/login?lastpage=/BookShare/goodbooks">登录</a></c:if>
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
	</div>
	<!-- -------------------------------------------------------------------------------------------------------- -->
<div class="goodbookscontent">
<div id="goodbooksintro">
	<div id="goodbooksintro-title">好书推荐栏目介绍及公告</div>
	<div id="goodbooksintro-marquee">
		<ul>
		<li>----------------------------------</li>
		<li><a href="#">☆友情链接：河北工业大学☆</a></li>
		<li><a href="#">☆网站开发人员：鞠文哲☆</a></li>
		<li><a href="#">☆本站招募：开发人员、运维工程师☆</a></li>
		<li>-------------------------------------------</li>
		<li><a href="#">Linux.C编程一站式学习</a></li>
		<li><a href="#">Ubuntu实战技巧精粹</a></li>
		<li><a href="#">名师讲坛Android开发实战经典</a></li>
		<li><a href="#">21天学通Linux_C编程</a></li>
		<li><a href="#">Java Web开发实战1200例  第2卷</a></li>
		<li><a href="#">Java编程思想第四版完整中文高清版(免费)</a></li>
		<li><a href="#">Java面试宝典2013版</a></li>
		<li><a href="#">Python高手之路</a></li>
		<li><a href="#">Android源码设计模式解析与实战</a></li>
	</ul>
	</div>
</div>
<div id="showpercentbyCate"></div>
<div id="BooksDldCnt"></div>
<div id="goodbooksguss">
<div id="goodbooksguss-title">猜你喜欢:>[<button id="onatherGroup">换一批</button>]</div>
<div id="goodbooksguss-content">
	<div id="guessbooks00"  class="guessbooks"><img src="" /></div>
	<div id="guessbooks01"  class="guessbooks"><img src="" /></div>
	<div id="guessbooks02"  class="guessbooks"><img src="" /></div>
	<div id="guessbooks03"  class="guessbooks"><img src="" /></div>
	<div id="guessbooks04"  class="guessbooks"><img src="" /></div>
</div>
</div>
<div id="goodbooks-marquee">
	<ul>
		<li><img  src="/BookShare/img/000.jpg" width="80" height="120"></li>
		<li><img  src="/BookShare/img/001.jpg" width="80" height="120"></li>
		<li><img  src="/BookShare/img/002.jpg" width="80" height="120"></li>
		<li><img  src="/BookShare/img/003.jpg" width="80" height="120"></li>
		<li><img  src="/BookShare/img/004.jpg" width="80" height="120"></li>
		<li><img  src="/BookShare/img/005.jpg" width="80" height="120"></li>
		<li><img  src="/BookShare/img/000.jpg" width="80" height="120"></li>
		<li><img  src="/BookShare/img/001.jpg" width="80" height="120"></li>
		<li><img  src="/BookShare/img/002.jpg" width="80" height="120"></li>
		<li><img  src="/BookShare/img/003.jpg" width="80" height="120"></li>
		<li><img  src="/BookShare/img/004.jpg" width="80" height="120"></li>
		<li><img  src="/BookShare/img/005.jpg" width="80" height="120"></li>
	</ul>
</div>
<div id="line-pic"></div>
</div>
	<!-- -------------------------------------------------------------------------------------------------------- -->
	<div id="contactUs">
		<div id="countrySelection">
			<div id="countrySelection-wrapper">
				<ul id="countrySelection-items" style="">
					<div id="countrySelector"></div>
					<li id="wel" class="countrySelection-item"><a href="/BookShare/welcome">BookShare首页</a></li>
					<li id="sea" class="countrySelection-item"><a href="/BookShare/search">书籍搜索</a></li>
					<li id="sha" class="countrySelection-item"><a href="/BookShare/share">分享书籍</a></li>
					<li id="boo" class="countrySelection-item active"><a href="/BookShare/goodbooks">好书推荐</a></li>
					<li id="ide" class="countrySelection-item"><a href="/BookShare/ideas">读书心得</a></li>
					<li id="sel" class="countrySelection-item"><a href="/BookShare/self">个人中心</a></li>
					<li id="ord" class="countrySelection-item"><a href="/BookShare/order">订单中心</a></li>
					<li id="mon" class="countrySelection-item"><a href="/BookShare/money">充值中心</a></li>
					<li id="intro" class="countrySelection-item"><a href="/BookShare/introduction">开发人员</a></li>
					<li id="callus" class="countrySelection-item"><a href="/BookShare/callus">联系我们</a></li>
					<li id="goo" class="countrySelection-item"><a href="/BookShare/goods">周边商城</a></li>
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
	<script src="/BookShare/scripts/jquery-2.1.1.min.js"></script>
	<script src="/BookShare/scripts/jquery.kxbdmarquee.js"></script>
	<script src="/BookShare/scripts/echarts.js"></script>
	<script src='/BookShare/scripts/jquery-ui.min.js'></script>
	<script src='/BookShare/scripts/index.js'></script>
	<script src="/BookShare/scripts/main.js"></script>
	<script src="/BookShare/scripts/page.js"></script>
	<script src="/BookShare/scripts/goodbooks.js"></script>
<script>
(function(){
	$("#goodbooks-marquee").kxbdMarquee({direction:"right",isEqual:false});
	$("#goodbooksintro-marquee").kxbdMarquee({direction:"up",isEqual:false});
})();
</script>
</body>
</html>