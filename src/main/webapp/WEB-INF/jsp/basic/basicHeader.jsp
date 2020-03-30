<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<h1 align="center" style="color: red">${msg}</h1>
<div align="center">
    <c:if test="${!empty user.name}">
        ${user.name}您好<a href="loginOutBasic"><button>退出账号</button></a>
    </c:if>
    <c:if test="${empty user.name}">
        当前未登录<a href="loginUserBasic"><button>登录</button></a>
    </c:if>
    <br>
    <br>
    <a href="homeBasic"><button>首页</button></a>
    <a href="listProduct"><button>产品列表</button></a>
    <a href="listCategory"><button>商品类别</button></a>
    <a href="listUser"><button>用户列表</button></a>
    <a href="registerUserBasic"><button>用户注册</button></a>
    <a href="listOrder"><button>订单查看</button></a>

</div>
</body>
</html>
