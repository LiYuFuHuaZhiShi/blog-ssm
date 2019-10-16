<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <title>文章详情</title>
    <!-- bootstarp -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <!-- layui -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/layui/layui.js">

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main.css">

</head>
<body>

<%@include file="top.jsp" %>

<div class="content whisper-content">
    <div class="cont">
        <div class="whisper-list">
            <div class="item-box">
                <div class="item" style="margin-top: 70px;">
                    <div><h1>${article.title}</h1>
                        <h3>作者:${article.user.username}</h3></div>
                    <div class="whisper-title">
                        <i class="layui-icon layui-icon-date"></i><span class="hour"></span><span
                            class="date">${article.time}</span>
                    </div>
                    ${article.thecontent.content}
                    <div class="op-list">
                        <p class="like"><i
                                class="layui-icon layui-icon-praise"></i><span>${article.theclick.click}</span></p>
                        <p class="edit"><i
                                class="layui-icon layui-icon-reply-fill"></i><span>${article.theclick.comment}</span>
                        </p>
                        <p class="off"><span>评论</span><i class="layui-icon layui-icon-down"></i></p>
                    </div>
                </div>
                <!-- 评论 -->
                <div class="review-version layui-hide">
                    <div class="form">
                        <img src="http://localhost:8080/picture/${sessionScope.user.headPic}" alt="" class="img-circle"
                             style="height: 50px;width: 50px">
                        <form class="layui-form"
                              action="${pageContext.request.contextPath }/addComment.action?aid=${article.aid}">
                            <input type="hidden" name="aid" value="${article.aid}">
                            <div class="layui-form-item layui-form-text">
                                <div class="layui-input-block">
                                    <textarea name="comment" class="layui-textarea"></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block" style="text-align: right;">
                                    <input type="submit" class="btn btn-info" value="确定">
                                </div>
                            </div>
                        </form>
                    </div>
                    <c:forEach items="${article.commentList}" var="comment">
                        <div class="list-cont">
                            <div class="cont">
                                <div class="img">
                                    <img src="http://localhost:8080/picture/${comment.user.headPic}" alt=""
                                         class="img-circle" style="height: 50px;width: 50px">
                                </div>
                                <div class="text">
                                    <p class="tit"><span class="name">${comment.user.username}</span><span
                                            class="data">${comment.time}</span></p>
                                    <p class="ct">${comment.content}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<%=request.getContextPath() %>/layui/layui.js"></script>
<script type="text/javascript">
    layui.config({
        base: 'js/'
    }).use(['element', 'laypage', 'form', 'menu'], function () {
        element = layui.element, laypage = layui.laypage, form = layui.form, menu = layui.menu;
        laypage.render({
            elem: 'demo'
            , count: 70 //数据总数，从服务端得到
        });
        menu.init();
        menu.off();
        menu.submit()
    })
</script>
</body>
</html>