package ru.easycode.zerotoheroandroidtdd

import retrofit2.http.GET

interface SimpleService {

    @GET("https://raw.githubusercontent.com/JohnnySC/ZeroToHeroAndroidTDD/task/018-clouddatasource/app/sampleresponse.json")
    suspend fun fetch(url: String): SimpleResponse
}