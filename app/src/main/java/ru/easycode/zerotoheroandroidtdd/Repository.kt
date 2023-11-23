package ru.easycode.zerotoheroandroidtdd

interface Repository {

    suspend fun load(): LoadResult

    class Base(private val service: SimpleService, private val url: String) : Repository {
        override suspend fun load(): LoadResult {

        }
    }
}