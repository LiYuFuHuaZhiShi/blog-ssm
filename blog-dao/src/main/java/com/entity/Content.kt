package com.entity

class Content {
    var conid: Int? = null

    var content: String? = null
        set(content) {
            field = content?.trim { it <= ' ' }
        }
}