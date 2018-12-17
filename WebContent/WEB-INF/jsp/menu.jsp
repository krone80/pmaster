<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品マスタメンテナンス | メインメニュー</title>
<link rel="stylesheet" type="text/css" href="/ProductMasterMaintenance/css/style.css">
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<div class= container>
	<div class="label">
		<h3 class="label_text">メニュー</h3>
	</div>
	<div class="contents">
		<p><input type="button" value="検索・更新" onClick="document.location='/ProductMasterMaintenance/Search'"  class="btn_2" /></p>
		<p><input type="button" value="新規登録" onClick="document.location='/ProductMasterMaintenance/Register'"  class="btn_2" /></p>
<!--		<a href="/ProductMasterMaintenance/Search" class="btn_a1">検索・更新</a>
		<a href="/ProductMasterMaintenance/Register" class="btn_a1">新規登録</a> -->
		<input type="button" value="終了" onClick="document.location='/ProductMasterMaintenance/'" class="btn_1" />
	</div>
</div>
</body>
</html>