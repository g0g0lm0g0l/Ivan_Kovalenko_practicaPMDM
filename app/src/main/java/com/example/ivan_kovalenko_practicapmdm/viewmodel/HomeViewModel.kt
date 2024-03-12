package com.example.ivan_kovalenko_practicapmdm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ivan_kovalenko_practicapmdm.data.db.ArticleRepository
import com.example.ivan_kovalenko_practicapmdm.data.db.model.Article
import kotlinx.coroutines.launch
import androidx.lifecycle.asLiveData

class HomeViewModel(private val repository: ArticleRepository) : ViewModel() {

    val allArticles: LiveData<List<Article>> = repository.allArticles.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(article: Article) = viewModelScope.launch {
        repository.insert(article)
    }

    fun insertAll(articles: List<Article>) = viewModelScope.launch {
        repository.insertAll(articles)
    }

    suspend fun update(article: Article) {
        repository.update(article)
    }
}