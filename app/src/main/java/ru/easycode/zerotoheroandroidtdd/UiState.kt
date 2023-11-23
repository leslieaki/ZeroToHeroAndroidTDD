package ru.easycode.zerotoheroandroidtdd

interface UiState {

    object ShowProgress : UiState

    data class ShowData(private val text: String) : UiState
}