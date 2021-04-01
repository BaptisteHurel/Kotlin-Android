package com.iplant.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    val text = MutableLiveData<String>().apply {
        value = "This is settings Fragment"
    }

}