package com.example.tpstatscovid.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tpstatscovid.models.Pays

class SearchViewModel : ViewModel(){

    val paysList = MutableLiveData<List<Pays>>()

    fun getPays(){
        paysList.value = listOf()(
            Pays("pays1", "https://fr.wikipedia.org/wiki/Galerie_des_drapeaux_des_pays_du_monde#/media/Fichier:Flag_of_France.svg"),
            Pays("pays2","https://fr.wikipedia.org/wiki/Galerie_des_drapeaux_des_pays_du_monde#/media/Fichier:Flag_of_Japan.svg" ),
            Pays("pays3", "https://fr.wikipedia.org/wiki/Galerie_des_drapeaux_des_pays_du_monde#/media/Fichier:Flag_of_Nepal.svg"),
            Pays("pays4", "https://fr.wikipedia.org/wiki/Galerie_des_drapeaux_des_pays_du_monde#/media/Fichier:Flag_of_Jamaica.svg"),
        )
    }
}