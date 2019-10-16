<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/UEditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/UEditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/UEditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
    var ue = UE.getEditor('content');
    //  content是文本域标签名
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
<html>
<head>
    <title>写博客</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/writeArticle.action" method="post" enctype="multipart/form-data">
    <div>
        <ul class="list-group">
            <li class="list-group-item">文章标题<input type="text" name="headline" autocomplete="off"
                                                   value="${article.title}"></li>
            <li class="list-group-item">
                文章类别
                <select name="type">
                    <option value="美文">美文</option>
                    <option value="编程">编程</option>
                    <option value="动漫">动漫</option>
                    <option value="国际">国际</option>
                </select>
            </li>
            <li class="list-group-item">文章内容</li>
            <li><textarea name="content" id="content" style="width: 800px; height: 400px; margin: 0 auto;"><c:out
                    value="${article.thecontent.content}"/></textarea></li>
            <li class="list-group-item">添加附件<input type="file" name="files"></li>
            <li class="list-group-item"><input type="submit" value="提交"></li>
        </ul>
    </div>
</form>
</body>
</html>