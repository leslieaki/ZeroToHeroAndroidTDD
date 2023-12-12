package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper<T> {

    interface Read<T : Any> {
        fun liveData(): LiveData<T>
    }

    interface Update<T : Any> {
        fun update(value: T)
    }

    interface Mutable<T : Any> : Read<T>, Update<T>

    abstract class Abstract(private val liveData: MutableLiveData<CharSequence> = SingleLiveEvent()) :
        Mutable<CharSequence> {
        override fun liveData(): LiveData<CharSequence> = liveData()

        override fun update(value: CharSequence) {
            liveData.value = value
        }
    }
}