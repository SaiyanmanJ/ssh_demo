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
    <title>editUser</title>
</head>
<body>
<div align="center">
    <form action="updateUser" method="post">
        <input name="user.id" type="hidden" value="${user.id}">
        姓名:<input name="user.name" value="${user.name}"><br>
        密码:<input name="user.password" value="${user.password}"><br>
        地址:<input name="user.address" value="${user.address}"><br>
        性别:<input name="user.sex" value="${user.sex}"><br>
        <button type="submit">提交</button>
    </form>
</div>
</body>
</html>
