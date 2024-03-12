package com.example.ivan_kovalenko_practicapmdm.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ivan_kovalenko_practicapmdm.data.db.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(article: Article)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(articles: List<Article>)

    @Update
    suspend fun updateArticle(article: Article)

    @Query("SELECT * FROM articles WHERE id = :id")
    fun getUpdatedArticle(id: Int): Flow<Article?>

    // The flow always holds/caches latest version of data. Notifies its observers when the data has changed.
    @Query("SELECT * FROM articles")
    fun getAllArticles(): Flow<List<Article>>

    @Query("SELECT * FROM articles WHERE isFav = 1")
    fun getAllFavArticles(): Flow<List<Article>>

    @Query("SELECT * FROM articles WHERE isRead = 1")
    fun getAllReadArticles(): Flow<List<Article>>


}