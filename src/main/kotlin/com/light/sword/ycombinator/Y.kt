package com.light.sword.ycombinator

/**
 * FP: Y Combinator
 *
 * lambda f. (lambda x. (f(x x)) lambda x. (f(x x)))
 * Created by jack on 2017/7/9.
 */

typealias G<T, R> = (T) -> R

interface F<T, R> : Function1<F<T, R>, G<T, R>>

fun <T, R> f(block: (F<T, R>) -> G<T, R>) = object : F<T, R> {
    // 调用函数自身
    override fun invoke(g: F<T, R>) = block(g)
}

typealias E<T, R> = Function1<G<T, R>, G<T, R>>

/**
 * Y 组合子函数
 * @param e :E 入参，是一个函数类型 Function1<G<T, R>, G<T, R>>
 */
fun <T, R> Y(e: E<T, R>) = ({ g: F<T, R> -> g(g) })(f { g ->
    e { x -> g(g)(x) }
})

/**
 * 用 Y 组合子实现 factorial 阶乘函数
 */
val factorial: (Int) -> Int = Y { f ->
    { x ->
        if (x == 0) 1 else x * f(x - 1)
    }
}

/**
 * 用 Y 组合子实现 fibonacci 数列函数 fib: (T)->R
 * Y(fib) = fib
 * 可以推断： Y(Y(fib)) = Y(fib) = fib
 */
val fib: (Int) -> Int = Y { f ->
    { x ->
        if (x == 1 || x == 2) 1 else f(x - 1) + f(x - 2)
    }
}

fun main() {
    println(fib(10)) // 55
    println(factorial(10)) // 3628800
}