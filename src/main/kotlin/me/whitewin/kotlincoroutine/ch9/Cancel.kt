package me.whitewin.kotlincoroutine.ch9

import kotlinx.coroutines.*
import kotlin.random.Random

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

//suspend fun main(): Unit = coroutineScope {
//    val job = launch {
//        repeat(1_000) { i ->
//            delay(100)
//            Thread.sleep(100)
//            println("Printing $i")
//        }
//    }
//    delay(1100)
////    job.cancel()
////    job.join()
//    job.cancelAndJoin()
//    println("Cancelled succesfully")
//}

//suspend fun main(): Unit = coroutineScope {
//    val job = Job()
//    launch(job) {
//        try {
//            delay(Random.nextLong(2000))
//            println("Done")
//        } finally {
//            print("Will always be printed")
//        }
//    }
//    delay(1000)
//    job.cancelAndJoin()
//}

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(2000)
            println("Job is done")
        } finally {
            println("Finally")
            launch {
                println("Will not be printed")
            }
            delay(1000)
            println("Will not be printed")
        }
    }
    delay(1000)
    job.cancelAndJoin()
    println("Cancel done")
}

//suspend fun main(): Unit = coroutineScope {
//    val job = Job()
//    launch(job) {
//        try {
//            delay(200)
//            println("Coroutine finished")
//        } finally {
//            println("Finally")
//            withContext(NonCancellable) {
//                delay(1000L)
//                println("Cleanup done")
//            }
//        }
//    }
//    delay(100)
//    job.cancelAndJoin()
//    println("Done")
//}