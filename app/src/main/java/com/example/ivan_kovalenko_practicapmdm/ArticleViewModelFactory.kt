package com.example.ivan_kovalenko_practicapmdm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ivan_kovalenko_practicapmdm.data.db.ArticleRepository
import com.example.ivan_kovalenko_practicapmdm.viewmodel.HomeViewModel
import com.example.ivan_kovalenko_practicapmdm.viewmodel.LikedViewModel
import com.example.ivan_kovalenko_practicapmdm.viewmodel.ReadViewModel

class ArticleViewModelFactory(private val repository: ArticleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(LikedViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LikedViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(ReadViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ReadViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}