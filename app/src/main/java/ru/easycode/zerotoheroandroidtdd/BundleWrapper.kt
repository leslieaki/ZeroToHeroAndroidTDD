package ru.easycode.zerotoheroandroidtdd

interface BundleWrapper {

    interface Mutable : Save, Restore

    interface Save {
        fun save(uiState: UiState)
    }

    interface Restore {
        fun restore(): UiState
    }

    class Base() : BundleWrapper {

    }
}