<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品マスタメンテナンス | ログイン</title>
<link rel="stylesheet" type="text/css" href="/ProductMasterMaintenance/css/style.css">
<script type="text/javascript" src="/ProductMasterMaintenance/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/ProductMasterMaintenance/js/staffCheck.js"></script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<div class= container>
	<div class="label">
		<h3 class="label_text">ログイン</h3>
	</div>
	<div class="contents">
		<form action="/ProductMasterMaintenance/Login" method="post">
			<table>
				<tr>
					<th>社員ID</th>
					<td><input type="text" name="staffId" /></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			<p class="msg">${msg}</p>
			<input type="submit" value="ログイン" class="btn_1"/>
		</form>
	</div>
</div>
</body>
</html>