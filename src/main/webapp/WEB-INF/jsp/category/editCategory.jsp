<%--
  Created by IntelliJ IDEA.
  User: Jetwj
  Date: 2020/3/25
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@include file="/WEB-INF/jsp/basic/basicHeader.jsp"%>
<html>
<head>
    <title>editCategory</title>
</head>
<body>
<div align="center">
    <form action="updateCategory" method="post">
        <input name="category.id" type="hidden" value="${category.id}">
        name:<input name="category.name" value="${category.name}"><br>
        <button type="submit">提交</button>
    </form>
</div>
</body>
</html>
