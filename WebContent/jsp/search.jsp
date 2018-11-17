<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link href="/BookShare/css/searchtable.css" rel="stylesheet" type="text/css" />

</head>
<body>
<c:if test="${empty requestScope.pageBean}"><script>window.location="/BookShare/ShowBookByPageServlet";</script></c:if>
<input type="hidden" id="currentPage" value="${pageBean.currentPage}">
	<header>
		<div class="htmleaf-container">
			<div class="mobile">
				<div class="mobile-inner">
					<div class="mobile-inner-header">
						<button id="titlebookshare" class="titlebookshare">BookShare</button>

						<!-- 登录注册 -->
						<c:if test="${empty sessionScope.user}">
							<a
								href="/BookShare/register?lastpage=/BookShare/search">注册</a>
							<a href="/BookShare/login?lastpage=/BookShare/search">登录</a>
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
						<td colspan="3">
						<form id="searchform" method="post" action="">
							书名：<input id="searchbookname" type="text" placeholder="支持模糊查询">&nbsp;
							出版社：<input id="searchpress" type="text" placeholder="支持模糊查询">&nbsp;
							分享者：<input id="searchshareuser" type="text" placeholder="支持模糊查询">&nbsp;
							价格区间：<input id="minprice" type="text" class="price">-<input id="maxprice" type="text" class="price">
							<button id="searchbtn" type="button" class="click-search">搜索</button><br></form>
						</td>
					</tr>
				</thead>
				<tbody>
				<c:if test="${empty pageBean.data}">
				<tr>
					<td class="bookarea">
							<div class="content-container">
								暂无您要找的图书！如有资源请与大家分享哦~
							</div>
						</td>
					</tr>
				</c:if>
				<c:if test="${!empty pageBean.data}">
				<c:forEach items="${pageBean.data}" var="book">
				<tr>
						<td class="imgarea"><div class="img-container">
								<img alt="" src="/BookShare/img/java.jpg" style="border-radius: 3px;">
							</div></td>
						<td class="bookarea">
							<div class="content-container">
								<div class="bookname">书名：${book.bookname}</div>
								<div class="shareuser">
									分享者：<a href="#">${book.bookshareuser}</a>
								</div>
								<div class="sharetime">分享时间：<fmt:formatDate pattern="yyyy年MM月dd日 HH时mm分" value="${book.booksharetime}"/></div>
								<div class="bookprice">价格：<fmt:formatNumber pattern="￥0.00" value="${book.bookprice}"/></div>
								<div class="scoreprice">积分价：<fmt:formatNumber pattern="@ 0" value="${book.bookscore}"/></div>
								<div class="cate">
									分类：<a href="#">${book.category}</a>
								</div>
								<div class="press">
									出版社：<a href="#">${book.press}</a>
								</div>
								<div class="bookdescription">描述：${book.bookdescription}</div>
								<div class="bookscore">评分：${book.score}</div>
								<div class="downloadcnt">下载次数：${book.downloadcnt}</div>
								<div id="${book.bookid}" class="boo-details">点击进入详情</div>
							</div>
						</td>
					</tr>
				</c:forEach>
				<tfoot>
<tr>
	<td colspan="2">
	<div class="yahoo2">
	<c:if test="${pageBean.currentPage ne 1}">
		<a href="?currentPage=${pageBean.currentPage-1}">&lt; Prev</a>
	</c:if>
	<c:if test="${pageBean.totalPages gt 10}">
		<c:if test="${pageBean.currentPage+8 le pageBean.totalPages}">
		<c:forEach begin="${pageBean.currentPage}" end="${pageBean.currentPage+8}" var="page">
			<c:if test="${pageBean.currentPage eq page}"><span class="current">${page}</span></c:if>
			<c:if test="${pageBean.currentPage ne page}"><a href="ShowBookByPageServlet?currentPage=${page}">${page}</a></c:if> 
		</c:forEach>...
		<c:forEach begin="${pageBean.currentPage}" end="${pageBean.currentPage+8}" var="page">
			<c:if test="${pageBean.currentPage eq page}"><span class="current">${page}</span></c:if>
			<c:if test="${pageBean.currentPage ne page}"><a href="ShowBookByPageServlet?currentPage=${page}">${page}</a></c:if> 
		</c:forEach>
		</c:if>
	 	<c:if test="${pageBean.currentPage+8 gt pageBean.totalPages}">
		<c:forEach begin="${pageBean.currentPage}" end="${pageBean.totalPages}" var="page">
			<c:if test="${pageBean.currentPage eq page}"><span class="current">${page}</span></c:if>
			<c:if test="${pageBean.currentPage ne page}"><a href="ShowBookByPageServlet?currentPage=${page}">${page}</a></c:if> 
		</c:forEach>
		</c:if>
	 </c:if>
	<c:if test="${pageBean.totalPages le 10}">
		<c:forEach begin="1" end="${pageBean.totalPages}" var="page">
			<c:if test="${pageBean.currentPage eq page}"><span class="current">${page}</span></c:if>
			<c:if test="${pageBean.currentPage ne page}"><a href="ShowBookByPageServlet?currentPage=${page}">${page}</a></c:if> 
		</c:forEach>
	</c:if>
	<c:if test="${pageBean.totalPages ne pageBean.currentPage}">
	<a href="/BookShare/ShowBookByPageServlet?currentPage=${pageBean.currentPage+1}">Next &gt;</a>
	</c:if></div>
	</td>
</tr>
		

				</tfoot>
				</c:if>
			</table>
		</div>


		<!-- -------------------------------------------------------------------------------------------------------- -->

		<div id="contactUs">
			<div id="countrySelection">
				<div id="countrySelection-wrapper">
					<ul id="countrySelection-items" style="">
						<div id="countrySelector"></div>
						<li id="wel" class="countrySelection-item"><a
							href="/BookShare/welcome">BookShare首页</a></li>
						<li id="sea" class="countrySelection-item active"><a
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
						<li id="intro" class="countrySelection-item"><a
							href="/BookShare/introduction">开发人员</a></li>
						<li id="callus" class="countrySelection-item"><a
							href="/BookShare/callus">联系我们</a></li>
						<li id="goo" class="countrySelection-item active"><a
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
	<script src='/BookShare/scripts/index.js'></script>
	<script src="/BookShare/scripts/main.js"></script>
	<script src="/BookShare/scripts/page.js"></script>
	<script src="/BookShare/scripts/searchtable.js"></script>
</body>
</html>