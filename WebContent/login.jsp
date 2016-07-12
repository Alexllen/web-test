<%@ page language="java" import="javax.servlet.http.Cookie"
	contentType="text/html; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>	
<body>
	<center>
		<h1>用户登录</h1>
	</center>
	<hr>
	<form name="loginForm" action="DologinServlet" method="post">
		<table border="1" align="center">
			<tr>
				<td align="center">账号：</td>
				<td><input type="text" name="id" value="${requestScope.id }"></td>
			</tr>
			<tr>
				<td align="center">密码：</td>
				<td><input type="password" name="password"
					value="${requestScope.password }" /></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="IsUseCookie" checked="checked">是否记住登录</td>
				<td align="center" colspan="2"><input type="submit" value="登录" /><input
					type="reset" value="取消" /></td>
			</tr>
		</table>
	</form>
	<hr>
</body>
</html>