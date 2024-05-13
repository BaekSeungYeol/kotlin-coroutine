package me.whitewin.kotlincoroutine.ch9

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val job = launch {
        delay(1000)
    }
    job.invokeOnCompletion {
        println("Finished")
    }
    delay(400)
    job.cancelAndJoin()
}