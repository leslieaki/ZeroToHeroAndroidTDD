package ru.easycode.zerotoheroandroidtdd

interface Repository {

    suspend fun load()

    class Base(): Repository {
        override suspend fun load() {

        }
    }
}