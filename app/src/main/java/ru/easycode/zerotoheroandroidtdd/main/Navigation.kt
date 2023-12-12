package ru.easycode.zerotoheroandroidtdd.main

import androidx.lifecycle.LiveData
import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper

interface Navigation : LiveDataWrapper<CharSequence> {

    interface Read {
        fun liveData(): LiveData<Screen>
    }

    interface Update {
        fun update(value: Screen)
    }

    interface Mutable : Read, Update
}