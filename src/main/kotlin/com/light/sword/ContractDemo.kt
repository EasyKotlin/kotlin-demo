package com.light.sword

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract


open class Animal(name: String)

fun Animal.isCat(): Boolean {
    return this is Cat
}


class Cat : Animal("Cat") {
    fun miao() {
        println("MIAO~")
    }
}

class Dog : Animal("Dog") {
    fun wang() {
        println("WANG~")
    }
}


@ExperimentalContracts
fun Animal.isDog(): Boolean {
    contract {
        returns(true) implies (this@isDog is Dog)
    }
    return this is Dog
}




@ExperimentalContracts
fun main() {

    var cat = Animal("Cat")
    if (cat.isCat()) {
        cat = cat as Cat
        cat.miao()
    }

    val dog = Animal("Dog")
    if (dog.isDog()) {
        dog.wang()
    }

    val demo = ContractDemo()
    demo.f1("abc")
    demo.f2("abc")
    demo.f3("abc")


    val nullList: List<Any>? = null
    val b1 = nullList.isNullOrEmpty() // true

    val empty: List<Any>? = emptyList<Any>()
    val b2 = empty.isNullOrEmpty() // true

    val collection: List<Char>? = listOf('a', 'b', 'c')
    val b3 = collection.isNullOrEmpty() // false

    println(b1)
    println(b2)
    println(b3)
}


@ExperimentalContracts
class ContractDemo {

    fun f1(s: String?): Int {
        return if (s != null) {
            s.length
        } else 0
    }

    fun f2(s: String?): Int {
        return if (isNotEmpty(s)) {
            s?.length ?: 0  // 我们需要使用 ?.
        } else 0
    }

    fun f3(s: String?): Int {
        return if (isNotEmptyWithContract(s)) {
            s.length
        } else 0
    }
}

fun isNotEmpty(s: String?): Boolean {
    return s != null && s != ""
}

//由于Contract契约API还是Experimental，所以需要使用ExperimentalContracts注解声明
@ExperimentalContracts
fun isNotEmptyWithContract(s: String?): Boolean {
    // 这里契约的意思是: 调用 isNotEmptyWithContract 函数，会产生这样的效果: 如果返回值是true, 那就意味着 s != null. 把这个契约行为告知到给编译器，编译器就知道了下次碰到这种情形，你的 s 就是非空的，自然就smart cast了。
    contract {
        returns(true) implies (s != null)
    }
    return s != null && s != ""
}



