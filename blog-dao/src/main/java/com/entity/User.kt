package com.entity

class User {
    var uid: Int? = null

    var username: String? = null
        set(username) {
            field = username?.trim { it <= ' ' }
        }

    var password: String? = null
        set(password) {
            field = password?.trim { it <= ' ' }
        }

    var grade: String? = null
        set(grade) {
            field = grade?.trim { it <= ' ' }
        }
}