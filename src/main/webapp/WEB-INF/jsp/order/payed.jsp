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
    <title>payedPage</title>
</head>
<body>
<h1 align="center">您已成功付款</h1>
<div align="center">
    <ul>
        <li>收货地址：${order.address} ${order.receiver} ${order.mobile}</li>
        <li>实付款：<span><fmt:formatNumber minFractionDigits="2" value="${order.total}"></fmt:formatNumber></span></li>
        <li>预计3天到达</li>
    </ul>
</div>
</body>
</html>
