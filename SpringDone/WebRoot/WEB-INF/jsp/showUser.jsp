<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>会计记账系统</title>
</head>
<body>
	<form id="loginForm" name="loginForm" method="post" action="servlet/LoginServlet">
		<table width="260" border="1" align="center">
			<tr> 
				<td width="64"> 用户： </td>
				<td width="180"> <input type="text" name="username">  </td>
			</tr>
			<tr>
				<td>密码：</td>
				<td> <input type="password" name="userpass"> </td>
			</tr>
			<tr>	
				<td/>
				<td>
					<input type="submit" name="loginInfoSubmit" value="登陆"> 
					<input type="reset" name="resetSubmit" value="重置">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>