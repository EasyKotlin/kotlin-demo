package com.light.sword

fun main() {
    zero(proc { println("0 proc called $it"); it }, "Hoo")
    one(proc { println("1 proc called $it"); it }, "Hello")
    two(proc { println("2 proc called $it"); it }, "Hi")
    three(proc { println("3 proc called $it"); it }, "Hey")
}


fun <T> proc(x: (T) -> T): (T) -> T = x

fun <T> zero(proc: (T) -> T, x: T) = x
fun <T> one(proc: (T) -> T, x: T) = proc(x)
fun <T> two(proc: (T) -> T, x: T) = proc(proc(x))
fun <T> three(proc: (T) -> T, x: T) = proc(proc(proc(x)))

/*
1 proc called Hello
2 proc called Hi
2 proc called Hi
3 proc called Hey
3 proc called Hey
3 proc called Hey
*/