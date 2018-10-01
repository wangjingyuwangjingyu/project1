<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>top</title>
		<meta charset="utf-8"/>
		<style type="text/css">
			/* css样式 */
			body{
				background-color: #1172B5;
				font-family:"微软雅黑";
				/*margin:0px;
				padding:0px;*/
			}
			h1{
				color:#FFFFFF;
				letter-spacing: 5px;
				text-shadow: 5px 5px 5px #000;
				margin:21px;
			}
			.div{
				position:absolute;
				top:80px;
				right:50px;
				color:#fff;
			}
			button{
				width:120px;
				height: 30px;
				background: blue;
				color:#fff;
				font-size: 18px;
				border-radius:10px;
				cursor: pointer;
			}
			button:last-child{
				background: red;
			}
			.timebox{
				position: absolute;
				top:5px;
				right:250px;
				width:200px;
			}
			.time{
				font-siz
	
			}
			.namebox{
				position: absolute;
				top:-50px;
				right:10px;
				font-size: 18px;
				color:red;
			}
			.name{
				padding-left: 5px;
				padding-right: 5px;
				color:#fff;
				font-size: 24px;
			}
		</style>
	</head>
	<body margin="0">
		<h1>京淘商城后台管理系统</h1>
		<div class="div">
			<div class="namebox">
				欢迎<span class="name">${ dlname }&nbsp;&nbsp;&nbsp;&nbsp;
				<%if(request.getSession().getAttribute("dlname")!=null){ %>
					管理员
				<% } %>
			</span>
			</div>
			<div class="timebox">
				<span>时间:</span>
				<span class="time"></span>
			</div>
			<button class="zhuxiao">注销</button>
			<a href="/destorysession_cookie" target="_top">退出</a>
		</div>
	</body>
</html>
<script type="text/javascript">
<!--

//-->
	var doc=document.getElementsByClassName("time")[0];
	var zhuxiao=document.getElementsByClassName("zhuxiao")[0];
	var tuichu=document.getElementsByClassName("tuichu")[0];
	console.dir(doc);
	window.setInterval(function(){
		var date=new Date();
		doc.innerText=date.getFullYear()+"/"+date.getMonth()+"/"+date.getDay()+"\t\t\t\t"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	},1000)
	tuichu.onclick=function(){
		location.href="/destorysession_cookie";		
	}
	zhuxiao.onclick=function(){
		
	}
</script>