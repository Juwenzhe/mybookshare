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
<link rel="stylesheet" type="text/css" href="/BookShare/css/htmleaf-demo.css">
<link rel="stylesheet" type="text/css" href="/BookShare/css/style.css">
<link rel="stylesheet" type="text/css" href="/BookShare/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/BookShare/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/BookShare/css/main01.css" />
<link rel="stylesheet" type="text/css" href="/BookShare/css/magic.min.css" />
<link href="/BookShare/css/main.css" rel="stylesheet" type="text/css" />
<link href="/BookShare/css/share.css" rel="stylesheet" type="text/css" />
</head>
<body>
<header>
<c:if test="${empty sessionScope.user}"><script>alert("牢记！先登录才可以分享书籍~");</script></c:if>
<c:if test="${empty requestScope.lstcates}"><script>window.location="/BookShare/PreCateServlet";</script></c:if>
<!-- 容错区 -->
<c:if test="${param.resCode eq '202'}"><script>alert("系统异常");</script> </c:if>
<c:if test="${param.resCode eq '203'}"><script>alert("文件格式或图片格式不正确！请重试！");</script></c:if>

<input id="hidden-name" type="hidden" value="${sessionScope.user.username}">
	<div class="htmleaf-container">
		<div class="mobile">
			<div class="mobile-inner">
				<div class="mobile-inner-header">
					<button id="titlebookshare" class="titlebookshare">BookShare</button>
					
					<!-- 登录注册 -->
					<c:if test="${empty sessionScope.user}">
					<a href="/BookShare/register?lastpage=/BookShare/share">注册</a><a href="/BookShare/login?lastpage=/BookShare/share">登录</a></c:if>
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
	<div class="bookplay">
		<form action="/BookShare/ShareBookServlet" method="post" enctype="multipart/form-data">
		<table>
			<thead>
				<tr>
					<td colspan="2">聆听音乐，分享书籍</td>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td class="td1">书名：</td>
					<td class="td2"><input id="bookname" name="bookname" type="text" required="required"  placeholder="请在此认真填写书名，少于15字符"><div id="bookname-info" class="bookname-info">（格式正确）</div><div id="bookname-warning" class="bookname-warning">（超出了15字符限制！）</div></td>
				</tr>
				<tr>
					<td class="td1">分类：</td>
					<td class="td2">
						<select id="select-options" name="select-options">
							<c:forEach items="${requestScope.lstcates}" var="cate">
								<option value="${cate.cateid}">${cate.catename}</option>
							</c:forEach>
						</select>（请选择分类）
						<input id="cateid" type="hidden" name="cateid" value="">
					</td>
				</tr>
				<tr>
					<td class="td1">书的价格：</td>
					<td class="td2"><input id="bookprice" name="bookprice" type="text" required="required"  placeholder="请在此认真填写价格，建议小于10元"><div id="bookprice-info" class="bookprice-info">（价格合理）</div><div id="bookprice-warning" class="bookprice-warning">（价格让人难以接受）</div></td>
				</tr>
				<tr>
					<td class="td1">积分价：</td>
					<td class="td2"><input id="bookscore" name="bookscore" type="text" required="required"  placeholder="请在此认真填写积分价,建议小于100"><div id="bookscore-info" class="bookscore-info">（价格合理）</div><div id="bookscore-warning" class="bookscore-warning">（价格让人难以接受）</div></td>
				</tr>
				<tr>
					<td class="td1">出版社：</td>
					<td class="td2"><input id="pressname" name="prme" type="text" required="required"  placeholder="请在此认真填写书名，少于15字符"><div id="pressname-info" class="pressname-info">（格式正确）</div><div id="pressname-warning" class="pressname-warning">（超出了15字符限制！）</div></td>
				</tr>
				<tr>
					<td class="td1">上传封面：</td>
					<td class="td2"><input type="file" required="required">（仅支持'*.jpg','*.png'）</td>
				</tr>
				<tr>
					<td class="td1">选择上传文件：</td>
					<td class="td2"><input type="file" required="required">（仅支持'*.pdf','*.doc','*.txt'）</td>
				</tr>
				<tr>
					<td class="td3" colspan="2"><textarea rows="1" cols="2" placeholder="描述：建议大于200字，小于500字"></textarea></td>
				</tr>
			</tbody>
			
			<tfoot>
				<tr>
					<td colspan="2"><button id="submi" type="button">确认分享我的电子书</button></td>
				</tr>
			</tfoot>
		</table>
		</form>
		<!-- <audio autoplay="autoplay" loop="loop" controls="controls" style="width: 350px;" src="/BookShare/media/Hallelujah.mp3"></audio> -->
	</div>
	<!-- -------------------------------------------------------------------------------------------------------- -->
	<div id="contactUs">
		<div id="countrySelection">
			<div id="countrySelection-wrapper">
				<ul id="countrySelection-items" style="">
					<div id="countrySelector"></div>
					<li id="wel" class="countrySelection-item"><a href="/BookShare/welcome">BookShare首页</a></li>
					<li id="sea" class="countrySelection-item"><a href="/BookShare/search">书籍搜索</a></li>
					<li id="sha" class="countrySelection-item active"><a href="/BookShare/share">分享书籍</a></li>
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
	<script>window.jQuery || document.write('<script src="/BookShare/scripts/jquery-2.1.1.min.js"><\/script>')</script>
	<script src='/BookShare/scripts/jquery-ui.min.js'></script>
	<script src='/BookShare/scripts/index.js'></script>
	<script src="/BookShare/scripts/main.js"></script>
	<script src="/BookShare/scripts/page.js"></script>
	<script src="/BookShare/scripts/upload.js"></script>
</body>
</html>