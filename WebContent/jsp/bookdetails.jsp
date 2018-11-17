<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link href="/BookShare/css/bookdetails.css" rel="stylesheet" type="text/css" />
</head>
<body>
<c:if test="${empty requestScope.book}"><script>window.loaction="search";</script></c:if>
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
							<input type="hidden" id="username" value="${user.username}">
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
								<img src="/BookShare/img/java.jpg" width="220px" height="290px">
							</div>
						</td>
						<td class="imgarea01"></td>
						<td class="bookarea">
							<div class="content-container">
							<input type="hidden" id="bookid" value="${book.bookid}">
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
								<div class="bookscore">评分：${score}</div>
								<div class="downloadcnt">下载次数：${book.downloadcnt}</div>
								<div id="down-${book.bookid}" class="boo-details">立即下载</div>
								<div id="add-${book.bookid}" class="boo-details">加入书车</div>
								<div class="box">
								<c:if test="${empty sessionScope.user}">
									<a href='/BookShare/login?lastpage=/BookShare/ShowCommentByPageServlet?bookid=${book.bookid}'>登录</a>
									<input type="hidden" id="buy-username" value="${user.username}" />
								</c:if>
								<%-- <c:if test="${!empty sessionScope.user}">
									<
								</c:if> --%>
									<span class="close"></span>
									<p></p>
								</div>
							</div>
						</td>
					</tr>
					<tr id="child01">
						<td colspan="1">
								<div class="comments-div01">
								详细描述
								</div>
						</td>
					</tr>
					
					<tr id="child02">
						<td colspan="2">
								<div class="bookdescription">${book.bookdescription}</div>
						</td>
					</tr>
					
					<tr id="child01">
						<td colspan="1">
								<div class="comments-div01">
								大家评(共${pagebeancomment.totalRows}条评论)
								</div>
						</td>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${pagebeancomment.data}" var="singleComment">
						<tr>
						<td colspan="3">
								<div class="comments-div01" id="comments-div01">
									<div class="commentusername">评论家：${singleComment.username}</div>
									<div class="commentscore">评分：${singleComment.commentscore}</div>
									<div class="commentime">评论时间：${singleComment.commentime}</div>
									<div class="commentdescription">评论语：${singleComment.commentext}</div>
								</div>
									<div class="comments-div02" id="comments-div02"></div>
						</td>
					</tr>
					</c:forEach>
					
<tfoot>
<tr>
	<td colspan="3">
	<div class="yahoo2">
	<c:if test="${fn:length(pagebeancomment.data) ne 0}">
	<c:if test="${pagebeancomment.currentPage ne 1}">
		<a href="?currentPage=${pagebeancomment.currentPage-1}&bookid=${book.bookid}">&lt; Prev</a>
	</c:if>
	<c:if test="${pagebeancomment.totalPages gt 10}">
		<c:if test="${pagebeancomment.currentPage+8 le pagebeancomment.totalPages}">
		<c:forEach begin="${pagebeancomment.currentPage}" end="${pagebeancomment.currentPage+8}" var="page">
			<c:if test="${pagebeancomment.currentPage eq page}"><span class="current">${page}</span></c:if>
			<c:if test="${pagebeancomment.currentPage ne page}"><a href="ShowCommentByPageServlet?currentPage=${page}&bookid=${book.bookid}">${page}</a></c:if> 
		</c:forEach>...
		<c:forEach begin="${pagebeancomment.currentPage}" end="${pagebeancomment.currentPage+8}" var="page">
			<c:if test="${pagebeancomment.currentPage eq page}"><span class="current">${page}</span></c:if>
			<c:if test="${pagebeancomment.currentPage ne page}"><a href="ShowCommentByPageServlet?currentPage=${page}&bookid=${book.bookid}">${page}</a></c:if> 
		</c:forEach>
		</c:if>
	 	<c:if test="${pagebeancomment.currentPage+8 gt pagebeancomment.totalPages}">
		<c:forEach begin="${pagebeancomment.currentPage}" end="${pagebeancomment.totalPages}" var="page">
			<c:if test="${pagebeancomment.currentPage eq page}"><span class="current">${page}</span></c:if>
			<c:if test="${pagebeancomment.currentPage ne page}"><a href="ShowCommentByPageServlet?currentPage=${page}&bookid=${book.bookid}">${page}</a></c:if> 
		</c:forEach>
		</c:if>
	 </c:if>
	<c:if test="${pagebeancomment.totalPages le 10}">
		<c:forEach begin="1" end="${pagebeancomment.totalPages}" var="page">
			<c:if test="${pagebeancomment.currentPage eq page}"><span class="current">${page}</span></c:if>
			<c:if test="${pagebeancomment.currentPage ne page}"><a href="ShowCommentByPageServlet?currentPage=${page}&bookid=${book.bookid}">${page}</a></c:if> 
		</c:forEach>
	</c:if>
	<c:if test="${pagebeancomment.totalPages ne pagebeancomment.currentPage}">
	<a href="/BookShare/ShowCommentByPageServlet?currentPage=${pagebeancomment.currentPage+1}&bookid=${book.bookid}">Next &gt;</a>
	</c:if>
	</c:if>
	</div>
	</td>
</tr>
</tfoot>
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
	<script src="/BookShare/scripts/jzoom.js"></script>
	<script src="/BookShare/scripts/page.js"></script>
	<!-- <script src="/BookShare/scripts/searchtable.js"></script> -->
	<script>
	$('.jzoom').jzoom({bgColor: "#222"});
	$(document).ready(function () {
        $('.boo-details').each(function(index) {
        	var color = $(this).css('backgroundColor');
        	$(this).click(function(){
        	if(index%2==0){
        		window.location="/BookShare/jsp/download.jsp?bookid="+$("#bookid").val();
        	}else if($("#buy-username").val() !=""){
        		console.log($("#buy-username").val());
        		$('.box').css('backgroundColor', '#DE5347');
        		$('.box').addClass('open'); 
        		$.getJSON("/BookShare/AddBookToCartServlet",
						 {"bookid":$("#bookid").val()},function(data){
							 $('.box').find("p").html(data.bookid);
							 setTimeout(test,2000); 
						 });
        		}else{
        			$('.box').css('backgroundColor', '#DE5347');
            		$('.box').addClass('open'); 
        		}
        	});
        	});
        
        $('.close').click(function () {
        	 $('.box').removeClass('open');
        	 $('.box').css('backgroundColor', 'transparent');
        });
	});
	function test(){
   	 $('.box').removeClass('open');
   	 $('.box').css('backgroundColor', 'transparent');
   }
    </script>
</body>
</html>