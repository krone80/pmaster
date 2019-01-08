<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
		<s:form  action="toSearch" theme="simple">
	 		<p><s:submit  value="検索・更新" action="toSearch" class="btn_2" /></p>
	  	</s:form>
		<s:form  action="toRegister" theme="simple">
	 		<p><s:submit  value="新規登録" action="toRegister" class="btn_2" /></p>
	  	</s:form>
		<s:form  action="toLogin" theme="simple">
	 		<p><s:submit  value="終了" action="toLogin" class="btn_1" /></p>
	  	</s:form>
  	</div>
</div>
</body>
</html>