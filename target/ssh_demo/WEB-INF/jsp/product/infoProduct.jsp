<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@include file="/WEB-INF/jsp/basic/basicHeader.jsp"%>
<html>
<head>
    <title>infoProduct</title>
    <h1 align="center">${user.name}您好</h1>
</head>
<script>
    //判断购买数量是否合法，添加购买数量
    $(function () {
        $(".buyLink").click(function () {
            var num = $(".buyNumber").val();
            var productId = ${product.id};
            if(num < 1){
                alert("购买商品数量大于1哦，不大于1您买空气吗");
            }else{
                //添加购买数量的属性
                $(".buyLink").attr("href","buyOrderItem?product.id="+productId+"&num="+num);
            }
        });
        $(".addCart").click(function () {
            var num = $(".buyNumber").val();
            var productId = ${product.id};
            if(num<1){
                alert("加入购物车的商品数量不能小于1件");
            }else{
                $(".addCart").attr("href","addCartOrderItem?product.id="+productId+"&num="+num);
            }
        });
    });
</script>
<body>
<table align="center" border="1px">
    <tr>
        <td>id</td>
        <td>商品名</td>
        <td>价格</td>
        <td>库存</td>
        <td>立即购买</td>
        <td>加入购物车</td>
    </tr>
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>${product.count}件</td>
        <td>
            <input class="buyNumber" type="number" min="1" value="1">
            <a class="buyLink" href="#"><button>立即购买</button></a>
        </td>
        <td><a class="addCart" href="#"><button>加入购物车</button></a></td>
    </tr>
</table>

</body>
</html>
