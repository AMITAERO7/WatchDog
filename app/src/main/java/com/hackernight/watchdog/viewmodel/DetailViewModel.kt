package com.hackernight.watchdog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hackernight.watchdog.model.DogBreed

class DetailViewModel :ViewModel() {
    var dogLiveData = MutableLiveData<List<DogBreed>>()

    fun fetch(){
        val dog1 = DogBreed("1","Corgi","15","breedGroup","temp","XXX")
        val dog2 = DogBreed("2","laba","15","breedGroup","temp","XXX")
        val dog3 = DogBreed("3","locao","15","breedGroup","temp","XXX")
        val dogList = arrayListOf<DogBreed>(dog1,dog2,dog3)

        dogLiveData.value = dogList
    }
}