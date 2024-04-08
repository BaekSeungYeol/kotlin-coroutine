package me.whitewin.kotlincoroutine.ch4

import me.whitewin.kotlincoroutine.ch3.delay

suspend fun myFunction() {
    println("Before")
    delay(1000)
    println("After")
}
