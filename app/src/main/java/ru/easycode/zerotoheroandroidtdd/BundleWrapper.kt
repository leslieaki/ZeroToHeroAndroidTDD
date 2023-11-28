package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle

interface BundleWrapper {

    interface Mutable: Save, Restore

    interface Save {
        fun save(liveDataWrapper: ListLiveDataWrapper)
    }

    interface Restore {
        fun restore(liveDataWrapper: ListLiveDataWrapper)
    }
}