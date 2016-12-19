<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>发帖</title>

<!-- Bootstrap CSS 
<link
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">-->
<link href="bootstrap.min.css" type="text/css" rel="stylesheet">
<style>
body {
	padding-top: 50px;
	padding-bottom: 40px;
	color: #5a5a5a;
}

thead {
	text-align: center;
}
/*响应式*/
@media ( max-width : 768px) {
	.summary {
		padding-top: 0px； padding-left:3px;
		padding-right: 3px;
	}
	.carousel {
		height: 300px;
		margin-bottom: 30px;
	}
	.carousel .item {
		height: 300px;
	}
	.carousel img {
		min-height: 300px;
	}
	.carousel-caption p {
		font-size: 16px;
		line-height: 1.4;
	}
	.feature-heading {
		font-size: 34px;
	}
	.feature-heading .text-muted {
		font-size: 22px;
	}
}

@media ( min-width : 992px) {
	.feature-heading {
		margin-top: 120px;
	}
}
</style>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		id="menu-nav">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<div
					style="width:1000px; float:left;font-size:20px;font-size: 50px;color: #c1c16b;"
					class="navbar-brand" onClick="window.location.href='Main.do'">天天论坛</div>
				<%
					String name = (String) request.getParameter("name");
					String picture = (String) request.getParameter("picture");
					if (name != null && picture != null) {
				%>
				<div style="width:40px; float:right;margin-top:10px;" class="icon"
					href="#">
					<img src="./images/<%=picture%>" width="40px" height="40px"
						style="border-radius:50%">
				</div>
				<div
					style="width:65px; float:right;margin-top:10px;padding-top: 10px;
				font-size: 20px;color:white;"
					class="username"><%=name%></div>
				<div
					style="float:right;padding-top: 10px;
					font-size: 20px;color:white;margin-top:10px;"
					class="welcome">欢迎</div>
				<%
					} else {
				%>
				<div style="width:65px; float:right;margin-top:10px;"
					class="btn btn-lg btn-primary"
					onClick="window.location.href='register.jsp'" role="button"
					align="right">注册</div>
				<div style="width:65px; float:right;margin-top:10px;"
					class="btn btn-lg btn-primary"
					onClick="window.location.href='login.jsp'" role="button"
					align="right">登录</div>
				<%
					}
				%>
			</div>
		</div>
	</nav>
	<div style="margin:0 auto;margin-top:50px;width:1000px;padding:10px">
		<center>
			<p>理性发帖，文明讨论</p>
		</center>
		<form
			action="AddTopic.do?Typeid=<%=(String) request.getParameter("Typeid")%>"
			method="post" id="form1">
			<table border="1" width="700px"
				style="margin:0 auto;table-layout:fixed;">
				<tr hegiht="15px">
					<td width="150px" style="font-size: 20px">请输入帖子标题</td>
					<td style="font-size: 20px;width: 550px;"><input
						style="width: 500px;" type="text" name="title" /></td>
				</tr>
				<tr>
					<td height="350px">请输入正文内容</td>
					<td><textarea rows="18" cols="55" name="content" form="form1"></textarea></td>
					<td></td>
				</tr>
			</table>
			<center>
				<input type="submit" value="发布帖子"></center>
		</form>
		<br>
		<center><button
			onclick="window.location.href='TopicAll.do?typeid=<%=(String) request.getParameter("Typeid")%>' ">返回到列表</button>
		</center>
	</div>
</body>
</html>
