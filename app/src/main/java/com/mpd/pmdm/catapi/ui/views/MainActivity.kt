package com.mpd.pmdm.catapi.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.mpd.pmdm.catapi.R
import com.mpd.pmdm.catapi.ui.viewmodel.CatsViewModel
import com.mpd.pmdm.catapi.ui.viewmodel.CatsViewModelFactory

class MainActivity : AppCompatActivity() {
    private val viewModel: CatsViewModel by viewModels { CatsViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton: Button = findViewById(R.id.btnMasGatos)
        boton.setOnClickListener {
            viewModel.moreCats()
        }

    }
}