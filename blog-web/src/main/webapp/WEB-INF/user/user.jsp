<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>个人界面</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/user.css">
    <!-- bootstarp -->
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
</head>
<body>
<div id="top">
    <div id="top_left">
        <a href="${pageContext.request.contextPath }/index.action">首页</a>
        <a href="#">美文</a>
        <a href="#">编程</a>
        <a href="#" class="red-pot">动漫</a>
        <a href="#">国际</a>
    </div>
</div>
<div class="clear"></div>
<div id="wrapper">
    <div id="header">
        <div id="logo">
            <a href="#" title="返回博客首页">
                <img src="<%=request.getContextPath() %>/img/logo/blog.jpg" alt="logo" style="width:165px;height:55px;">
            </a>
        </div>
        <div id="nav_block">
            <a href="#">园子</a> ·
            <a href="#">关注</a> ·
            <a href="#">粉丝</a> ·
            <a href="#">随便看看</a> ·
            <a href="#" target="_blank">消息
                <span id="msg_count">[2]</span>
            </a>
        </div>

        <div class="clear"></div>

        <div id="header_user">
            <h1 id="header_user_left">
                欢迎你，${user.username}
            </h1>
            <div id="header_user_right">
                <a href="#">
                    <img class="pfs" src="http://localhost:8080/picture/${user.headPic}" alt="">
                </a>
                <a href="#">${user.username}</a>
                · <a href="#">我的博客</a>
                · <a href="#">设置</a>
                · <a href="javascript:void(0);" onclick="return logout();">退出</a>
            </div>
        </div>

        <div class="clear"></div>

    </div>

    <div id="container">

        <div id="container_content">

            <div id="main" onclick="javascript:void(0)">

                <div id="user_profile_block">
                    <table>
                        <tbody>
                        <tr>
                            <td>
                                <div class="user_avatar">
                                    <img src="http://localhost:8080/picture/${user.headPic}" alt="${user.username}的头像"
                                         class="img_avatar"><br>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div>
                                    <h1 class="display_name">
                                        ${user.username}
                                    </h1>
                                </div>
                                <div class="clear"></div>
                                <br>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">
                                <div class="container" style="margin-top: 30px">
                                    <div class="row">
                                        <div class="col-xs-2 col-xs-pull-2">
                                            <ul class="nav nav-pills nav-stacked">
                                                <li role="presentation">
                                                    <button type="button" class="btn btn-primary btn-lg"
                                                            data-toggle="modal" data-target="#myModal">
                                                        资料修改
                                                    </button>
                                                    <div class="modal fade" id="myModal" role="dialog"
                                                         aria-labelledby="myModalLabel">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <button type="button" class="close"
                                                                            data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span></button>
                                                                    <h4 class="modal-title" id="myModalLabel">Modal
                                                                        title</h4>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <form action="${pageContext.request.contextPath }/updateUser.action"
                                                                          method="post" enctype="multipart/form-data">
                                                                        <div class="form-group">
                                                                            <label class="col-xs-2 control-label">用户名</label>
                                                                            <div class="col-xs-10">
                                                                                <input name="username"
                                                                                       class="form-control"
                                                                                       placeholder="用户名">
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label class="col-xs-2 control-label">修改头像</label>
                                                                            <div class="form-group col-xs-10">
                                                                                <input type="file" name="head_pic">
                                                                                <p class="help-block"></p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button"
                                                                                    class="btn btn-default"
                                                                                    data-dismiss="modal">关闭
                                                                            </button>
                                                                            <input type="submit" class="btn btn-primary"
                                                                                   value="提交">
                                                                        </div>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li role="presentation">
                                                    <a href="#">我的帖子</a>
                                                </li>
                                            </ul>
                                        </div>

                                        <div class="col-xs-10 col-xs-pull-2">
                                            <ul class="list-group">
                                                <li>
                                                    <a class="list-group-item active"> 我的帖子 </a>
                                                    <c:choose>
                                                        <c:when test="${articleList.size() == 0}">
                                                            <div class="list-group-item">
                                                                <a href="${pageContext.request.contextPath }/toWriteBlog.action"
                                                                   style="color:grey">您还未写博客，请点击前往写博客界面</a>
                                                            </div>
                                                        </c:when>
                                                        <c:when test="${articleList.size() != 0}">
                                                            <c:forEach items="${articleList}" var="article">
                                                                <div class="list-group-item">
                                                                    <a href="${pageContext.request.contextPath }/toArticle.action?aid=${article.aid}"
                                                                       style="color:grey">
                                                                            ${article.title}
                                                                    </a>
                                                                    <a href="${pageContext.request.contextPath }/reArticle.action?aid=${article.aid}"
                                                                       style="float: right">编辑</a>
                                                                    <a href="#" style="float: right">申请精华贴&nbsp;</a>
                                                                    <p style="float: right;margin-right: 50px">
                                                                        浏览量:${article.theclick.click}&nbsp;评论量:${article.theclick.comment}&nbsp;发表日期:${article.time}
                                                                    </p>
                                                                </div>
                                                            </c:forEach>
                                                        </c:when>
                                                    </c:choose>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <br>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
