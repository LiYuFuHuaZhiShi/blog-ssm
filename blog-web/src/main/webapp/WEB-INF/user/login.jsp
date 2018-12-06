<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
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
                        <input class="form-control required" type="text" placeholder="Username" id="username" name="username" autofocus="autofocus" maxlength="20" autocomplete="off"/>
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="Password" id="password" name="password" maxlength="8"/>
                    </div>
                    <div class="form-group col-xs-offset-6">
                        <a class="btn btn-link pull-left" role="button" href="${pageContext.request.contextPath }/index.action">返回主界面</a>
                        <input class="btn btn-success pull-right" type="submit" value="登陆">
                        <a class="btn btn-link pull-right" role="button" href="${pageContext.request.contextPath }/user_torequest.action">注册</a>
                    </div>
                    </form>
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