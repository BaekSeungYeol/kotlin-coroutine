package me.whitewin.kotlincoroutine.ch9

import kotlinx.coroutines.*
import kotlin.random.Random

//suspend fun main(): Unit = coroutineScope {
//    val job = launch {
//        delay(1000)
//    }
//    job.invokeOnCompletion {
//        println("Finished")
//    }
//    delay(400)
//    job.cancelAndJoin()
//}

//suspend fun main(): Unit = coroutineScope {
//    val job = launch {
//        delay(Random.nextLong(2400))
//        println("Finished")
//    }
//    delay(800)
//    job.invokeOnCompletion { exception: Throwable? ->
//        println("Will alwyas be printed")
//        println("The exception was: $exception")
//    }
//    delay(800)
//    job.cancelAndJoin()
//}

//suspend fun main(): Unit = coroutineScope {
//    val job = Job()
//    launch(job) {
//        repeat(1_000) { i ->
//            Thread.sleep(200)
//            yield()
//            println("Printing $i")
//        }
//    }
//    delay(1000)
//    job.cancelAndJoin()
//    println("Cancelled successfully")
//    delay(1000)
//}

//suspend fun main(): Unit = coroutineScope {
//    val job = Job()
//    launch(job) {
//        do {
//            Thread.sleep(200)
//            println("Printing")
//        } while(isActive)
//    }
//    delay(1100)
//    job.cancelAndJoin()
//    println("Cancelled successfully")
//}

//suspend fun main(): Unit = coroutineScope {
//    val job = Job()
//    launch(job) {
//        repeat(1000) { num ->
//            Thread.sleep(200)
//            ensureActive()
//            println("Printing $num")
//        }
//    }
//    delay(1100)
//    job.cancelAndJoin()
//    println("Cancelled successfully")
//}
