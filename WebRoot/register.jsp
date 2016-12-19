<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
var pass='false';
function check_input(){
	if (form.id.value.length<1 || form.id.value.length>10) {
		$('#info').text("请正确输入正确账号");
		$('#info').css("color","red");
		return false;
	}
	if (form.name.value.length<1 || form.name.value.length>5) {
		$('#info').text("请正确输入名字");
		$('#info').css("color","red");
		return false;
	}
	if (form.password.value.length<1 || form.password.value.length>20) {
		$('#info').text("请正确输入密码");
		$('#info').css("color","red");
		return false;
	}
	if (!($('#password').val()===$('#reppassword').val())) {
		$('#info').text("密码输入不匹配");
		$('#info').css("color","red");
		return false;
	}
	return true;
}
	function confirm(){
		if(form.id.value.length<1 || form.id.value.length>10){
			$('#info').css("color","red");
			$('#info').text("请正确输入正确账号");
		}
		else
		$.ajax({
			   type:"post", //请求方式
			   url:"Confirm.do", //发送请求地址
			   data:{ //发送给数据库的数据
				   action:"confirmregister",
			       id:$("#id").val()
			   },
			   success:function(data){
				   if(data==="success"){$('#info').css("color","green");
				   $("#info").text("此账号可用");
				   $("#submit").attr("disabled",false);
				   }
				   else if(data==="fail"){$('#info').css("color","red");
				   $("#info").text("账号已被占用");
				   $("#submit").attr("disabled","true");}
				   else  {$('#info').css("color","red");
				   $("#info").text("服务器响应错误");
				   $("#submit").attr("disabled","true");}
			   },
			   error:function(){
				   $('#info').css("color","red");
				   $("#info").text("连接服务器失败");
				   $("#submit").attr("disabled","true");}
			   });
}
</script>
<title>用户注册</title>
</head>
<body>
	<div style="margin:0 auto;margin-top:150px;width:400px; height:350px;padding-top:20px;border:1px solid;border-radius:10px;background-color: #a5a5b5;">
	<center>
		<h1>用户注册</h1>
	</center>
	<form name="form" action="DoRegister.do" method="post"
		onSubmit="return check_input();">
		<table border="1" align="center">
			<tr>
				<td align="center">账号：</td>
				<td><input type="text" id="id" name="id" onblur="confirm()"></td>
			</tr>
			<tr>
				<td align="center">名字：</td>
				<td><input type="text" id="name" name="name"></td>
			</tr>
			<tr>
				<td align="center">密码：</td>
				<td><input type="password" id="password" name="password"
					 /></td>
			</tr>
			<tr>
			<td align="center">确认密码：</td>
			<td><input type="password" id="reppassword" name="reppassword"
					 /></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" id="submit" value="注册" /><input
					type="reset" value="取消" /></td>
			</tr>
		</table>
	</form>
	<div  style="color:green;magin-top:10px;padding-top:10px;font-size:18px;" id="info" align="center" >欢迎注册</div>
	</div>
</body>
</html>