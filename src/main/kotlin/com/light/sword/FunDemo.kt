package com.light.sword


fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
// 引用一个函数
    val evens = numbers.pick(::isEven)
// 直接使用一个函数变量
    val odds = numbers.pick(isOdd)
// 使用 Lambda 表达式
    val greaterThanFive = numbers.pick { it > 5 }
    println("evens:$evens")
    println("odds:$odds")
    println("greaterThanFive:$greaterThanFive")

// 一切皆是映射：map
    val add: (Int) -> Int = { x -> x + 1 }
    val numbers1 = numbers.map(add)

    val numbers2 = numbers.map { it * it }
    val numbers3 = numbers.map { "$it#" }
    println("numbers1:$numbers1")
    println("numbers2:$numbers2")
    println("numbers3:$numbers3")


}

/**
 * List 的扩展函数 pick
 * @param picker 函数入参，函数类型是：(T) -> Boolean
 * @return List<T> 根据 picker 函数映射出来的列表结果
 */
fun <T> List<T>.pick(picker: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (t in this) {
        if (picker(t)) {
            result.add(t)
        }
    }
    return result
}


/**
 * List 的扩展函数 map
 * @param mapper 函数入参，函数类型是： (T) -> R
 * @return List<R> 根据 mapper 函数映射出来的列表结果
 */
fun <T, R> List<T>.map(mapper: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    for (t in this) {
        result.add(mapper(t))
    }
    return result
}


fun isEven(x: Int): Boolean {
    return x % 2 == 0
}

val isOdd: (Int) -> Boolean = { x -> x % 2 != 0 }

/** 输出：
evens:[2, 4, 6]
odds:[1, 3, 5, 7]
greaterThanFive:[6, 7]
numbers1:[2, 3, 4, 5, 6, 7, 8]
numbers2:[1, 4, 9, 16, 25, 36, 49]
numbers3:[1#, 2#, 3#, 4#, 5#, 6#, 7#]
 */