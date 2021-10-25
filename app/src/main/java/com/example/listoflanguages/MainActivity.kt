package com.example.listoflanguages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listoflanguages.adapters.RvAdapter
import com.example.listoflanguages.databinding.ActivityMainBinding
import com.example.listoflanguages.models.Language

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private lateinit var rvAdapter: RvAdapter
    private lateinit var languageList: List<Language>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadLanguage()

        rvAdapter = RvAdapter(languageList)

        // attach adapter to the recycler view
        binding.rvList.adapter = rvAdapter
        binding.rvList.layoutManager = LinearLayoutManager(this)
    }

    // add items to the list manually in our case
    private fun loadLanguage() {
        languageList = listOf(
            Language("Java" , "Exp : 3 years"),
            Language("Kotlin" , "Exp : 2 years"),
            Language("Python" , "Exp : 4 years"),
            Language("JavaScript" , "Exp : 6 years"),
            Language("PHP" , "Exp : 1 years"),
            Language("CPP" , "Exp : 8 years"),
        )
    }

    // on destroy of view make the binding reference to null
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}