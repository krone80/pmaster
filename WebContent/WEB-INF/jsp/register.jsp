<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品マスタメンテナンス | 新規登録</title>
<link rel="stylesheet" type="text/css" href="/ProductMasterMaintenance/css/style.css">
<script type="text/javascript" src="/ProductMasterMaintenance/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/ProductMasterMaintenance/js/productCheck.js"></script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<div class= container>
	<div class="label">
		<h3 class="label_text">商品情報　新規登録</h3>
	</div>
	<div class="contents">
		<form action="/ProductMasterMaintenance/Register" method="post">
			<table>
				<tr>
					<th>商品コード</th>
					<td><input type="text" name="productId" /></td>
				</tr>
				<tr>
					<th>商品名</th>
					<td><input type="text" name="productName" /></td>
				</tr>
				<tr>
					<th>単価</th>
					<td><input type="number" name="productVal" /></td>
				</tr>
			</table>
			<p class="msg">${msg}</p>
			<input type="submit" value="新規登録" class="btn_1" />
			<input type="button" value="戻る" onClick="document.location='/ProductMasterMaintenance/Menu'" class="btn_1" />
		</form>
	</div>
</div>
</body>
</html>