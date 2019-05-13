<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>商品マスタ</title>
</head>
<body>
	<div align="center">
		<br>
		<!-- kakunin.jspで登録ボタンが押された時、エラーがあった時 -->
		<% if(request.getParameter("no").equals("3") || request.getParameter("no").equals("4")){ %>
		<p>商品登録</p>
		以下の商品を登録します。
		<form action="/NockWeb/control" method="POST">
			<table>
				<tr>
					<td>ID:</td>
					<td align="left"><input name="id" type="text" size="5"
						<%-- "id"が --%>
            value=<%if(request.getParameter("id") != null){%>
						<%= request.getParameter("id")%> <% } %>></td>

				</tr>
				<tr>
					<td>商品名:</td>
					<td><input type="text" name="name" size="20"
						value=<%if(request.getParameter("name") != null){%>
						<%= request.getParameter("name")%> <% } %>></td>
				</tr>
				<tr>
					<td>価格:</td>
					<td><input type="text" name="price" size="20"
					<%-- errを検出した際に入力値を再度代入する --%>
						value=<%if(request.getParameter("price") != null){%>
						<%= request.getParameter("price")%> <% } %>>円</td>
				</tr>
				<tr>
					<td>個数:</td>
					<td><input type="text" name="kosu" size="20">個</td>
				</tr>
			</table>
			<!-- update登録完了が押されていたら -->
			<p><font color=red>
				<%--errを検出したら--%>
				<% if((request.getAttribute("errmsg"))!=null){ %>
					<%= request.getAttribute("errmsg") %>
				<% } %>
				<% if((request.getAttribute("errmsg2"))!=null){ %>
					<%= request.getAttribute("errmsg2") %>
				<% } %>
				<%-- updateが完了したら --%>
				<% if((request.getAttribute("update"))!=null){ %>
					<%= request.getAttribute("update") %>
				<% } %>
			</font></p>

			<!-- 登録ボタン -->
			<button name="submit" value="登録" formaction="/NockWeb/control">登録</button>
			<!-- 戻るボタン -->
			<button name="submit" formaction="/NockWeb/web/menu.jsp">戻る</button>
		</form>
		<% } %>

		<% if(request.getParameter("no").equals("2")){ %>
		<p>商品変更</p>
		以下の商品を変更します。
		<form action="/NockWeb/control" method="POST">
			<table>
				<tr>
					<td>ID:</td>
					<td align="left"><%=session.getAttribute("id") %></td>

				</tr>
				<tr>
					<td>商品名:</td>
					<td><input type="text" name="name" size="20"
						value=<%=session.getAttribute("name") %>></td>
				</tr>
				<tr>
					<td>価格:</td>
					<td><input type="text" name="price" size="20"
						value=<%=session.getAttribute("price") %>></td>
				</tr>
			</table>
			<p><font color=red>
				<%--errを検出したら--%>
				<% if((request.getAttribute("errmsg"))!=null){ %>
					<%= request.getAttribute("errmsg") %>
				<% } %>
				</font></p>
			<button name="submit" value="変更">変更</button>
			<button name="submit" value="戻る" formaction="/NockWeb/list?no=2">戻る</button>
		</form>
		<% } %>
	</div>
</body>
</html>