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
    <title>alipay</title>
</head>
<body>
<h1 align="center">正在召唤支付宝，请耐心等待</h1>
<%--<div align="center">
    <span>${order.id}</span>
    <span>扫一扫付款(元)</span>
    <span><fmt:formatNumber value="${order.total}" type="number" minFractionDigits="2"/></span>
    <a href="payedOrder?order.id=${order.id}&order.total=${order.total}"><button>立即支付</button></a>
</div>--%>
${result}
</body>
</html>
