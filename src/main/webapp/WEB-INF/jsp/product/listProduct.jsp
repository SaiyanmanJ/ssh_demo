<%--
  Created by IntelliJ IDEA.
  User: Jetwj
  Date: 2020/3/25
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="/WEB-INF/jsp/basic/basicHeader.jsp"%>
<html>
<head>
    <title>productList</title>
</head>
<body>
<div align="center">
    <form action="searchProduct" method="post">
        <input  placeholder="输入关键词搜索" name="keyword">
        <button type="submit">搜索</button>
    </form>
</div>
<table align="center" border="1px">
    <tr>
        <td>id</td>
        <td>商品名</td>
        <td>价格</td>
        <td>商品类别</td>
        <td>数量</td>
        <c:if test="${empty user.name}">
            <td>编辑</td>
            <td>删除</td>
            <td>详情</td>
        </c:if>
        <c:if test="${!empty user.name}">
            <td>详情</td>
        </c:if>
    </tr>
    <c:forEach items="${products}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.category.name}</td>
            <td>${p.count}</td>
            <c:if test="${ empty user.name}">
                <td><a href="editProduct?product.id=${p.id}">编辑</a></td>
                <td><a href="deleteProduct?product.id=${p.id}">删除</a></td>
                <td><a href="infoProduct?product.id=${p.id}">详情</a></td>
            </c:if>
            <c:if test="${ !empty user.name}">
                <td><a href="infoProduct?product.id=${p.id}">详情</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<div align="center">
    <form action="addProduct" method="post">
        商品名<input name="product.name"><br>
        价格<input name="product.price"><br>
        商品种类<input name="product.category.name"><br>
        <button type="submit">提交</button>
    </form>
</div>

</body>
</html>
