package com.example.ivan_kovalenko_practicapmdm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ivan_kovalenko_practicapmdm.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mostrar el contenido de los TextViews
        val arguments = requireArguments()
        val nombre = arguments.getString("nombre")
        val apellidos = arguments.getString("apellidos")

        binding.apply {
            textViewNombre.text = nombre
            textViewApellidos.text = apellidos
        }

        // No hay ningún botón para volver al homeFragment en InfoFragment
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
