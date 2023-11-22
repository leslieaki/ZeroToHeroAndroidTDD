package ru.easycode.zerotoheroandroidtdd
    
interface SimpleService {

    suspend fun fetch(url: String): SimpleResponse
}