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
<link href="/BookShare/css/juwenzhedetails.css" rel="stylesheet"
	type="text/css" />
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
							<a href="/BookShare/register?lastpage=/BookShare/introduction">注册</a>
							<a href="/BookShare/login?lastpage=/BookShare/introduction">登录</a>
						</c:if>
						<c:if test="${!empty sessionScope.user}">
							<a href="/BookShare/self">您好，${user.username}</a>
						</c:if>

						<div class="mobile-inner-header-icon mobile-inner-header-icon-out">
							<span></span><span></span>
						</div>
					</div>
					<div class="mobile-inner-nav">
						<a href="#">购书车</a> <a href="#">消息中心</a><a href="#">个人中心</a>
						<c:if test="${!empty sessionScope.user}">
							<a href="LogoutServlet">注销</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<!-- -------------------------------------------------------------------------------------------------------- -->
		<div class="bookplay">
			<table>
				<thead>
					<tr>
						<td class="imgarea">
							<div class="jzoom">
								<img src="/BookShare/img/java.jpg" width="240px" height="280px">
							</div>
						</td>
						<td class="bookarea" colspan="2">
							<div class="content-container">
								<div class="name">Name：Jarvan&nbsp;（鞠文哲）</div>
								<div class="birthday">Birthday：1992-11-17</div>
								<div class="school">School NO.1：TJUT</div>
								<div class="school">School NO.2：HEBUT</div>
								<div class="bookdescription">Motto：<br>
								<textarea readonly="readonly">Efficiency comes from diligence. shortage in the play, was destroyed along with the line into Si.</textarea></div>
							</div>
						</td>
					</tr>
				</thead>
				<!-- <tbody>
					<tr>
						<td colspan="3">
						</td>
					</tr>
				</tbody> -->
			</table>
			<div id="element_id">
				<ul>
					<li><img alt="脚本之家" id="jb51net-pic" src="/BookShare/img/jb51net.jpg"></li>
    				<li><img alt="jquery之家" id="jQuery-pic" src="/BookShare/img/jQuery.jpg"></li>
    				<li><img alt="echarts" id="echarts-pic" src="/BookShare/img/echarts.jpg"></li>
    				<li><img alt="eclipse" id="eclipse-pic" src="/BookShare/img/eclipse.jpg"></li>
    				<li><img alt="Apache" id="Apache-pic" src="/BookShare/img/Apache.jpg"></li>
    				<li><img alt="jquery" id="html5-pic" src="/BookShare/img/html5.jpg"></li>
    				<li><img alt="jquery" id="java01-pic" src="/BookShare/img/java01.jpg"></li>
    				<li><img alt="jquery" id="js-pic" src="/BookShare/img/js.jpg"></li>
    				<li><img alt="jquery" id="jsp-pic" src="/BookShare/img/jsp.jpg"></li>
    				<li><img alt="jquery" id="ajax-pic" src="/BookShare/img/ajax.jpg"></li>
    				<li><img alt="jquery" id="mysql-pic" src="/BookShare/img/mysql.jpg"></li>
    				<li><img alt="脚本之家" id="jb51net-pic" src="/BookShare/img/jb51net.jpg"></li>
    				<li><img alt="jquery之家" id="jQuery-pic" src="/BookShare/img/jQuery.jpg"></li>
    				<li><img alt="echarts" id="echarts-pic" src="/BookShare/img/echarts.jpg"></li>
    				<li><img alt="eclipse" id="eclipse-pic" src="/BookShare/img/eclipse.jpg"></li>
    				<li><img alt="Apache" id="Apache-pic" src="/BookShare/img/Apache.jpg"></li>
    				<li><img alt="jquery" id="html5-pic" src="/BookShare/img/html5.jpg"></li>
    				<li><img alt="jquery" id="java01-pic" src="/BookShare/img/java01.jpg"></li>
    				<li><img alt="jquery" id="js-pic" src="/BookShare/img/js.jpg"></li>
    				<li><img alt="jquery" id="jsp-pic" src="/BookShare/img/jsp.jpg"></li>
    				<li><img alt="jquery" id="ajax-pic" src="/BookShare/img/ajax.jpg"></li>
    				<li><img alt="jquery" id="mysql-pic" src="/BookShare/img/mysql.jpg"></li>
  				</ul>
			</div>
		</div>

		<!-- -------------------------------------------------------------------------------------------------------- -->
		<div id="contactUs">
			<div id="countrySelection">
				<div id="countrySelection-wrapper">
					<ul id="countrySelection-items" style="">
						<div id="countrySelector"></div>
						<li id="wel" class="countrySelection-item"><a
							href="/BookShare/welcome">BookShare首页</a></li>
						<li id="sea" class="countrySelection-item"><a
							href="/BookShare/search">书籍搜索</a></li>
						<li id="sha" class="countrySelection-item"><a
							href="/BookShare/share">分享书籍</a></li>
						<li id="boo" class="countrySelection-item"><a
							href="/BookShare/goodbooks">好书推荐</a></li>
						<li id="ide" class="countrySelection-item"><a
							href="/BookShare/ideas">读书心得</a></li>
						<li id="sel" class="countrySelection-item"><a
							href="/BookShare/self">个人中心</a></li>
						<li id="ord" class="countrySelection-item"><a
							href="/BookShare/order">订单中心</a></li>
						<li id="mon" class="countrySelection-item"><a
							href="/BookShare/money">充值中心</a></li>
						<li id="intro" class="countrySelection-item active"><a
							href="/BookShare/introduction">开发人员</a></li>
						<li id="callus" class="countrySelection-item"><a
							href="/BookShare/callus">联系我们</a></li>
						<li id="goo" class="countrySelection-item"><a
							href="/BookShare/goods">周边商城</a></li>
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
		<img src="/BookShare/img/line.jpg" class="last-line" /><br />
		<p>
			© 2016 BookShare HEBUT 网站最终解释权归 [津] <a href="#">河北工业大学</a> <a
				href="#">鞠文哲</a> 所有
		</p>
	</footer>
	<script>window.jQuery || document.write('<script src="/BookShare/scripts/jquery-2.1.1.min.js"><\/script>')</script>
	<script src='/BookShare/scripts/jquery-ui.min.js'></script>
	<script src="/BookShare/scripts/jquery.kxbdmarquee.js"></script>
	<script src='/BookShare/scripts/index.js'></script>
	<script src="/BookShare/scripts/main.js"></script>
	<script src="/BookShare/scripts/page.js"></script>
	<script src="/BookShare/scripts/searchtable.js"></script>
	<script>
	(function(){
		$('#element_id').kxbdMarquee({direction:"right",isEqual:false,scrollAmount:1,scrollDelay:10});
	})();
	</script>
</body>
</html>