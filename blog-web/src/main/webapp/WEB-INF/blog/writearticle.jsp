<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>写博客</title>

    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath }/writeArticle.action" method="post" enctype="multipart/form-data">
    <div class="container">
        <ul class="list-group" style="list-style: none">
            <li class="list-group-item">文章标题<input type="text" name="headline" autocomplete="off"
                                                   value="${article.title}">
                文章类别
                <select name="type">
                    <option value="美文">美文</option>
                    <option value="编程">编程</option>
                    <option value="动漫">动漫</option>
                    <option value="国际">国际</option>
                </select>
            </li>
            <li>
                <div id="editor"><c:out value="${article.thecontent.content}"/></div>
            </li>
            <li><input name="content" type="hidden" id="info"></li>
            <li class="list-group-item"><input type="submit" id="btn" value="提交"></li>
        </ul>
    </div>
</form>

<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    var blog = "/" + location.pathname.split("/")[1];
    editor.customConfig.uploadImgServer = blog + "/downloadPic.action";  // 上传图片到服务器
    editor.customConfig.uploadFileName = "imgFile";  //设置文件上传的参数名称

    // 将图片大小限制为 50M
    editor.customConfig.uploadImgMaxSize = 50 * 1024 * 1024;
    // 限制一次最多上传 5 张图片
    editor.customConfig.uploadImgMaxLength = 5;
    editor.customConfig.uploadImgTimeout = 50000;

    editor.customConfig.uploadImgHooks = {
        success: function (xhr, editor, result) {
            var url = result.url;
            alert(url);
        },
        customInsert: function (insertImg, result, editor) {
            // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
            // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

            // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
            var url = result.url;
            console.log(url);
            insertImg(result.url);

            // result 必须是一个 JSON 格式字符串！！！否则报错
        }
    };

    editor.create();

    $('#editor').attr('style', 'height:auto;')

    //将div内容用form表单提交
    document.getElementById('btn').addEventListener('click', function () {
        // 读取 html
        var info = editor.txt.html();

        document.getElementById("info").value = info;

    }, false);

</script>

</body>
</html>