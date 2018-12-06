package com.entity

class Keywords {
    var kid: Int? = null

    var keywords: String? = null
        set(keywords) {
            field = keywords?.trim { it <= ' ' }
        }
}