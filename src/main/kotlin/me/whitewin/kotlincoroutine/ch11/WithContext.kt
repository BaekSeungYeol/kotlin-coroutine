package me.whitewin.kotlincoroutine.ch11

import kotlinx.coroutines.*

fun CoroutineScope.log(text: String) {
    val name = this.coroutineContext[CoroutineName]?.name
    println("[$name] $text")
}

fun main() = runBlocking(CoroutineName("Parent")) {

    log("Before")

    withContext(CoroutineName("Child 1")) {
        delay(1000)
        log("Hello 1")
    }

    withContext(CoroutineName("Child 2")) {
        delay(1000)
        log("Hello 2")
    }

    log("After")
}