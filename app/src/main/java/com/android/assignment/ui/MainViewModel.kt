package com.android.assignment.ui

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.android.assignment.model.Category
import com.android.assignment.model.Image
import com.android.assignment.repository.Repository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    val imagesMLD = MediatorLiveData<List<Image>>()

    fun getImages() {
        imagesMLD.addSource(repository.getImages()){
            it?.let {
                imagesMLD.value = it
            }
        }
    }
}