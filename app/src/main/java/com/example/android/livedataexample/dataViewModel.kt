package com.example.android.livedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DataViewModel(startingTotal: Int): ViewModel(){
    private var count =  MutableLiveData<Int>()
    val totalCount: LiveData<Int>
    get() = count

    init {
        count.value = startingTotal
    }

    fun addCount(input: Int){
        count.value = (count.value)?.plus(input)
    }
}

class DataViewModelFactory(private val startingTotal: Int): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DataViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DataViewModel(startingTotal) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")      }

}