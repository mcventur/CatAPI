package com.mpd.pmdm.catapi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.mpd.pmdm.catapi.CatApplication
import com.mpd.pmdm.catapi.data.CatsRepository
import com.mpd.pmdm.catapi.data.remote.CatModel

class CatsViewModel(private val catsRepository: CatsRepository) : ViewModel() {
    val cats: LiveData<List<CatModel>> = catsRepository.fetchCats()
}

@Suppress("UNCHECKED_CAST")
class CatsViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val app = checkNotNull(extras[APPLICATION_KEY]) as CatApplication
        return CatsViewModel(app.catsRepository) as T
    }
}