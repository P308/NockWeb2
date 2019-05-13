<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品マスタ</title>
</head>
<body>
	<div align="center">
		<%
			String getId = (String) (session.getAttribute("login_name"));
		%>
		<%
			if (getId != null) {
		%>
		<%
			String getDep = (String) (session.getAttribute("login_dep"));
			String getStatus = (String)(session.getAttribute("login_status"));
		%>
		<table>
			<tr>
				<th>部署:</th>
				<th><%=getDep%></th>
			</tr>
			<tr>
				<th>氏名:</th>
				<th><%=getId%></th>
			</tr>
			<tr>
				<th>職級</th>
				<th><%= getStatus%></th>
			</tr>
		</table>

		<a href="/NockWeb/syainKyuyo">社員給与一覧</a>
		<form method="post" action = "/NockWeb/syainKyuyo">
		<button onclick= "histry.back">戻る</button>
		</form>
		<% } %>

		<%
			if (getId == null) {
		%>
		<h3>商品マスタメンテナンスメニュー</h3>
		<!-- no=1を指定 -->
		<a href="/NockWeb/list?no=1">商品一覧</a><br> <a
			href="/NockWeb/web/mod.jsp?no=3">商品登録</a><br>
		<!-- no=2を指定することで、listを置換させる -->
		<a href="/NockWeb/list?no=2">商品変更・削除</a><br>
		<%
			}
		%>
	</div>
</body>
</html>