package com.light.sword

import java.text.SimpleDateFormat


fun main() {
    val sf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    val s1 = "1927-12-31 23:54:07"
    val s2 = "1927-12-31 23:54:08"

    val d1 = sf.parse(s1)
    val d2 = sf.parse(s2)

    val ld1 = d1.time / 1000
    val ld2 = d2.time / 1000

    println(ld2 - ld1)
}
