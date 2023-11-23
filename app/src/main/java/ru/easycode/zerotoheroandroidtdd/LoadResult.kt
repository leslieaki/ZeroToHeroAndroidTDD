package ru.easycode.zerotoheroandroidtdd

interface LoadResult {

    fun show(updateLiveData: LiveDataWrapper.Update)

    data class Success(private val data: SimpleResponse) : LoadResult {
        override fun show(updateLiveData: LiveDataWrapper.Update) {
            return updateLiveData.update(UiState.ShowData(data.map()))
        }
    }

    data class Error(private val noConnection: Boolean) : LoadResult {
        override fun show(updateLiveData: LiveDataWrapper.Update) {
            val result = if (noConnection) "No internet connection" else "Something went wrong"
            return updateLiveData.update(UiState.ShowData(result))
        }
    }
}