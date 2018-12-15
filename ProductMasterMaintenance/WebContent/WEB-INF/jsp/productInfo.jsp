<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品マスタメンテナンス | 検索・更新</title>
<link rel="stylesheet" type="text/css" href="/ProductMasterMaintenance/css/style.css">
<script type="text/javascript" src="/ProductMasterMaintenance/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/ProductMasterMaintenance/js/productCheck.js"></script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<div class= container>
	<div class="label">
		<h3 class="label_text">商品情報　検索・更新</h3>
	</div>
	<div class="contents">
		<form action="#" method="post">
			<div class="search">
				<b>商品コード指定</b>
				<table>
					<tr>
						<th>商品コード</th>
						<td><input type="text" name="productId" value="${product.productId}" /></td>
					</tr>
				</table>
				<input type="submit" value="検索" formaction="/ProductMasterMaintenance/Search" class="btn_1" />
			</div>
			<div class="update">
			<b>商品情報(変更内容入力)</b>
				<table>
					<tr>
						<th>商品名</th>
						<td><input type="text" name="productName" value="${product.productName}" /></td>
					</tr>
					<tr>
						<th>単価</th>
						<td><input type="number" name="productVal" value="${product.productVal}" /></td>
					</tr>
					<tr>
						<th>前回登録日時</th>
						<td>${product.updatedAt}</td>
					</tr>
				</table>
				<p class="msg">${msg}</p>
				<input type="submit" value="更新" formaction="/ProductMasterMaintenance/Update" class="btn_1" />
				<input type="button" value="戻る" onClick="document.location='/ProductMasterMaintenance/Menu'" class="btn_1" />
			</div>
		</form>
<!--
			<table>
				<tr>
					<th>商品コード</th>
					<td><input type="text" name="productId" value="${product.productId}" form="form_search form_update" /></td>
				</tr>
			</table>
			<input type="submit" value="検索" form="form_search" class="btn_1" />

		<b>商品情報(変更内容入力)</b>
			<table>
				<tr>
					<th>商品名</th>
					<td><input type="text" name="productName" value="${product.productName}" form="form_update" /></td>
				</tr>
				<tr>
					<th>単価</th>
					<td><input type="number" name="productVal" value="${product.productVal}" form="form_update" /></td>
				</tr>
				<tr>
					<th>前回登録日時</th>
					<td>${product.updatedAt}</td>
				</tr>
			</table>
			<input type="submit" value="更新" form="form_update" class="btn_1" />
			<input type="button" value="戻る" onClick="document.location='/ProductMasterMaintenance/Menu'" class="btn_1" />

		<form action="/ProductMasterMaintenance/Search" method="post" id="form_search"></form>
		<form action="/ProductMasterMaintenance/Update" method="post" id="form_update"></form>
  -->
	</div>
</div>
</body>
</html>