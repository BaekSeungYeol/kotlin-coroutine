package me.whitewin.kotlincoroutine.ch6

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.whitewin.kotlincoroutine.ch3.delay

fun main() {

    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello,")
//    Thread.sleep(2000L)

}