<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <title>糯米糍</title>
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">

    <style>
        .carousel {
            height: 70%;
        }
        .carousel .item {
            height: 100%;
        }
        .carousel .item img {
            width: 100%;
        }
        /*.fixed{
            position: fixed;
            float: right;
        }*/
    </style>

</head>
<body>

<%@include file="top.jsp"%>

<div class="container-fluid" style="margin-top: 70px;">

    <!-- 轮播图 -->
    <div class="col-xs-12" style="padding-bottom: 50px;">
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
                    <img src="img/background/鬼刀-冰公主.jpg" alt="鬼刀-冰公主">
                    <div class="carousel-caption">
                        鬼刀-冰公主
                    </div>
                </div>
                <div class="item">
                    <img src="img/background/鬼刀-冰公主2.jpg" alt="鬼刀-冰公主2">
                    <div class="carousel-caption">
                        鬼刀-冰公主2
                    </div>
                </div>
                <div class="item">
                    <img src="img/background/鬼刀-冰公主3.jpg" alt="鬼刀-鬼刀3">
                    <div class="carousel-caption">
                        鬼刀3
                    </div>
                </div>
                <div class="item">
                    <img src="img/background/鬼刀.jpg" alt="鬼刀-鬼刀4">
                    <div class="carousel-caption">
                        鬼刀4
                    </div>
                </div>
                <div class="item">
                    <img src="img/background/鬼刀2.jpg" alt="鬼刀-鬼刀5">
                    <div class="carousel-caption">
                        鬼刀5
                    </div>
                </div>
            </div>

            <!-- 左右控制 -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>



    <!--文章主体 -->
    <div class="col-xs-9">
        <div class="list-group">
            <c:forEach items="${lists}" var="lists">
                <h4 style="text-align: center">
                    <a href="#">
                        <fmt:formatDate value="${lists.key[0].time}" type="date" pattern="yyyy-MM-dd"/>
                    </a>
                </h4>
                <c:forEach items="${lists.key}" var="list">
                <div class="list-group-item" style="border: 0;">

                    <p>
                        <h3><a href="#">${list.title}</a></h3>
                    <small>文章作者：<span class="badge" style="background-color: #122b40">${list.user.username}</span></small>
                    </p>
                    <p>
                        <small>点击量: <span class="badge" style="background-color: #5bc0de">${list.theclick.click}</span></small>
                        <small>评论量: <span class="badge" style="background-color: #4cae4c">${list.theclick.comment}</span></small>
                        <small>文章类别: <span class="badge" style="background-color: #ec971f">${list.thetype.type}</span></small>
                    </p>
                    <div style="width: 80px;white-space:nowrap;text-overflow:ellipsis;overflow:hidden;" title="${list.thecontent.content}">
                            ${list.thecontent.content}
                    </div>
                    <p>
                        关键字：
                        <c:forEach var="keywords" items="${list.keywordsList}">
                            <span class="badge">${keywords.keywords}</span>
                        </c:forEach>
                    </p>
                </div>
                </c:forEach>
            </c:forEach>

            <div style="border: 1px dashed #ddd;"></div>

            <!-- 分页 -->
            <div class="text-center">
                <ul class="pagination">
                    <!-- 向前符号 -->
                    <li><a href="#">«</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">»</a></li>
                </ul>
            </div>
        </div>
    </div>

    <!-- 侧边栏 -->
    <div class="col-xs-3">

        <div class="panel panel-default">
            <div class="panel-heading" style="background-color: #c4e3f3">
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

</div>
</body>
</html>