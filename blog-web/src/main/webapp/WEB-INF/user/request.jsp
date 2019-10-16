<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap-select.min.css">
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-select.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/stylerequest.css">
</head>
<body>
<c:choose>
    <c:when test="${error != null}">
        <script language="JavaScript">
            alert("${error}");
        </script>
    </c:when>
</c:choose>
<div class="container">
    <div class="form row">
        <div class="form-horizontal col-xs-offset-3" id="login_form">
            <h3 class="form-title">REQUEST</h3>
            <div class="col-xs-9">
                <form action="${pageContext.request.contextPath }/user_request.action" method="post"
                      enctype="multipart/form-data">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="Username" id="username"
                               name="username" autofocus="autofocus" maxlength="20" autocomplete="off"/>
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="Password" id="password"
                               name="password" maxlength="8"/>
                    </div>
                    <div class="form-group">
                        <select class="selectpicker" name="grade" id="grade">
                            <option value="普通用户">普通用户</option>
                            <option value="管理员">管理员</option>
                        </select>
                    </div>
                    <label class="control-label">上传头像</label>
                    <div class="form-group">
                        <div class="form-group col-xs-10">
                            <input type="file" name="head_pic">
                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="form-group col-xs-offset-9">
                        <a class="btn btn-link pull-left" role="button"
                           href="${pageContext.request.contextPath }/index.action">返回主界面</a>
                        <input class="btn btn-info pull-right" type="submit" value="注册">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
