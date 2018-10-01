<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
	<link rel="stylesheet" type="text/css" href=".././css/regist.css">
	<script type="text/javascript" src=".././js/regist.js"></script>
</head>
<body>
	<!-- 头部 -->
	<header>
		<img src=".././img/logo.jpg">
		<div class="header-right">
			欢迎登陆
		</div>
	</header>
	<!-- 新加 -->
	<div class="newtop">
		<a href="login.jsp">请登陆</a>
		<span>已有账号？</span>
	</div>
	<!-- barnar -->
	<section>
		<div class="right">
			<form method="post" action="/useradd" id="form">
				<input type="text" name="user" placeholder="用户名" class="user">
				<span class="biaoshi">
					<img src=".././img/alert_1.jpg">
					支持中文、字母、数字、“-”、“_”的组合，4-20个字母
				</span>
				<input type="password" value="" placeholder="设置密码" class="pass">
				<span class="biaoshi">
					<img src=".././img/alert_1.jpg">
					建议使用数字、字母和符号两种以上的组合，6-20个字符
				</span>
				<input type="password" name="pass" value="" placeholder="确认密码" class="pass">
				<span class="biaoshi red">
					<img src=".././img/alert_1.jpg">
					请输入...
				</span>
				<input type="text" name="phone" value="" placeholder="验证手机" class="phone">
				
				<input type="text" name="img"  hidden="false" style="display:none;">
				<input type="text" name="beizhuziliao" hidden="true"  style="display:none;">
				<div class="position">
					<span>或</span>
					<a href="">验证邮箱</a>
				</div>
				<div class="box">
					<span>我已阅读并同意</span>
					<a href="http://doc.tedu.cn/mysql/MySQL5.5cn.pdf">《京淘用户注册协议》</a>
				</div>
				<input type="submit" id="login">
			</form>
		</div>
		<div class="newright">
			<img src=".././img/msg.jpg">
		</div>

	</section>



	<!-- 尾部 -->
	<footer>
		<p>关于我们 | 联系我们 | 人才招聘 | 商家入驻 | 营销中心 | 手机京淘 | 友情连接 | 销售联盟 | 京淘社区 | 京淘公益 | English Site</p>
		<span>Copyright © 2004 - 2007 京淘jingtao.com 版权所有</span>
	</footer>

</body>
</html>