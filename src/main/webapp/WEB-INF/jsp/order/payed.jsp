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
<div align="center">
    <ul style="width: 400px">
        <li>订单号：${order.orderCode}</li>
        <li>收货信息：${order.address} ${order.receiver} ${order.mobile}</li>
        <li>实付款：<span><fmt:formatNumber minFractionDigits="2" value="${order.total}"></fmt:formatNumber></span></li>
        <li>预计到达时间：<fmt:formatDate value="${now}" pattern="G yyyy年MM月dd日"></fmt:formatDate></li>
    </ul>
</div>
</body>
</html>
