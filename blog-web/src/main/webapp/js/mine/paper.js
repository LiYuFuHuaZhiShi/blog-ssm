$(function () {
    $('.pagination a').click(function () {
        var href = $(this).attr('href');
        $.ajax({
            type: 'post',
            url: href,
            dataType: 'json',
            success: function (result) {
                var blog = "/" + location.pathname.split("/")[1];// 会得到"/blog"值
                var html = '';
                for (var i = 0; i < result.length; i++) {
                    html += '<li class="list-group-item"  style="margin-bottom: 50px">';
                    html += '<div class="" style="border: 0;margin: 30px;">';
                    html += '<p>' +
                        '<h3><a href="' + blog + "/toArticle.action?aid=" + result[i].aid + '">' + result[i].title + '</a></h3>' +
                        '<small>文章作者：<span class="badge" style="background-color: #122b40">' + result[i].user.username + '</span></small>' +
                        '</p>';
                    html += '<article style="white-space: nowrap;">' + result[i].thecontent.content + '</article>';
                    html += '<a href="#">阅读原文</a>';
                    for (var j = 0; j < result[i].keywordsList.length; j++) {
                        var keywordsList = '';
                        keywordsList += result[i].keywordsList[j].keywords;
                        html += '<p>关键字：<span class="badge">' + result[i].keywordsList[j].keywords + '</span></p>';
                    }
                    html += '<div class="clear"></div>';
                    html += '<div class="postDesc"></div>';
                    html += '<p class="text-right">' +
                        '<small>点击量: <span class="badge" style="background-color: #5bc0de">' + result[i].theclick.click + '</span></small>' +
                        '<small>评论量: <span class="badge" style="background-color: #4cae4c">' + result[i].theclick.comment + '</span></small>' +
                        '<small>文章类别: <span class="badge" style="background-color: #ec971f">' + result[i].thetype.type + '</span></small>' +
                        '</p>';
                    html += '</div>';
                    html += '</li>';
                }
                $('#jqList').html(html);//更换ul的内容
                //更换页码
            }
        });
        return false//组织a跳转
    })
});

//引入外部readmore
// var scr=document.createElement("script"); scr.src="/js/mine/paper.js";
// function load(){
//     $('article').readmore({maxHeight: 20,heightMargin: 16});
// }