package com.light.sword.guava

import com.google.common.io.Files
import java.io.File
import java.nio.charset.Charset

val file = "/Users/jack/githubcode/kotlin-demo/src/main/kotlin/com/light/sword/guava/test.data"

fun main() {
    // Guava
    run {
        val lines = Files.readLines(File(file), Charset.forName("UTF-8"))
        for(line in lines){
            println(line)
        }
    }

    // Kotlin
    run {
        val lines = File(file).readLines(Charsets.UTF_8)
        for(line in lines){
            println(line)
        }
    }
}