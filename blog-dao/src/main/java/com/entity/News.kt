package com.entity

import java.util.Date

class News {
    var nid: Int? = null

    var time: Date? = null

    var content: String? = null
        set(content) {
            field = content?.trim { it <= ' ' }
        }

    var author: String? = null
        set(author) {
            field = author?.trim { it <= ' ' }
        }
}