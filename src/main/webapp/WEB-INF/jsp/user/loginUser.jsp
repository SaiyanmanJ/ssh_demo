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
    <title>loginUser</title>
</head>
<script>
    $(function () {
        <c:if test="${!empty msg}">
            $("span.errorMessage").html("${msg}");
            $("div.loginMessageDiv").css("visibility", "visible");
        </c:if>
        $(".loginForm").submit(
            function () {
                if (0 == $("#name").val().length) {
                    $("span.errorMessage").html("请输入用户名");
                    $("div.loginMessageDiv").css("visibility", "visible");
                    return false;
                }
                if (0==$("#password").val().length){
                    $("span.errorMessage").html("请输入密码");
                    $("div.loginMessageDiv").css("visibility","visible");
                    return false;
                }
            });
        /*$(".errorMessage").click(function () {
            $("div.loginMessageDiv").css("visibility","hidden");
            $("span.errorMessage").html("");
        })*/
    });

</script>
<body>
<div align="center" class="loginDiv">
    <div class="loginMessageDiv" style="height: 40px">
        <span class="errorMessage"></span>
    </div>
</div>
<div align="center">
    <form action="loginBasic" method="post" class="loginForm">
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
                <td colspan="2">
                    <a href="loginUser.jsp">
                        <button>提交</button>
                    </a>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
