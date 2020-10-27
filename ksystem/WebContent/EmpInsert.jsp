<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EmpInsert</title>
</head>
<body>
<div align="center">
<h1>従業員登録</h1>
<form action="/ksystem/ksys" method="post">
	<input type="hidden" name="B_ID" value="M02"/>
	<input type="submit" value="登録" />
</form>
<c:out value="${requestScope.message}" />
</div>
</body>
</html>