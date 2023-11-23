package ru.easycode.zerotoheroandroidtdd

import com.google.gson.annotations.SerializedName

data class SimpleResponse(
    @SerializedName("text")
    private val text: String
) {
    fun map(): String = text
}