<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- import! -->
<%@ page import="java.util.*"%>
<%@ page import="bean.ShohinBean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>商品マスタ</title>
</head>
<body>
	<div align="center">
		<!-- ArrayリストのShohinBeanをimport -->
		<% ArrayList<ShohinBean> list =(ArrayList<ShohinBean>)request.getAttribute("list"); %>
		<p>商品一覧</p>
		<!-- menu画面で一覧ボタンを押した時の動き -->
		<form method="POST" action="/NockWeb/web/menu.jsp">
			<% if(request.getParameter("no").equals("1")){ %>
			<table border="1">
				<tr>
					<td>ID</td>
					<td>商品名</td>
					<td>価格</td>
				</tr>
				<% for(int i =0; i<list.size(); i++){ %>
				<tr>
					<td><%=list.get(i).getId() %></td>
					<td><%=list.get(i).getName() %></td>
					<td><%=list.get(i).getPrice() %>円</td>
				</tr>
				<% } %>
			</table>
			<button name="submit">戻る</button>
			<% } %>

			<!-- menu画面で変更削除ボタンを押した時の動き -->
			<%if(request.getParameter("no").equals("2")){ %>
			<table border="1">
				<tr>
					<td></td>
					<td>ID</td>
					<td>商品名</td>
					<td>価格</td>
				</tr>
				<% for(int i =0; i<list.size(); i++){ %>
				<tr>
					<td><input type="radio" name="fruits"
						value="<%=list.get(i).getId()%>"></td>
					<td><%=list.get(i).getId() %></td>
					<td><%=list.get(i).getName() %></td>
					<td><%=list.get(i).getPrice() %>円</td>
					<% } %>
				</tr>
			</table>
			<font color=red>

			<% if((request.getAttribute("update"))!=null){ %>
				<%= request.getAttribute("update") %>
			<% } %>
			<% if((request.getAttribute("errmsg"))!=null){ %>
				項目を選択してください
			<% } %>
			</font><br>


			<button name="submit" value="変更" formaction="/NockWeb/delete">変更</button>
			<button name="submit" value="削除" formaction="/NockWeb/delete">削除</button>
			<button name="submit">戻る</button>
			<% } %>
		</form>
	</div>
</body>
</html>