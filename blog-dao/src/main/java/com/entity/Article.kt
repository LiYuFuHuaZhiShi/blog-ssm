package com.entity

import java.util.Date

class Article {
    var aid: Int? = null

    var title: String? = null
        set(title) {
            field = title?.trim { it <= ' ' }
        }

    var time: Date? = null

    var contentId: Int? = null

    var typeId: Int? = null

    var authorId: Int? = null

    //封装内容到实体类里
    var thecontent: Content? = null//内容

    var thetype: Type? = null//类别

    var theclick: Click? = null//点击量

    var keywordsList: List<Keywords>? = null//关键字

    var user: User? = null//用户
}