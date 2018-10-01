<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>left</title>
		<meta charset="utf-8"/>
		<style type="text/css">
			/* css样式 */
			body{
				background-color: #32323A;
				margin: 0px;
				padding:0px;
				font-family:"微软雅黑";
			}
			div#menu_bar{
				font-size: 20px;
				color:#FFFFFF;
			}
			div#menu_bar div{
				border-top: 1px solid #cccccc;
				padding: 5px 0;
				text-indent: 15px;
				letter-spacing: 3px;
			}
			div#menu_bar div:last-child{
				border-bottom: 1px solid #cccccc;
			}
			div#menu_bar div:hover{
				background-color: #797981;
			}
			div#menu_bar div a{
				font-size: 20px;
				color:#FFFFFF;
				text-decoration: none;
			}
			.box{
				height:37px;
				overflow: hidden;
				transition:height 1s;
			}
			ul li:hover{
				background:#ccc;
				opacity:0.5;
			}
		</style>
	</head>
	<body margin="0">
		<div id="menu_bar">
		<%if(request.getSession().getAttribute("dlname")!=null){ %>
			<div class="box" style="cursor:pointer;"><a href="" target="rightFrame">&gt; 用户管理(管理员)</a>
				<ul>
					<li><a href="/userselect" target="rightFrame">用户列表</a></li>
					<li><a href="/useradd" target="rightFrame">添加用户</a></li>
				</ul>
			</div>
		<% } %>
			<div><a href="/prodlistservlet" target="rightFrame">&gt; 商品管理</a></div>
			<div><a href="prod_add.jsp" target="rightFrame">&gt; 商品添加</a></div>
		</div>		
	</body>
</html>
<script type="text/javascript">
<!--

//-->
	var doc=document.getElementsByClassName("box")[0];
	var flag=true;
	doc.onclick=function(){
		if(flag){	
			flag=false;
			this.style.height=129+"px"
		}else{
			flag=true;
			this.style.height=37+"px";
		}
	}
</script>
