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
<style type="text/css">
    input{border: 0px}
</style>
<script>
    $(function () {
        var isChecked = false;
        $(".selectAllItem").click(function () {
            isChecked = !isChecked;
            if(isChecked)
                $(".orderItem").prop("checked",true);
            else
                $(".orderItem").prop("checked",false);
            calculateSumNumberAndPrice();
            return true;
        });
        $(".orderItem").click(function () {
            calculateSumNumberAndPrice();
        });
        function calculateSumNumberAndPrice() {
            var sumPrice=0;
            var totalNumber=0;
            var orderItemPrice = 0;
            $(".orderItem").each(function () {
                var oiid = $(this).attr("oiid");
                orderItemPrice = $(".orderItemPrice[oiid="+oiid+"]").text();
                sumPrice += new Number(orderItemPrice);
                console.log(orderItemPrice);
                var num = $(".oiNumber[oiid="+oiid+"]").val();
                totalNumber += new Number(num);
                console.log(totalNumber);
            });
            $("span.cartSumNumber").html("￥"+totalNumber);
            $("span.cartSumPrice").html("￥"+sumPrice);
        }
    });
</script>
<head>
    <title>cartPage</title>
</head>
<body>
<br>
<form action="createOrder" method="post">
    <table align="center" border="1px" cellspacing="0">
        <thead>
        <tr>
            <th><input class="selectAllItem" type="checkbox">全选</th>
            <th>商品名</th>
            <th>单价</th>
            <th>数量</th>
            <th>总计</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orderItems}" var="oi">

            <tr>
                <td><input oiid=""${oi.id} class="orderItem" type="checkbox"></td>
                <td>${oi.product.name}</td>
                <td><span oiid="${oi.id}" class="productPrice">${oi.product.price}</span></td>
                <td><input class="oiNumber" oiid=""${oi.id} min="1" type="number" autocomplete="off" value="${oi.number}"></td>
                <td>
                    <span>￥</span>
                    <span class="orderItemPrice" oiid="${oi.id}" pid="${oi.product.id}" >
                        <fmt:formatNumber type="number" value="${oi.product.price*oi.number}"/>
                    </span>
                </td>
                <td><a href="deleteOrderItem?orderItem.id=${oi.id}">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div align="center">
        <span>已选商品：<span class="cartSumNumber">0</span>件</span>
        <span>合计(不含运费)：</span>
        <span class="cartSumPrice">￥0.00</span>
        <button type="submit" class="createOrder">结算</button>
    </div>
</form>
</body>
</html>
