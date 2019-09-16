package com.light.sword.guava

import com.google.common.base.Joiner
import com.google.common.base.Splitter

fun main() {
    val list = listOf("A","B","C")
    val a = Joiner.on("-").join(list)
    println(a) // A-B-C
    val b = Splitter.on("-").split(a)
    println(b) // [A, B, C]

    // Kotlin
    val c = list.joinToString("-")
    val d = c.split("-")
    println(c) // A-B-C
    println(d) // [A, B, C]

}

