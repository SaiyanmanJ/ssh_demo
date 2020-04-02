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
    input {
        border: 0px
    }
</style>
<script>
    $(function () {
        $(".createOrder").click(function () {
            var params="";
            $(".orderItem:checked").each(function () {
                params += "&oiids="+ $(this).attr("oiid");
            });
            params = params.substring(1);//截取1-n,去掉首字符&;
            location.href = "buyOrderItem?"+params;
        });

        $(".selectAllItem").click(function () {//全选
            var isChecked = $(this).prop("checked");
            $(".orderItem").prop("checked", isChecked);
            calculateSumNumberAndPrice();
            return true;
        });
        $(".orderItem").click(function () {
            var isAllCheck = true;
            $(".orderItem").each(function () {//如果有未选中的，就取消全选框
                if ($(this).prop("checked") == false) {
                    isAllCheck = false;
                }
            });
            $(".selectAllItem").prop("checked", isAllCheck);
            calculateSumNumberAndPrice();
        });
        $(".oiNumber").click(function () {
            var oiid = $(this).attr("oiid");
            var productPrice = $(".productPrice[oiid=" + oiid + "]").text();
            var num = $(".oiNumber[oiid=" + oiid + "]").val();
            var ordetItemPrice = new Number(productPrice) * new Number(num);
            $(".orderItemPrice[oiid=" + oiid + "]").text("" + ordetItemPrice.toFixed(2));
            calculateSumNumberAndPrice();
            var pid = $(this).attr("pid");
            orderItemUpdate(oiid, pid, num);
        });

        function calculateSumNumberAndPrice() {
            var sumPrice = 0;
            var totalNumber = 0;
            $(".orderItem:checked").each(function () {
                var oiid = $(this).attr("oiid");
                var orderItemPrice = $(".orderItemPrice[oiid =" + oiid + "]").text();
                sumPrice += new Number(orderItemPrice);
                var num = $(".oiNumber[oiid=" + oiid + "]").val();
                totalNumber += new Number(num);
            });
            if (totalNumber > 0) {//购物数量>=1 结算按钮可按
                $(".createOrder").prop("disabled", false);
            } else {
                $(".createOrder").prop("disabled", true);
            }
            $("span.cartSumNumber").html("￥" + totalNumber);
            $("span.cartSumPrice").html("￥" + sumPrice.toFixed(2));
        }

        function orderItemUpdate(oiid, pid, num) {
            var page = "updateOrderItem";
            $.post(
                page,
                {"product.id": pid, "orderItem.id": oiid, "num": num},
                function (result) {
                    alert(result);
                    if (result != "success") {
                        location.href = "login.jsp";
                    }
                }
            )
        }
    });
</script>
<head>
    <title>cartPage</title>
</head>
<body>
<br>
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
    <tbody class="cartList">
    <c:forEach items="${orderItems}" var="oi">

        <tr>
            <td><input oiid="${oi.id}" class="orderItem" type="checkbox"></td>
            <td>${oi.product.name}</td>
            <td><span oiid="${oi.id}" class="productPrice">${oi.product.price}</span></td>
            <td><input class="oiNumber" type="number" min="1" pid="${oi.product.id}" oiid="${oi.id}"
                       value="${oi.number}"></td>
            <td>
                <span>￥</span>
                <span class="orderItemPrice" oiid="${oi.id}" pid="${oi.product.id}">
                        <fmt:formatNumber type="number" minFractionDigits="2" value="${oi.product.price*oi.number}"/>
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
    <button type="submit" disabled="disabled" class="createOrder">结算</button>
</div>
</body>
</html>
