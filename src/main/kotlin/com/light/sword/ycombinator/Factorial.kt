package com.light.sword.ycombinator

class Factorial {
    fun factorial(n: Int): Int {
        return when (n) {
            0 -> 1
            else -> n * factorial(n - 1)
        }
    }
}

fun main() {
    val f = Factorial()
    val a = f.factorial(4)
    println(a) // 24
}
