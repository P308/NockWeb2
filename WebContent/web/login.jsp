<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>ログイン</title>
</head>
<body>
	<font size="4"> <strong>ログイン画面</strong>
	</font>
	<br>
	<form method="post" action="/NockWeb/loginConf">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" size="20" name="id"></td>
			</tr>
			<tr>
				<td>PASS:</td>
				<td><input type="password" size="20" name="pass"></td>
			</tr>
		</table>
		<br> <input type="submit" name="submit" value="ログイン"> <input
			type="reset" name="reset" value="リセット">
	</form>
	<% if((request.getAttribute("errmsg"))!=null){ %>
	<%= request.getAttribute("errmsg") %>
	<% } %>
</body>
</html>