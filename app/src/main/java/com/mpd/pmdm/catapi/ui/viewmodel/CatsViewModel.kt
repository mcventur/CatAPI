package com.mpd.pmdm.catapi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.mpd.pmdm.catapi.CatApplication
import com.mpd.pmdm.catapi.data.CatsRepository
import com.mpd.pmdm.catapi.data.remote.CatModel

class CatsViewModel(private val catsRepository: CatsRepository) : ViewModel() {
    //En vez de declararlo con igual, lo declaro con get()=, para que en cada referencia
    //se haga una nueva llamada
    private val newCats get() =  catsRepository.fetchCats()

    private val _cats = MediatorLiveData<List<CatModel>>()
    val cats: LiveData<List<CatModel>> = _cats


    init{
        //Guardamos en el mediator _cats lo que ya tenía más el rsultado de una nueva llamada a la api
        _cats.addSource(newCats){
            val nuevaLista = mutableListOf<CatModel>()
            nuevaLista.addAll(_cats.value ?: emptyList())
            nuevaLista.addAll(it)
            _cats.value = nuevaLista
        }
    }

    fun moreCats() {
        //Simplemente, refresca el LiveData con 10 gatos nuevos haciendo otra llamada a la api
        //Esto debería actualizar el mediatorLiveData, que observa los cambios de newCats
        newCats
    }

}

@Suppress("UNCHECKED_CAST")
class CatsViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val app = checkNotNull(extras[APPLICATION_KEY]) as CatApplication
        return CatsViewModel(app.catsRepository) as T
    }
}