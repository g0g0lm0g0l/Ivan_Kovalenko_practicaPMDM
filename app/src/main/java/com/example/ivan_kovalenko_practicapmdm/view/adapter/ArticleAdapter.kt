package com.example.ivan_kovalenko_practicapmdm.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ivan_kovalenko_practicapmdm.R
import com.example.ivan_kovalenko_practicapmdm.data.db.model.Article
import com.example.ivan_kovalenko_practicapmdm.view.adapter.ArticleAdapter.ArticleViewHolder

class ArticleAdapter : ListAdapter<Article, ArticleViewHolder>(WORDS_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        //private val authorTextView: TextView = itemView.findViewById(R.id.textViewAuthor)
        private val contentTextView: TextView = itemView.findViewById(R.id.textViewContent)
        //private val urlTextView: TextView = itemView.findViewById(R.id.textViewUrl)

        fun bind(article: Article) {
            titleTextView.text = article.title
          //  authorTextView.text = article.author
            contentTextView.text = article.content
         //   urlTextView.text = article.url
        }

        companion object {
            fun create(parent: ViewGroup): ArticleViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_article_preview, parent, false)
                return ArticleViewHolder(view)
            }
        }
    }

    companion object {
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}
