package com.rogalix.rogale.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User(

        @Id
        val id: Long,

        val username: String,

        val email: String,

        var password: String,

        @DBRef
        val ratings: MutableList<Rating> = mutableListOf()

)
