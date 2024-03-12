package com.example.ivan_kovalenko_practicapmdm

import android.app.Application
import com.example.ivan_kovalenko_practicapmdm.data.db.ArticleRepository
import com.example.ivan_kovalenko_practicapmdm.data.db.ArticlesDatabase

class AppSystemdApplication : Application() {

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    private val database by lazy { ArticlesDatabase.getDatabase(this) }
    val repository by lazy { ArticleRepository(database.articleDao()) }
}
