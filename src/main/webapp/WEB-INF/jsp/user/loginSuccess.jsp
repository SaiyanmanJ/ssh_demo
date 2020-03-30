<%--
  Created by IntelliJ IDEA.
  User: Jetwj
  Date: 2020/3/27
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@include file="/WEB-INF/jsp/basic/basicHeader.jsp"%>

<html>
<head>
    <title>loginSuccess</title>
</head>
<body>
    <div align="center">
        <form action="homeBasic" method="post">
            <input type="submit" value="首页"/>
        </form>
    </div>
    <div align="center">
        <form action="loginOutBasic" method="post">
            <input type="submit" value="退出登录"/>
        </form>
    </div>
</body>
</html>
