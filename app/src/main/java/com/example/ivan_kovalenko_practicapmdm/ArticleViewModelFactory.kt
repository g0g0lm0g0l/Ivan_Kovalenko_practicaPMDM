package com.example.ivan_kovalenko_practicapmdm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ivan_kovalenko_practicapmdm.data.db.ArticleRepository
import com.example.ivan_kovalenko_practicapmdm.viewmodel.HomeViewModel

class ArticleViewModelFactory(private val repository: ArticleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}