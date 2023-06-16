package com.rogalix.rogale.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "ratings")
data class Rating(

        @get:Id
        var id: Long,

        val score: Int,

        @DBRef
        @JsonIgnore
        val user: User,

        @DBRef
        @JsonIgnore
        val rogal: Rogal
)

