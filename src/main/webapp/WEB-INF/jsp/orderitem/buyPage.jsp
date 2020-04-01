<%--
  Created by IntelliJ IDEA.
  User: Jetwj
  Date: 2020/3/25
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@include file="/WEB-INF/jsp/basic/basicHeader.jsp" %>
<html>
<head>
    <title>buyPage</title>
</head>
<body>
<br>
<form action="createOrder" method="post">
    <table align="center" border="1px" cellspacing="0">
        <thead>
        <tr>
            <td>商品名</td>
            <td>单价</td>
            <td>数量</td>
            <td>总计</td>
            <td>配送方式</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orderItems}" var="oi">

            <tr>
                <td>${oi.product.name}</td>
                <td>${oi.product.price}</td>
                <td>${oi.number}</td>
                <td><fmt:formatNumber value="${oi.number*oi.product.price}"></fmt:formatNumber></td>
                <td>
                    <select>
                        <option>快递免邮</option>
                    </select>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <div align="center">
        <button type="submit">提交订单</button>
    </div>
</form>
</body>
</html>
