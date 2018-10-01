<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
<style type="text/css">
	body{ font-family: "微软雅黑"; background-color: #EDEDED; }
	h2{ text-align: center; }
	table{ margin: 0 auto; text-align: center; border-collapse:collapse; font-size:16px }
	td, th{ padding: 7px;}
	th{ background-color: #DCDCDC; width:120px; }
	th.desc{ width: 500px; }
	hr{ margin-bottom:20px; border:1px solid #aaa; }
</style>

<!--引入jquery的js库-->
<script src="../js/jquery-1.4.2.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<h2>商品管理</h2>
	<hr/>
	<table border="1">
		<tr>
			<th>用户ID</th>
			<th>用户名称</th>
			<th>头像</th>
			<th class="desc">资料备注</th>
			<th>操 作</th>
		</tr>
		<!-- 模版数据 -->
		<c:forEach items="${ list }" var="i">
			<tr>
					<td>${ i.getId() }</td>
					<td>${ i.getName() }</td>
					<td>${ i.getCategory() }</td>
					<td>${ i.getDescription() }</td>
				<td>
					<a href="delProd?id=${ i.getId() }">删除</a> |
					<a id="prod_update.jsp?id=${ i.getId() }" href="updateservlet?id=${ i.getId() }">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>