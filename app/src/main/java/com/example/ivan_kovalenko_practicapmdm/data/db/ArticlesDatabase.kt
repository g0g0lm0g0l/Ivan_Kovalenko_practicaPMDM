package com.example.ivan_kovalenko_practicapmdm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ivan_kovalenko_practicapmdm.data.db.model.Article

@Database(
    entities = [Article::class], version = 1,
    exportSchema = false
)
abstract class ArticlesDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    companion object {
        @Volatile
        private var INSTANCE: ArticlesDatabase? = null

        fun getDatabase(
            context: Context
        ): ArticlesDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, ArticlesDatabase::class.java, "article_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}