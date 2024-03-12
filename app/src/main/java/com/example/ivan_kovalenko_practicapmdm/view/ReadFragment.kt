package com.example.ivan_kovalenko_practicapmdm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ivan_kovalenko_practicapmdm.AppSystemdApplication
import com.example.ivan_kovalenko_practicapmdm.ArticleViewModelFactory
import com.example.ivan_kovalenko_practicapmdm.R
import com.example.ivan_kovalenko_practicapmdm.databinding.FragmentReadBinding
import com.example.ivan_kovalenko_practicapmdm.view.adapter.ArticleAdapter
import com.example.ivan_kovalenko_practicapmdm.viewmodel.ReadViewModel
import kotlinx.coroutines.launch

class ReadFragment : Fragment() {
    private var _binding: FragmentReadBinding? = null
    private val binding get() = _binding!!

    private val articleViewModel: ReadViewModel by viewModels {
        ArticleViewModelFactory((requireActivity().application as AppSystemdApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReadBinding.inflate(inflater, container, false)
        val view = binding.root

        // Initialize RecyclerView and Adapter
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerNewsRead)
        val adapter = ArticleAdapter(
            onLikeClicked = { article ->
                // Handle like clicked
                article.isFav = article.isFav != true
                articleViewModel.viewModelScope.launch {
                    articleViewModel.update(article)
                }
            },
            onReadClicked = { article ->
                // Handle read clicked
                article.isRead = article.isRead != true
                articleViewModel.viewModelScope.launch {
                    articleViewModel.update(article)
                }
            })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Observe LiveData and update RecyclerView
        articleViewModel.allReadArticles.observe(viewLifecycleOwner) { articles ->
            articles?.let { adapter.submitList(it) }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textViewFragmentNameInfo.text = "Hola de Ivan"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
