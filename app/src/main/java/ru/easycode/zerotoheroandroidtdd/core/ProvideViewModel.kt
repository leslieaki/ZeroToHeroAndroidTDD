package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.create.CreateViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.list.ListViewModel
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel
import ru.easycode.zerotoheroandroidtdd.main.Navigation

interface ProvideViewModel {

    fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T

    class Base(
        private val clearViewModel: ClearViewModel
    ) : ProvideViewModel {
        private val navigation = Navigation.Base()
        private val liveData = ListLiveDataWrapper.Base()
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when (viewModelClass) {
                MainViewModel::class.java -> MainViewModel(navigation)
                ListViewModel::class.java -> ListViewModel(liveData, navigation, clearViewModel)
                CreateViewModel::class.java -> CreateViewModel(
                    liveData,
                    navigation,
                    clearViewModel
                )

                else -> throw Exception()
            } as T
        }
    }
}
