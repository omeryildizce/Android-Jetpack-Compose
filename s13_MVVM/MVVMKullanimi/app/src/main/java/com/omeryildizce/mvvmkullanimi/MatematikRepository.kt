package com.omeryildizce.mvvmkullanimi

import androidx.lifecycle.MutableLiveData

class MatematikRepository {
    var matematikselSonuc = MutableLiveData<String>()
    init {
        matematikselSonuc = MutableLiveData<String> ("0")
    }
    fun matematikselSonucuGetir():MutableLiveData<String>{
        return matematikselSonuc
    }
    fun topla(alinanSayi1: String = "0", alinanSayi2:String = "0") {
        matematikselSonuc.value = ((alinanSayi1.toIntOrNull() ?: 0) + (alinanSayi2.toIntOrNull() ?: 0)).toString()
    }
    fun carp(alinanSayi1: String = "0", alinanSayi2:String = "0")  {
        matematikselSonuc.value = ((alinanSayi1.toIntOrNull() ?: 0) * (alinanSayi2.toIntOrNull() ?: 0)).toString()
    }
}