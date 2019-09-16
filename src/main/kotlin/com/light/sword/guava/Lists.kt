package com.light.sword.guava

import com.google.common.base.Function
import com.google.common.collect.ImmutableList
import com.google.common.collect.Lists

fun main() {
    run {
        // Guava
        val list1 = Lists.newArrayList("a", "b", "c")
        val list2 = Lists.newArrayList("c", "d", "e")

        val list3 = ImmutableList.builder<Int>().add(1, 2, 3, 4, 5, 6, 7)
        println(list3)
        val list4 = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7)
        val a = Lists.partition(list4, 2)
        println(a) // [[1, 2], [3, 4], [5, 6], [7]]

        val list5 = Lists.transform(list4, object : Function<Int, Int> {
            override fun apply(e: Int?): Int? {
                return e?.times(e)
            }
        })
        println(list5) // [1, 4, 9, 16, 25, 36, 49]

    }

    run {
        // Kotlin
        val list1 = listOf("a", "b", "c")
        val list2 = listOf("c", "d", "e")

        val list3 = listOf(1, 2, 3, 4, 5, 6, 7)
        val b = list3.partition {
            it < 5
        }
        println(b) // ([1, 2, 3, 4], [5, 6, 7])

        val list4 = list3.map { e -> e * e }
        println(list4) // [1, 4, 9, 16, 25, 36, 49]
    }

}