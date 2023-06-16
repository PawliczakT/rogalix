package com.rogalix.rogale.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "rogals")
data class Rogal (

        @Id
        var id: Long,

        val name: String,

        val imageUrl: String,

        val description: String,

        @DBRef
        val ratings: MutableList<Rating> = mutableListOf()
)
