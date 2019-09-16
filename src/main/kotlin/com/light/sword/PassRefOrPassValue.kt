package com.light.sword

fun main() {

}

fun changeReference(f: Foo): Foo {
    val g = Foo()
    // g = f
    g.a = f.a
    return g
}

fun modifyReference(f: Foo) {
    f.a = "b"
}

class Foo {
    var a: String = ""
}
