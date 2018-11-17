<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录页面</title>
<link rel="stylesheet" type="text/css" href="/BookShare/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/BookShare/css/default.css">
<link rel="stylesheet" type="text/css" href="/BookShare/css/styles01.css">
</head>
<body>

<!-- 容错区 -->
<c:if test="${param.resCode eq '201'}"><script>alert("用户名不存在或密码错误！");</script></c:if>
<c:if test="${param.resCode eq '501'}"><script>alert("恭喜你注册成功！来试一试首次登录吧！");</script></c:if>
<c:if test="${param.resCode eq '502'}"><script>alert("恭喜你注册成功！详细信息请先登录到个人中心查看！");</script></c:if>
<c:if test="${param.resCode eq '301'}"><script>alert("请先登录！");</script></c:if>
	<article class="htmleaf-container">
		<header class="htmleaf-header">
		</header>
		<div class="panel-lite">
			<div class="thumbur">
				<div class="icon-lock"></div>
			</div>
			<h4>用户登录</h4>
			<form method="post" action="/BookShare/LoginServlet?lastpage=${param.lastpage}">
			<div class="form-group">
				<input id="username" name="username" required="required" class="form-control" /> <label
					class="form-label">用户名 </label>
			</div>
			<div class="form-group">
				<input id="password" name="password" type="password" required="required" class="form-control" /> <label
					class="form-label">密 码</label>
			</div>
			<a href="#">忘记密码 ? </a>
			<a href="/BookShare/register">注册</a>
			<c:forEach begin="1" end="15">&nbsp;</c:forEach>
			<a href="/BookShare/welcome">暂不登录</a>
			<button class="floating-btn" id="loginbtn" type="submit">
				<i class="icon-arrow"></i>
			</button>
			</form>
		</div>

	</article>
	<script src="/BookShare/scripts/jquery-2.1.1.min.js"></script>
</body>
</html>