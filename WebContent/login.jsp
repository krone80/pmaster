<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
        <s:form action="login" theme="simple">
			<table>
				<tr>
					<th>社員ID</th>
					<td><s:textfield key="staffId" /></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><s:password key="password" /></td>
				</tr>
			</table>
			<p><s:property value="msg" /></p>
			<s:submit  value="ログイン" action="login" class="btn_1" />
		</s:form>
	</div>
</div>
</body>
</html>