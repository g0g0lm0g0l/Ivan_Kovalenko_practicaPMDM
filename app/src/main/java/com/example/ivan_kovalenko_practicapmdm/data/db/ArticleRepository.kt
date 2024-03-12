package com.example.ivan_kovalenko_practicapmdm.data.db

import com.example.ivan_kovalenko_practicapmdm.data.db.model.Article
import kotlinx.coroutines.flow.Flow

class ArticleRepository(private val articleDao: ArticleDao) {

    val allArticles: Flow<List<Article>> = articleDao.getAllArticles()

    val allFavArticles: Flow<List<Article>> = articleDao.getAllFavArticles()

    val allReadArticles: Flow<List<Article>> = articleDao.getAllReadArticles()


    suspend fun insert(article: Article) {
        articleDao.insert(article)
    }

    suspend fun insertAll(articles: List<Article>) {
        articleDao.insertAll(articles)
    }

    suspend fun update(article: Article) {
        articleDao.updateArticle(article)
    }
}