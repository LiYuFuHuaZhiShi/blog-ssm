<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap-select.min.css">
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-select.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/stylelogin.css">
</head>
<body>
<div class="container">
    <div class="form row">
        <div class="form-horizontal col-xs-offset-3" id="login_form">
            <h3 class="form-title">LOGIN</h3>
            <div class="col-xs-9">
                <form action="${pageContext.request.contextPath }/user_login.action" method="post">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="Username" id="username"
                               name="username" autofocus="autofocus" maxlength="20" autocomplete="off"/>
                        <p id="message_u"></p>
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="Password" id="password"
                               name="password" maxlength="8"/>
                        <p id="message_p"></p>
                    </div>
                    <div class="form-group">
                        <select class="selectpicker" name="grade" id="grade">
                            <option value="普通用户">普通用户</option>
                            <option value="管理员">管理员</option>
                        </select>
                        <p id="message_g"></p>
                    </div>
                    <div class="form-group col-xs-offset-6">
                        <a class="btn btn-link pull-left" role="button"
                           href="${pageContext.request.contextPath }/index.action">返回主界面</a>
                        <input class="btn btn-success pull-right" type="submit" value="登陆">
                        <%--<input class="btn btn-success pull-right" id="btn" type="button" value="登陆">--%>
                        <a class="btn btn-link pull-right" role="button"
                           href="${pageContext.request.contextPath }/user_torequest.action">注册</a>
                    </div>
                </form>
                <button onclick="loginValueCheck()"></button>
            </div>
        </div>
    </div>
</div>
<c:choose>
    <c:when test="${error != null}">
        <script language="JavaScript">
            alert("${error}");
        </script>
    </c:when>
</c:choose>
</body>
</html>
<script>
    function loginValueCheck() {
        try {
            var username = document.getElementById("username").value();
            var password = document.getElementById("password").value();
            var grade = document.getElementById("grade").value();
            if (username === '') throw "用户名为空";
            if (password === '') throw "密码为空";
            if (grade === '') throw "级别为空";
        } catch (err) {
            var m = document.getElementById("message_u");
            m.innerHTML = "错误：" + err + "。";
        }
    }
</script>