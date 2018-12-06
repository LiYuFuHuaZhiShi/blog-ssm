package com.entity

import java.util.Date

class Comment {
    var comid: Int? = null

    var content: String? = null
        set(content) {
            field = content?.trim { it <= ' ' }
        }

    var time: Date? = null

    var articleid: Int? = null
}