package com.example.ivan_kovalenko_practicapmdm.viewmodel

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ivan_kovalenko_practicapmdm.R
import com.example.ivan_kovalenko_practicapmdm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Aquí se accede a los EditTexts a través del binding
        binding.apply {
            // Asignar el clic de un botón o cualquier otro evento para realizar la navegación
            buttonNavigate.setOnClickListener {
                // Obtener el texto ingresado en los EditTexts
                val nombre = textViewNombre.text.toString()
                val apellidos = textViewApellidos.text.toString()

                // Crear un Bundle para pasar los argumentos al siguiente fragmento
                val bundle = Bundle().apply {
                    putString("nombre", nombre)
                    putString("apellidos", apellidos)
                }

                // Navegar al siguiente fragmento con los argumentos
                findNavController().navigate(R.id.readedFragment, bundle)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

