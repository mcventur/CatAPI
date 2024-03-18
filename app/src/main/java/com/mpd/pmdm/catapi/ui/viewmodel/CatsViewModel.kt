package com.mpd.pmdm.catapi.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.mpd.pmdm.catapi.core.Cat
import com.mpd.pmdm.catapi.core.CatApp
import com.mpd.pmdm.catapi.data.CatRepository

class CatsViewModel(private val catRepository: CatRepository): ViewModel() {
    private val _catsList = MediatorLiveData<List<Cat>>()
    val catList: LiveData<List<Cat>> = _catsList

    private val newCatList get() = catRepository.fetchCats()


    init{
        _catsList.addSource(newCatList){
            val newList = mutableListOf<Cat>()
            newList.addAll(catList.value ?: emptyList())
            newList.addAll(it)
            _catsList.value = newList
        }
    }

    fun moreCats(){
        newCatList
    }


}

@Suppress("UNCHECKED_CAST")
class CatsViewModelFactory: ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val app =  checkNotNull(extras[APPLICATION_KEY]) as CatApp
        return CatsViewModel(app.catRepository) as T
    }
}