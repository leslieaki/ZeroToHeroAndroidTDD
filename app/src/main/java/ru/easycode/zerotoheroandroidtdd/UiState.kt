package ru.easycode.zerotoheroandroidtdd

interface UiState {

    fun apply()

    object ShowProgress : UiState {
        override fun apply() {
            TODO("Not yet implemented")
        }
    }

    object ShowData : UiState {
        override fun apply() {
            TODO("Not yet implemented")
        }
    }
}