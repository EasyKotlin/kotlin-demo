package com.light.sword.guava

import com.google.common.collect.Sets

fun main() {
    run {
        // Guava
        val s1 = Sets.newHashSet("a", "b", "c", "d")
        val s2 = Sets.newHashSet("d", "e", "f")
        val s3 = Sets.union(s1, s2)
        val s4 = Sets.intersection(s1, s2)
        println(s3) // [a, b, c, d, e, f]
        println(s4) // [d]
    }


    run {
        // Kotlin
        val s1 = setOf("a", "b", "c", "d")
        val s2 = setOf("d", "e", "f")
        val s3 = s1.union(s2)
        val s4 = s1.intersect(s2)
        println(s3) // [a, b, c, d, e, f]
        println(s4) // [d]
    }


}