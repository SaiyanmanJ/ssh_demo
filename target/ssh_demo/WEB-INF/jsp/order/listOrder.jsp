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
    <title>orders</title>
</head>
<script>
    $(function () {
        $("button.CheckOrderItems").click(function () {
            var oid = $(this).attr("oid");
            $("tr.productsInfo[oid=" + oid + "]").toggle();
        });
    });
</script>
<body>
<br>
<table align="center" border="1px" cellspacing="0" width="1000px">
    <thead>
    <tr>
        <td>id</td>
        <td>状态</td>
        <td>金额</td>
        <td>数量</td>
        <td>用户</td>
        <td>创建时间</td>
        <td>支付时间</td>
        <td>发货时间</td>
        <td>确认收货时间</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="o">
        <tr>
            <td>${o.id}</td>
            <td>${o.status}</td>
            <td>${o.total}</td>
            <td>${o.totalNumber}</td>
            <td>${o.user.name}</td>
            <td><fmt:formatDate value="${o.createDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
            <td><fmt:formatDate value="${o.payDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
            <td><fmt:formatDate value="${o.deliveryDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
            <td><fmt:formatDate value="${o.confirmDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>

            <td>
                <button oid=${o.id} class="CheckOrderItems">查看详情</button>
                <c:if test="${o.status=='待付'}">
                    <a href="deliveryOrder?order.id=${o.id}">
                        <button type="button">发货</button>
                    </a>
                </c:if>
            </td>
        </tr>
        <tr class="productsInfo" style="display: none" oid="${o.id}">

            <td colspan="10" align="center">
               <div>
                   <table  width="994px" align="center" border="1px" cellspacing="0">
                       <c:forEach items="${o.orderItems}" var="oi">
                           <tr>
                               <td align="left">商品名：${oi.product.name}</td>
                               <td>单价：${oi.product.price}</td>
                               <td align="right">数量：${oi.number}</td>
                           </tr>
                       </c:forEach>
                   </table>
               </div>
            </td>

        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
