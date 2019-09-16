package com.light.sword.guava

import com.google.common.base.Optional

/**
 * Optional用于包含非空对象的不可变对象。 Optional对象，用于不存在值表示null。这个类有各种实用的方法，以方便代码来处理为可用或不可用，而不是检查null值。
 */
fun main() {
    var a: Int? = null
    var b: Int? = null
    var s = sum(Optional.fromNullable(a), Optional.fromNullable(b))
    println("S=${s}")
    a = 1
    b = null
    s = sum(Optional.fromNullable(a), Optional.fromNullable(b))
    println("S=${s}")
    a = 1
    b = 1
    s = sum(Optional.fromNullable(a), Optional.fromNullable(b))
    println("S=${s}")

    // Kotlin
    a = null
    b = null
    println(sumK(a, b))
    a = null
    b = 1
    println(sumK(a, b))
    a = 1
    b = 1
    println(sumK(a, b))

}

fun sum(a: Optional<Int>, b: Optional<Int>): Int {
    println("a.isPresent:${a.isPresent}")
    println("b.isPresent:${b.isPresent}")
    val aa = a.or(0)
    val bb = b.or(0)
    return aa + bb
}

fun sumK(a: Int?, b: Int?): Int {
    return (a ?: 0) + (b ?: 0)
}