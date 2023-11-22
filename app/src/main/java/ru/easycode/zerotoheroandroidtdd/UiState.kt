package ru.easycode.zerotoheroandroidtdd

interface UiState {

    object ShowProgress : UiState

    class ShowData(private val text: String) : UiState
}