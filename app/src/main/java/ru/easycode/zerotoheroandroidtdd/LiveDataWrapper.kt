package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    interface Update {
        fun update(value: UiState)
    }

    interface Mutable : Update{

        fun save(bundleWrapper: BundleWrapper.Save)

        fun liveData(): LiveData<UiState>
    }

    class Base(private val liveData: MutableLiveData<UiState> = SingleLiveEvent()) :
        Mutable {
        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { bundleWrapper.save(it) }
        }

        override fun update(value: UiState) {
            liveData.value = value
        }


        override fun liveData(): LiveData<UiState> = liveData
    }
}