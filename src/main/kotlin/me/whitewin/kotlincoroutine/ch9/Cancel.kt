package me.whitewin.kotlincoroutine.ch9

import kotlinx.coroutines.*

//suspend fun main(): Unit = coroutineScope {
//    val job = launch {
//        repeat(1_000) { i ->
//            delay(200)
//            println("Printing  $i")
//        }
//    }
//
//    delay(1100)
//    job.cancel()
//    job.join()
//    println("Cancelled successfully")
//}

suspend fun main(): Unit = coroutineScope {
    val job = launch {
        repeat(1_000) { i ->
            delay(100)
            Thread.sleep(100)
            println("Printing $i")
        }
    }
    delay(1100)
//    job.cancel()
//    job.join()
    job.cancelAndJoin()
    println("Cancelled succesfully")
}