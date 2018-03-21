package com.kamontat.utils

import java.util.*
import kotlin.streams.asSequence

class RandomImp {
    private val str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    private var rand: Random = Random(System.nanoTime())

    fun getCharacter(): Char {
        return rand.ints(1, 0, str.length).asSequence().map(str::get).first()
    }

    fun getString(number: Long): String {
        return rand.ints(number, 0, str.length).asSequence().map(str::get).joinToString("")
    }

    fun getInt(from: Int, to: Int): Int {
        return rand.nextInt(to) + from
    }

    fun getLong(): Long {
        return rand.nextLong()
    }

    fun getString(from: Int, to: Int): String {
        return getString(getInt(from, to).toLong())
    }

    fun getString(): String {
        return getString(1, 30)
    }

    fun getStringLong(): String {
        return getString(getLong())
    }
}