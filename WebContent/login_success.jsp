<%@ page language="java"  contentType="text/html; charset=utf-8"
  %>
  <%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录成功</title>
</head>
<body>
		<% 
		     request.setCharacterEncoding("utf-8");
		%>
	<center><h2>欢迎您<font face="verdana" color="red"><%=request.getAttribute("username") %></font>，登录成功！</h2></center>
	<hr>
 	上次登录时间为：${requestScope.lastdate} <br>
	上次登录的IP为：${requestScope.lastip} <br>
</body>
</html>