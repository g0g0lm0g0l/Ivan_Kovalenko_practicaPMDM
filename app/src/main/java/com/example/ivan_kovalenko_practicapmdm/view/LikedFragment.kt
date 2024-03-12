package com.example.ivan_kovalenko_practicapmdm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ivan_kovalenko_practicapmdm.AppSystemdApplication
import com.example.ivan_kovalenko_practicapmdm.ArticleViewModelFactory
import com.example.ivan_kovalenko_practicapmdm.R
import com.example.ivan_kovalenko_practicapmdm.databinding.FragmentLikedBinding
import com.example.ivan_kovalenko_practicapmdm.view.adapter.ArticleAdapter
import com.example.ivan_kovalenko_practicapmdm.viewmodel.HomeViewModel

class LikedFragment : Fragment() {

    private var _binding: FragmentLikedBinding? = null
    private val binding get() = _binding!!

    private val articleViewModel: HomeViewModel by viewModels {
        ArticleViewModelFactory((requireActivity().application as AppSystemdApplication).repository)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLikedBinding.inflate(inflater, container, false)
        val view = binding.root

        // Initialize RecyclerView and Adapter
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerNewsLiked)
        val adapter = ArticleAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Observe LiveData and update RecyclerView
        articleViewModel.allArticles.observe(viewLifecycleOwner) { articles ->
            articles?.let { adapter.submitList(it) }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Aquí puedes inicializar vistas, configurar adaptadores, etc.
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
