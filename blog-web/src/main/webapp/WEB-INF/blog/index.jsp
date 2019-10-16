<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>糯米糍</title>
    <link rel="shortcut icon " href="http://www.bilibili.com/favicon.ico">
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <!-- bootstarp -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
    <!-- layui -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/layui/layui.js">
    <style>
        /*导航栏图片的大小设置*/
        .carousel {
            height: 70%;
        }

        .carousel .item {
            height: 100%;
        }

        .carousel .item img {
            width: 100%;
            height: 100%;
        }

        /*浮动*/
        /*.fixed{
            position: fixed;
            float: right;
        }*/
        .clear {
            clear: both;
        }

        /*每个文章的下划线*/
        .postDesc {
            width: 100%;
            clear: both;
            text-align: right;
            padding-right: 5px;
            color: #666;
            margin-top: 5px;
            border-top: 1px solid #ddd;
            padding-top: 1.6em;
        }

        /*超出隐藏*/
        .overhidden {
            overflow: hidden;
        }
    </style>

</head>
<body onload="load()">

<div class="container" style="margin-top: 70px;">

    <%@include file="top.jsp" %>


    <!-- 轮播图 -->
    <a name="top"></a>
    <a name="img"></a>
    <div class="col-xs-1"></div>
    <div class="col-xs-10" style="padding-bottom: 0px;height: 300px;margin-bottom: -100;">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- 轮播图下方小按钮 -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                <li data-target="#carousel-example-generic" data-slide-to="4"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <!--  src里面填写图片路径 -->
                    <!-- title表示悬浮时提示框 -->
                    <img src="<%=request.getContextPath() %>/img/background/鬼刀-冰公主.jpg" alt="鬼刀-冰公主">
                    <div class="carousel-caption">
                        鬼刀-冰公主
                    </div>
                </div>
                <div class="item">
                    <img src="<%=request.getContextPath() %>/img/background/鬼刀-冰公主2.jpg" alt="鬼刀-冰公主2">
                    <div class="carousel-caption">
                        鬼刀-冰公主2
                    </div>
                </div>
                <div class="item">
                    <img src="<%=request.getContextPath() %>/img/background/鬼刀-冰公主3.jpg" alt="鬼刀-鬼刀3">
                    <div class="carousel-caption">
                        鬼刀3
                    </div>
                </div>
                <div class="item">
                    <img src="<%=request.getContextPath() %>/img/background/鬼刀.jpg" alt="鬼刀-鬼刀4">
                    <div class="carousel-caption">
                        鬼刀4
                    </div>
                </div>
                <div class="item">
                    <img src="<%=request.getContextPath() %>/img/background/鬼刀2.jpg" alt="鬼刀-鬼刀5">
                    <div class="carousel-caption">
                        鬼刀5
                    </div>
                </div>
            </div>

            <!-- 左右控制 -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">上一个</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">下一个</span>
            </a>
        </div>
    </div>


    <!-- 博客内容 -->
    <div class="col-xs-7 col-xs-offset-1" style="top: 50px">
        <a name="article"></a>
        <ul class="list-group overhidden" id="jqList">
            <c:forEach items="${lists}" var="lists">
                <li class="list-group-item" style="margin-bottom: 50px">
                    <h4 style="text-align: center">
                        <a href="#">
                            <fmt:formatDate value="${lists.value[0].time}" type="date" pattern="yyyy-MM-dd"/>
                        </a>
                    </h4>
                    <c:forEach items="${lists.value}" var="list">
                        <div class="" style="border: 0;margin: 30px;">
                            <p>
                            <h3>
                                <a href="${pageContext.request.contextPath }/toArticle.action?aid=${list.aid}">${list.title}</a>
                            </h3>
                            <small>文章作者：<span class="badge"
                                              style="background-color: #122b40">${list.user.username}</span></small>
                            </p>
                            <article style="white-space: nowrap;">
                                    ${list.thecontent.content}
                            </article>
                            <a href="${pageContext.request.contextPath }/toArticle.action?aid=${list.aid}">阅读原文</a>
                            <p>
                                关键字：
                                <c:forEach var="keywords" items="${list.keywordsList}">
                                    <span class="badge">${keywords.keywords}</span>
                                </c:forEach>
                            </p>
                            <div class="clear"></div>
                            <div class="postDesc"></div>
                            <p class="text-right">
                                <small>点击量: <span class="badge"
                                                  style="background-color: #5bc0de">${list.theclick.click}</span>
                                </small>
                                <small>评论量: <span class="badge"
                                                  style="background-color: #4cae4c">${list.theclick.comment}</span>
                                </small>
                                <small>文章类别: <span class="badge"
                                                   style="background-color: #ec971f">${list.thetype.type}</span></small>
                            </p>
                        </div>
                    </c:forEach>
                </li>
            </c:forEach>

        </ul>
        <!-- 分页 -->
        <div class="text-center">
            <ul class="pagination">
                <!-- 向前符号 -->
                <li><a href="#">«</a></li>
                <li><a href="${pageContext.request.contextPath }/pagination.action?currentPage=1">1</a></li>
                <li><a href="${pageContext.request.contextPath }/pagination.action?currentPage=2">2</a></li>
                <li><a href="${pageContext.request.contextPath }/pagination.action?currentPage=3">3</a></li>
                <li><a href="${pageContext.request.contextPath }/pagination.action?currentPage=4">4</a></li>
                <li><a href="${pageContext.request.contextPath }/pagination.action?currentPage=5">5</a></li>
                <li><a href="#">»</a></li>
            </ul>
        </div>
    </div>


    <!-- 侧边栏 -->
    <div class="col-xs-3 col-xs-offset-1" style="top: 100px">

        <div class="panel panel-default">
            <div class="panel-heading" style="background-color: #c4e3f3;">
                每日一句
            </div>

            <div class="panel-body">
                <c:if test="${news != null}">
                    <blockquote class="blockquote-reverse">
                        <p>${news.content}</p>
                        <footer><cite title="Source Title">${news.author}</cite></footer>
                    </blockquote>

                </c:if>
            </div>

        </div>

        <!-- 热点新闻侧边栏 -->
        <div class="panel panel-default">
            <div class="panel-heading" style="background-color: lightsalmon">
                热点新闻(前三，有并列)
                <a href="#" class="text-muted pull-right">>></a>
            </div>
            <c:forEach items="${hotspot}" var="news">
                <ul class="list-group">
                    <li class="list-group-item" style="border: 0;">
                        <a href="#" class="text-muted">${news.title}</a>
                        <a href="#" class="text-muted pull-right">${news.user.username}</a>
                    </li>
                </ul>
            </c:forEach>
        </div>

        <!-- 多媒体 -->
        <div class="panel panel-default">
            <div class="panel-heading">
                推荐视频
                <a href="#" class="text-muted pull-right">>></a>
            </div>
            <ul class="media-list" style="margin: 5px;">
                <li>
                    <div class="media">
                        <div class="media-left">
                            <img src="#" style="width: 50px;height: 50px;" class="media-object">
                        </div>
                        <div class="media-body">
                            <strong class="media-heading">这是视频的标题</strong>
                            <p>多媒体列表项介绍</p>
                        </div>
                    </div>
                </li>
            </ul>
        </div>

        <!-- 广告位 -->
        <a href="#">
            <img src="#" style="width: 100%;height: 100px;">
        </a>
    </div>

    <!-- 置顶 -->
    <ul class="layui-fixbar">
        <li class="layui-icon" lay-type="top" style="display: list-item;"><a href="#top">top</a></li>
    </ul>

</div>
<!-- 页底 -->
<a name="bottom"></a>

</body>
</html>

<!--分页时间从前往后-->
<script src="<%=request.getContextPath() %>/js/mine/paper.js"></script>

<!-- readmore -->
<script src="<%=request.getContextPath() %>/js/readmore.js"></script>
<script>
    function load() {
        $('article').readmore({maxHeight: 20, heightMargin: 16});
    }
</script>
