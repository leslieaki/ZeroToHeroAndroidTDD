package ru.easycode.zerotoheroandroidtdd

import java.lang.IllegalStateException

interface Count {

    fun increment(number: String): String

    class Base(private val step: Int) : Count {
        init {
            if (step < 1) throw IllegalStateException()
        }

        override fun increment(number: String): String =
            (number.toInt() + step).toString()
    }
}