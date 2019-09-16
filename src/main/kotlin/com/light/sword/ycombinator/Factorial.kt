package com.light.sword.ycombinator

fun factorial(n: Int): Int {
    return when (n) {
        0 -> 1
        else -> n * factorial(n - 1)
    }
}

fun main() {
    val a = factorial(4)
    println(a) // 24

}

