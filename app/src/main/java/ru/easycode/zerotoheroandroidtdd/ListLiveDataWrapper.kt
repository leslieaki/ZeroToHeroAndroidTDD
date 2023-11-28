package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ListLiveDataWrapper {

    fun liveData(): LiveData<List<CharSequence>>
    fun add(new: CharSequence)
    fun save(bundle: BundleWrapper.Save)
    fun update(list: List<CharSequence>)

//    class Base(private val liveData: MutableLiveData<> = MutableLiveData()) :
//        ListLiveDataWrapper {
//
//    }
}
