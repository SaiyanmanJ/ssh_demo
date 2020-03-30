<%--
  Created by IntelliJ IDEA.
  User: Jetwj
  Date: 2020/3/27
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@include file="/WEB-INF/jsp/basic/basicHeader.jsp"%>
<html>

<head>
    <title>registerUser</title>
</head>
<script>
    $(function () {
        <c:if test="${!empty msg}">
            $("span.errorMessage").html("${msg}");
            $("div.registerMessageDiv").css("visibility", "visible");
        </c:if>
        $(".registerForm").submit(
            function () {
                if (0 == $("#name").val().length) {
                    $("span.errorMessage").html("请输入用户名");
                    $("div.registerMessageDiv").css("visibility", "visible");
                    return false;
                }
                if (0==$("#password").val().length){
                    $("span.errorMessage").html("请输入密码");
                    $("div.registerMessageDiv").css("visibility","visible");
                    return false;
                }
            });
        /*$(".errorMessage").click(function () {
            $("div.registerMessageDiv").css("visibility","hidden");
            $("span.errorMessage").html("");
        })*/
    });

</script>
<body>
<div align="center" class="registerDiv">
    <div class="registerMessageDiv" style="height: 40px">
        <span class="errorMessage"></span>
    </div>
</div>
<div align="center">
    <form action="registerBasic" method="post" class="registerForm">
        <table>
            <tr>
                <td>姓名</td>
                <td><input id="name" name="user.name"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input id="password" name="user.password"></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><input name="user.address"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input name="user.sex"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <a href="registerUser.jsp">
                        <button>提交</button>
                    </a>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
