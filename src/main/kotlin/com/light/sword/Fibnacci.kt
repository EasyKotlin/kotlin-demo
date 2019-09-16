package com.light.sword


fun main() {
    println(fibnacci(10))
    println(factorial(5))
}


fun fibnacci(n: Int): Int {
    println("fibnacci($n) called")

    return when (n) {
        1 -> 1
        2 -> 1
        else -> fibnacci(n - 1) + fibnacci(n - 2)
    }
}

fun factorial(n: Int): Int {
    println("factorial($n) called")
    return when (n) {
        1 -> 1
        else -> n * factorial(n - 1)
    }
}
