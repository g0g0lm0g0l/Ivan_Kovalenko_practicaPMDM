package com.example.ivan_kovalenko_practicapmdm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.ivan_kovalenko_practicapmdm.data.db.ArticleRepository
import com.example.ivan_kovalenko_practicapmdm.data.db.model.Article

class LikedViewModel(private val repository: ArticleRepository) : ViewModel() {
    val allFavArticles: LiveData<List<Article>> = repository.allFavArticles.asLiveData()

    suspend fun update(article: Article) {
        repository.update(article)
    }
}