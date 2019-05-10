<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>商品マスタ</title>
</head>
<body>
	<div align="center">
		<%! String doThing= new String();%>
		<%-- 登録ボタンが押された時 --%>
		<% if(request.getParameter("submit").equals("登録")){ %>
		<% doThing= "登録"; %>
		<% } %>
		<%-- 変更ボタンが押された時 --%>
		<% if(request.getParameter("submit").equals("変更")){ %>
		<% doThing= "変更"; %>
		<% } %>
		<%-- 削除ボタンが押された時 --%>
		<% if(request.getParameter("submit").equals("削除")){ %>
		<% doThing= "削除"; %>
		<% } %>

		<%-- doThingの部分だけ置き換え --%>
		<p>
			以下の商品を<%=doThing%>します。宜しいですか？
		</p>
		<table>
			<tr>
				<td>ID:</td>
				<td><%=session.getAttribute("id") %></td>
			</tr>
			<tr>
				<td>商品名:</td>
				<td><%=session.getAttribute("name") %></td>
			</tr>
			<tr>
				<td>価格:</td>
				<td><%=session.getAttribute("price") %>円</td>

			</tr>
		</table>
		<form action="/NockWeb/shohin" method="POST">
			<button name="submit" value=<%=doThing%>><%=doThing%></button>
			<button type="button" onclick="history.back()">戻る</button>
		</form>
	</div>
</body>
</html>