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
    <title>categoryList</title>
</head>
<body>
<table align="center" border="1px">
    <tr>
        <td>id</td>
        <td>商品类别</td>
        <td>商品</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${categories}" var="cg">
        <tr>
            <td>${cg.id}</td>
            <td>${cg.name}</td>
            <td>
                <c:forEach items="${cg.products}" var="p">
                    ${p.name}<br>
                </c:forEach>
            </td>
            <td><a href="editCategory?category.id=${cg.id}">编辑</a></td>
            <td><a href="deleteCategory?category.id=${cg.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<table align="center" border="1px">
    <tr>
        <td>id</td>
        <td>商品类别</td>
        <td>产品管理</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${categories}" var="cg">
        <tr>
            <td>${cg.id}</td>
            <td>${cg.name}</td>
            <td><a href="listByCategoryProduct?product.category.id=${cg.id}">产品管理</a></td>
            <td><a href="editCategory?category.id=${cg.id}">编辑</a></td>
            <td><a href="deleteCategory?category.id=${cg.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<div align="center">
    <form action="addCategory" method="post">
        name:<input name="category.name"><br>
        <button type="submit">提交</button>
    </form>
</div>

</body>
</html>
