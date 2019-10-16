<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta charset="UTF-8">

<%--<script language="javascript">
    function show(obj){
        var XS = document.getElementById(obj);
        XS.style.display ="block";
    }
    function hide(obj){
        var YC = document.getElementById(obj);
        YC.style.display = "none";
    }
</script>--%>


<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <%--<div id="one" onmouseover="show('item')" onmouseout="hide('item')">--%>
            <a href="#" class="navbar-brand" style="padding-top: 5px;padding-bottom: 0;border-top-width: 5px;">
                <img src="<%=request.getContextPath() %>/img/logo/鬼刀-logo.jpg" style="width: 100px;height: 40px;"
                     class="img-circle">
            </a>
            <%--</div>--%>
        </div>

        <!-- 左侧导航 -->
        <%--<div>
            <ul id="item" class="layui-nav layui-nav-tree layui-nav-side" style="height: 180px;width: 100px;left: 30px;top:52px">
                <li class="layui-nav-item" id="li1"><a href="${pageContext.request.contextPath }/index.action">首页</a></li>
                <li class="layui-nav-item" id="li2"><a href="${pageContext.request.contextPath }/index.action#img">轮播图</a></li>
                <li class="layui-nav-item" id="li4"><a href="${pageContext.request.contextPath }/index.action#article">博客内容</a></li>
                <li class="layui-nav-item" id="li5"><a href="${pageContext.request.contextPath }/index.action#bottom">页底</a></li>
            </ul>
        </div>--%>


        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath }/typePage.action">美文</a></li>
                <li><a href="${pageContext.request.contextPath }/typePage.action">编程</a></li>
                <li><a href="#">动漫</a></li>
                <li><a href="#">国际</a></li>
                <li><a href="#">关于</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="${pageContext.request.contextPath }/toWriteBlog.action" class="glyphicon glyphicon-pencil"
                       style="color: #ec971f">写博客</a>
                </li>
                <li>
                    <ul class="nav navbar-nav">
                        <c:choose>
                            <c:when test="${sessionScope.user.username != null}">
                                <li><img src="http://localhost:8080/picture/${user.headPic}"
                                         style="height: 50px;width: 50px" class="img-circle"></li>
                                <li><a href="${pageContext.request.contextPath }/toUser.action"
                                       class="glyphicon glyphicon-user"> 欢迎您，${user.username}</a></li>
                                <li><a href="${pageContext.request.contextPath }/logout.action"
                                       style="margin-right: 30px;">退出</a></li>
                            </c:when>
                            <c:when test="${sessionScope.user.username == null}">
                                <li class="dropdown">
                                    <a class="dropdown-toggle btn glyphicon glyphicon-user" data-toggle="dropdown"
                                       id="dropdownmenu">
                                        请登录 <span class="caret"></span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="${pageContext.request.contextPath }/user_tologin.action"
                                               style="margin-right: 0px;">登录</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="${pageContext.request.contextPath }/user_torequest.action"
                                               class="navbar-link" style="margin-right: 0px;">注册</a></li>
                                    </ul>
                                </li>
                                <%--<li><a href="${pageContext.request.contextPath }/user_tologin.action" class="navbar-link" style="margin-right: 30px;">请登录</a></li>--%>
                            </c:when>
                        </c:choose>
                    </ul>
                </li>
                <li>
                    <a href="#" style="margin-right: 0px;" id="home" class="glyphicon glyphicon-search">

                    </a>
                </li>
            </ul>
            <%--<a href="${pageContext.request.contextPath }/user_torequest.action" class="navbar-link" style="margin-right: 30px;">注册</a>
                <a href="${pageContext.request.contextPath }/user_tologin.action" class="navbar-link" style="margin-right: 30px;">登录</a>--%>
        </div>
    </div>
</nav>