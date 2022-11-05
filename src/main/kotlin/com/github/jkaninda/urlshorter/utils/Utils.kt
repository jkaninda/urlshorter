package com.github.jkaninda.urlshorter.utils

import java.lang.StringBuilder
import java.util.*

object Utils {
    fun generateRandom(len: Int): String {
        val chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val rnd = Random()
        val sb = StringBuilder(len)
        for (i in 0 .. len) sb.append(chars[rnd.nextInt(chars.length)])
        return sb.toString()
    }


}