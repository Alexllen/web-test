<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
function check_input(){
	if (form.id.value.length<1 || form.id.value.length>10) {
		$('#info').text("请正确输入正确账号");
		$('#info').css("color","red");
		return false;
	}
	if (form.password.value.length<1 || form.password.value.length>20) {
		$('#info').text("请正确输入密码");
		$('#info').css("color","red");
		return false;
	}
	$.ajax({
		type : "post", //请求方式
		url : "Confirm.do", //发送请求地址
		data : { //发送给数据库的数据
			action : "confirmlogin",
			id : $("#id").val(),
			password : $("#password").val()
		}, 
		success : function(data) {
			if (data === "success") {
				$("#info").text(
						"登录成功！等待跳转");
				setTimeout("Location()",3000);
			} else if (data === "fail") {
				$("#info").text("账号或密码错误");
				$('#info').css("color", "red");
			} else {
				$("#info").text("服务器响应失败");
				$('#info').css("color", "red");
			}
		},
		error : function() {
			$("#info").text("无法连接服务器");
			$('#info').css("color", "red");
		}
	});
	return false;
}
function Location(){
	window.location="Main.do";
}
</script>
<title>用户登录</title>
</head>
<body>
	<div style="margin:0 auto;margin-top:150px;width:400px; height:250px;padding-top:50px;border:1px solid;border-radius:10px;background-color: #a5a5b5;">
	<center>
		<h1>用户登录</h1>
	</center>
	<form name="form" action="" method="post"
		onSubmit="return check_input();">
		<table border="1" align="center">
			<tr>
				<td align="center">账号：</td>
				<td><input type="text" id="id" name="id"  ></td>
			</tr>
			<tr>
				<td align="center">密码：</td>
				<td><input type="password" id="password" name="password"
					 /></td>
			</tr>
			<tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="登录" /><input
					type="button" value="注册" onClick="window.location.href='register.jsp'"/></td>
			</tr>
		</table>
	</form>
	<div  style="color:green;magin-top:10px;padding-top:10px;font-size:18px;" id="info" align="center" >请先登录</div>
	</div>
</body>
</html>