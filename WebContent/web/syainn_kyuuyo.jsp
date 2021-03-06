<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- import! -->
<%@ page import="java.util.*"%>
<%@ page import="bean.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>給与テーブル</title>
</head>
<body>
	<div align="center">
		<!-- ArrayリストのUserBeanをimport -->
		<%
			ArrayList<UserBean> list = (ArrayList<UserBean>) request.getAttribute("list");
		%>
		<p>社員給与一覧</p>
		<!-- menu画面で一覧ボタンを押した時の動き -->
		<table border="1">
			<tr>
				<td>ID</td>
				<td>氏名</td>
				<td>部署</td>
				<td>職級</td>
				<td>給与</td>
			</tr>
			<%
				for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td align="left"><%=list.get(i).getId()%></td>
				<td><%=list.get(i).getName()%></td>
				<td align="left"><%=list.get(i).getDept()%></td>
				<td align="left"><%=list.get(i).getStatus()%></td>
				<td align="right"><%=list.get(i).getKyuyo()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<button onclick="javascript:history.go(-1)">戻る</button>