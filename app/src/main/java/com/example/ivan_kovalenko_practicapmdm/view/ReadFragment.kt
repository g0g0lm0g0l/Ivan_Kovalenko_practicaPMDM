package com.example.ivan_kovalenko_practicapmdm.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import com.google.android.material.snackbar.Snackbar
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

        binding.textViewFragmentNameInfo.text = "Hola de Ivan"

        binding.buttonExp.setOnClickListener {
            Toast.makeText(context, "Botón buttonExp presionado", Toast.LENGTH_SHORT).show()
        }
        binding.buttonImp.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)

            intent.type = "text/plain"

            intent.putExtra(Intent.EXTRA_TEXT, "Hola mundo")

            startActivity(Intent.createChooser(intent, "Compartir mensaje a través de:"))
            Snackbar.make(binding.root, "Botón buttonImp presionado", Snackbar.LENGTH_SHORT).show()
        }

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


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
