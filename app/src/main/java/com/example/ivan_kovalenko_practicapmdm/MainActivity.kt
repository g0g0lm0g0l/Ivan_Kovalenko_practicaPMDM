package com.example.ivan_kovalenko_practicapmdm

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ivan_kovalenko_practicapmdm.data.db.NewsDataSource
import com.example.ivan_kovalenko_practicapmdm.databinding.ActivityMainBinding
import com.example.ivan_kovalenko_practicapmdm.viewmodel.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private var importData: Boolean? = false

    private val articleViewModel: HomeViewModel by viewModels {
        ArticleViewModelFactory((application as AppSystemdApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TDOO: Insert News Manually
        if (!importData!!) {
            articleViewModel.insertAll(NewsDataSource.getNews())
        }


        navController = findNavController(R.id.nav_host_fragment)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavigationView.setupWithNavController(navController)

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage("Welcome!!!")
            .setTitle("Bienvenido!!!")


        val dialog: AlertDialog = builder.create()
        dialog.show()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
