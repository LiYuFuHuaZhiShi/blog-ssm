<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1" />
<style>
    #home{}
    #home .mouseover{display:none}
    #home:hover .mouseout{display:none}
    #home:hover .mouseover{display:block}
</style>

<nav class="nav navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="${pageContext.request.contextPath }/index.action" class="navbar-brand" style="padding-top: 5px;padding-bottom: 0px;border-top-width: 5px;">
                <img src="img/logo/鬼刀-logo.jpg" style="width: 100px;height: 40px;" class="img-circle">
            </a>

            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath }/index.action">首页</a></li>
                <li><a href="${pageContext.request.contextPath }/typePage.action">新闻</a></li>
                <li><a href="#">国内</a></li>
                <li><a href="#">国际</a></li>
            </ul>
            <%--<form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" name="" placeholder="请输入搜索内容">
                </div>
                <button class="btn btn-success" style="margin-right: 30px;" type="submit">搜索</button>
            </form>--%>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#"><img src="img/icon/笔.png" alt="铅笔" height="20" width="20" style="margin-right: 6px;">写博客</a>
                </li>
                <li>
                    <ul class="nav navbar-nav">
                        <c:choose>
                            <c:when test="${sessionScope.user.username != null}">
                                <li><a href="#"> 欢迎您，${user.username}</a></li>
                                <li><a href="${pageContext.request.contextPath }/logout.action" style="margin-right: 30px;">退出</a></li>
                            </c:when>
                            <c:when test="${sessionScope.user.username == null}">
                                <li class="dropdown">
                                    <a class="dropdown-toggle btn" data-toggle="dropdown" id="dropdownmenu">
                                        请登录 <span class="caret"></span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="${pageContext.request.contextPath }/user_tologin.action" style="margin-right: 0px;">登录</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="${pageContext.request.contextPath }/user_torequest.action" class="navbar-link" style="margin-right: 0px;">注册</a></li>
                                    </ul>
                                </li>
                                <%--<li><a href="${pageContext.request.contextPath }/user_tologin.action" class="navbar-link" style="margin-right: 30px;">请登录</a></li>--%>
                            </c:when>
                        </c:choose>
                    </ul>
                </li>
                <li>
                    <a href="#" style="margin-right: 0px;" id="home">
                        <img src="img/icon/搜索%20(1).png" alt="搜索前" height="20" width="20" class="mouseover">
                        <img src="img/icon/搜索.png" alt="搜索后" height="20" width="20" class="mouseout">
                    </a>
                </li>
            </ul>
        <%--<a href="${pageContext.request.contextPath }/user_torequest.action" class="navbar-link" style="margin-right: 30px;">注册</a>
            <a href="${pageContext.request.contextPath }/user_tologin.action" class="navbar-link" style="margin-right: 30px;">登录</a>--%>
        </div>
    </div>
</nav>