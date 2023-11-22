package ru.easycode.zerotoheroandroidtdd

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository
) {
    private val liveData = liveDataWrapper.liveData()

    fun load() {}

    fun save(bundleWrapper: BundleWrapper.Save) {

    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
    }
}