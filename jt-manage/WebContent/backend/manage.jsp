<%@page pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<% if(!(pageContext.getSession().getAttribute("dlname")==null)){ 
%>
	<head>
		<title>后台管理页面</title>
		<meta charset="utf-8"/>
		<style type="text/css">
		</style>
	</head>
	
	<!-- frameset组织页面结构 -->
	<frameset rows="14%, 86%" frameborder="0" framespacing="0">
		<frame src="${ Path }/backend/_top.jsp" noresize="noresize" />
		
		<frameset cols="14%, 86%" frameborder="0" framespacing="0" tabindex="1">	
			<frame src="${ PATH }/backend/_left.jsp" noresize="noresize" />
			<frame src="${ PATH }/backend/_right.jsp" name="rightFrame"  noresize="noresize" />
		</frameset>
	</frameset>
	<body>
	</body>
	<%} else{%>
		<script type="text/javascript">
		console.dir(location);
			location.href="/qiantai/login.jsp";
		</script>
	<% }%>
</html>
