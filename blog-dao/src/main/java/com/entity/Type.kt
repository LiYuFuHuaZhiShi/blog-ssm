package com.entity

class Type {
    var tid: Int? = null

    var type: String? = null
        set(type) {
            field = type?.trim { it <= ' ' }
        }
}