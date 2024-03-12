package com.example.ivan_kovalenko_practicapmdm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ivan_kovalenko_practicapmdm.databinding.FragmentReadBinding

class ReadFragment : Fragment() {

    private var _binding: FragmentReadBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReadBinding.inflate(inflater, container, false)
        return binding.root
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
