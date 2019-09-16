package com.light.sword.kts

import java.io.File

// hello world
println("Hello World!")
// variable
val a = "I am cat"
println(a)
// for loop
var sum = 0
val nums = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
for (i in nums) {
    sum += i
}
println("sum is $sum")
// condition
val x = 1
val y = 1
if (x == y) {
    println("x=Y")
} else if (x > y) {
    println("x>Y")
} else {
    println("x<Y")
}

// io
val f = File(".")
val path = f.absolutePath
println("path:$path")

// fun
fun sum(a: Int, b: Int): Int {
    return a + b
}

val c = sum(1, 2)
println("c is $c")

