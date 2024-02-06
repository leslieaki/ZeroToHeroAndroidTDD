package ru.easycode.zerotoheroandroidtdd.list

import android.util.Log
import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper

interface ListLiveDataWrapper {

    interface Read : LiveDataWrapper.Read<List<CharSequence>>

    interface Update : LiveDataWrapper.Update<List<CharSequence>>

    interface Mutable : Read, Update {
        fun save(bundleWrapper: BundleWrapper.Save)
    }

    interface Add {
        fun add(source: CharSequence)
    }

    interface All : Mutable, Add

    class Base : LiveDataWrapper.Abstract<List<CharSequence>>(), All {
        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let {
                Log.d("livedatawrapper trigger","livedatawrapper")
                bundleWrapper.save(ArrayList(it)) }
        }

        override fun add(source: CharSequence) {
            Log.d("listlivedatawrapper","listlivedatawrapper trigger")
            val currentList = liveData.value ?: ArrayList()
            val newList = ArrayList<CharSequence>()
            newList.addAll(currentList)
            newList.add(source)
            liveData.value = newList //update(newList)
        }
    }
}