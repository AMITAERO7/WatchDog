package com.hackernight.watchdog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hackernight.watchdog.model.DogBreed

class ListViewModel: ViewModel() {

    val dogs = MutableLiveData<List<DogBreed>>()
    val dogLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        val dog1 = DogBreed("1","Corgi","15","breedGroup","temp","XXX")
        val dog2 = DogBreed("2","laba","15","breedGroup","temp","XXX")
        val dog3 = DogBreed("3","locao","15","breedGroup","temp","XXX")

        val dogList = arrayListOf<DogBreed>(dog1,dog2,dog3)
        dogs.value = dogList
        dogLoadError.value = false
        loading.value = false
    }

}