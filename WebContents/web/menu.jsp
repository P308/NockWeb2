<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品マスタ</title>
</head>
<body>
	<div align="center">
<% String getId =(String)(request.getAttribute("login_name")); %>
<% if(getId != null){ %>
<% String getDep =(String)(request.getAttribute("login_dep")); %>
		<table>
			<tr>
				<th>部署:</th>
				<th>
				<%= getDep %>
				</th>
			</tr>
			<tr>
				<th>氏名:</th>
				<th>
				<%= getId %>
				</th>
			</tr>
		</table>
<% } %>
		<h3>商品マスタメンテナンスメニュー</h3>
		<!-- no=1を指定 -->
		<a href="/NockWeb/list?no=1">商品一覧</a><br>

		<a href="/NockWeb/web/mod.jsp?no=3">商品登録</a><br>
		<!-- no=2を指定することで、listを置換させる -->
		<a href="/NockWeb/list?no=2">商品変更・削除</a><br>
	</div>
</body>
</html>