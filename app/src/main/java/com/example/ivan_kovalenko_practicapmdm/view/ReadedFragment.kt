package com.example.ivan_kovalenko_practicapmdm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ivan_kovalenko_practicapmdm.databinding.FragmentReadedBinding

class ReadedFragment : Fragment() {

    private var _binding: FragmentReadedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReadedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // No se necesitan argumentos, solo establecer el texto del TextView
        binding.textViewFragmentNameInfo.text = "Esto es el fragment_readed.xml"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
