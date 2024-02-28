package com.mpd.pmdm.catapi.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mpd.pmdm.catapi.R
import com.mpd.pmdm.catapi.databinding.ActivityMainBinding
import com.mpd.pmdm.catapi.ui.viewmodel.CatsViewModel

class MainActivity : AppCompatActivity() {

    val catsViewModel: CatsViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.moreCatsButton.setOnClickListener {
            catsViewModel.moreCats()
        }

    }
}