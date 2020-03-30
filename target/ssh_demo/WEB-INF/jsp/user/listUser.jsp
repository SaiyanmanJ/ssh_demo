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
    <title>UserList</title>
</head>
<body>
<table align="center" border="1px">
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>密码</td>
        <td>地址</td>
        <td>性别</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${userList}" var="ul">
        <tr>
            <td>${ul.id}</td>
            <td>${ul.name}</td>
            <td>${ul.password}</td>
            <td>${ul.address}</td>
            <td>${ul.sex}</td>
            <td><a href="editUser?user.id=${ul.id}">编辑</a></td>
            <td><a href="deleteUser?user.id=${ul.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

<div align="center">
    <form action="addUser" method="post">

        姓名:<input name="user.name"><br>
        密码:<input name="user.password"><br>
        地址：<input name="user.address"><br>
        性别:<input name="user.sex"><br>
        <button type="submit">提交</button>
    </form>
</div>

</body>
</html>
