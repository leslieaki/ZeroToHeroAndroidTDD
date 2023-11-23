package ru.easycode.zerotoheroandroidtdd

interface LoadResult {

    class Success(private val data: SimpleResponse)

    class Error(private val noConnection: Boolean)
}