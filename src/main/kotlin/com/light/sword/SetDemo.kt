package com.light.sword

fun main() {
    test1()
    test2()
}

fun test4() {

}

fun test3() {
    val m1 = mapOf(1 to "A", 2 to "B", 3 to "C")
    val m2 = mapOf(3 to "C", 4 to "D", 5 to "E")
    val s1 = m1.keys
    val s2 = m2.keys
    // s1.addAll(s2) // Kotlin 设计上避免了这个坑
}

fun test2() {
    val m1 = hashMapOf(1 to "A", 2 to "B", 3 to "C")
    val m2 = hashMapOf(3 to "C", 4 to "D", 5 to "E")
    val s1 = m1.keys
    val s2 = m2.keys
    val s = HashSet<Int>()
    s.addAll(s1)
    s.addAll(s2)
    println(s)
}

fun test1() {
    val m1 = hashMapOf(1 to "A", 2 to "B", 3 to "C")
    val m2 = hashMapOf(3 to "C", 4 to "D", 5 to "E")
    val s1 = m1.keys
    val s2 = m2.keys
    s1.addAll(s2) // java.lang.UnsupportedOperationException
    println(s1)
}
