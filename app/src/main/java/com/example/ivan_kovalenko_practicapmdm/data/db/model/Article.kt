package com.example.ivan_kovalenko_practicapmdm.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "articles"
)
data class Article(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    val author: String?,

    val content: String?,

    val title: String?,

    val url: String?,

    val urlToImage: String?,

    val isRead: Boolean? = false,

    val isFav: Boolean? = false

)