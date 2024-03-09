package com.example.ivan_kovalenko_practicapmdm.viewmodel

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        // Obtener los datos pasados desde el fragmento anterior
        val arguments = requireArguments()
        val nombre = arguments.getString("nombre")
        val apellidos = arguments.getString("apellidos")

        // Mostrar los datos en los TextViews
        binding.apply {
            textViewNombre.text = nombre
            textViewApellidos.text = apellidos
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}