package com.light.sword.guava

import com.google.common.base.Function
import com.google.common.base.Functions

/** Guava Function
 * Guava提供了很多工具方法，以便用Function或Predicate操作集合。这些方法通常可以在集合工具类找到，如Iterables，Lists，Sets，Maps，Multimaps等。
 */
interface Function1<A, B> : Function<A, B>

interface Function2<B, C> : Function<B, C>

fun main() {
    // Guava
    run {

        val f1 = object : Function1<String, Int> {
            override fun apply(x: String?): Int? {
                return x?.length
            }
        }

        val f2 = object : Function2<Int, Boolean> {
            override fun apply(x: Int?): Boolean? {
                if (x != null) {
                    return x % 2 == 0
                } else {
                    return false
                }
            }
        }

        val f = Functions.compose(f2, f1)
        val strings = listOf("a", "ab", "abc", "abcd")
        val result = mutableListOf<String>()
        for (s in strings) {
            val p = f.apply(s)
            if (p != null) {
                if (p) {
                    result.add(s)
                }
            }
        }
        println(result) // [ab, abcd]
    }

    // Kotlin
    run {
        val f1: (String) -> Int = { x -> x.length }
        val f2: (Int) -> Boolean = { x -> x % 2 == 0 }
        val f: (String) -> Boolean = { x -> f2(f1(x)) }

        val strings = listOf("a", "ab", "abc", "abcd")
        val result = strings.filter(f)
        println(result) // [ab, abcd]
    }
}
