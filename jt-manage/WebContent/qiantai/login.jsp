<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>亰淘</title>
	<link rel="stylesheet" type="text/css" href=".././css/login.css">
	<script type="text/javascript" src=".././js/login.js"></script>
	<style type="text/css">
		.registtaio{
			position: absolute;
			bottom: 5px;
			right:15px;
		}
		section{
			position: relative;
		}
	</style>
</head>
<body>
	<!-- å¤´é¨ -->
	<header>
		<img src=".././img/logo.jpg">
		<div class="header-right">
			后台登录
		</div>
	</header>
	<!-- barnar -->
	<section>
		<div class="left">
			<img src=".././img/show.jpg">
		</div>
		<div class="right">
			<span class="login_h1">登录</span>
			<!-- <span class="login_h2">è´¦æ·åä¸å¯ç ä¸å¹éè¯·éæ°è¾å¥</span> -->
			<span class="login_h2">验证用户名</span>
			<form method="post" action="/login">
				<input type="text" name="user" placeholder="请输入用户名..." class="user">
				<input type="password" name="pass" value="" placeholder="请输入密码..." class="pass">
				<input type="submit" id="login">
			</form>
		</div>
		<div class="registtaio">
			<a href="regist.jsp">注册用户</a>
		</div>
	</section>
	<!-- 尾部 -->
	<footer>
		<p>关于我们 | 联系我们 | 人才招聘 | 商家入驻 | 营销中心 | 手机京淘 | 友情连接 | 销售联盟 | 京淘社区 | 京淘公益 | English Site</p>
		<span>Copyright © 2004 - 2007 京淘jingtao.com 版权所有</span>
	</footer>
</body>
</html>