<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品マスタメンテナンス | 検索・更新</title>
<link rel="stylesheet" type="text/css" href="/ProductMasterMaintenance/css/style.css">
<script type="text/javascript" src="/ProductMasterMaintenance/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/ProductMasterMaintenance/js/productCheck.js"></script>

<script type="text/javascript">
    function actionUpdate(){
        document.getElementById('form').action="update";
    }

    function actionToMenu(){
        document.getElementById('form').action="toMenu";
    }
</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<div class= container>
	<div class="label">
		<h3 class="label_text">商品情報　検索・更新</h3>
	</div>
	<div class="contents">
        <s:form id="form" action="search" theme="simple">
			<div class="search">
				<b>商品コード指定</b>
				<table>
					<tr>
						<th>商品コード</th>
						<td><s:textfield key="productId"  /></td>
					</tr>
				</table>
				<s:submit  value="検索" class="btn_1" />
			</div>
			<div class="update">
				<b>商品情報(変更内容入力)</b>
				<table>
					<tr>
						<th>商品名</th>
						<td><s:textfield key="productName"  value="%{getText(product.productName)}" /></td>
					</tr>
					<tr>
						<th>単価</th>
						<td><s:textfield key="productVal" value="%{getText(product.productVal)}" min="0" step="1"/></td>
					</tr>
					<tr>
						<th>前回登録日時</th>
						<td><s:property value="product.updatedAt" /></td>
					</tr>
				</table>
				<p class="msg"><s:property value="msg" /></p>
				<s:submit  value="更新" class="btn_1" onClick="actionUpdate()" />
				<s:submit  value="戻る" class="btn_1" />
				<input type="button" href="" >
			</div>
		</s:form>
	</div>
</div>
</body>
</html>