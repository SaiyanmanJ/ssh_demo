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
    <title>editProduct</title>
</head>
<body>
<div align="center">
    <form action="updateProduct" method="post" >
        <input name="product.id" type="hidden" value="${product.id}">
        商品名:<input name="product.name" value="${product.name}"><br>
        价格:<input name="product.price" value="${product.price}"><br>
        商品类别:<input name="product.category.name" value="${product.category.name}"><br>
        <button type="submit">提交</button>
    </form>
</div>
</body>
</html>
