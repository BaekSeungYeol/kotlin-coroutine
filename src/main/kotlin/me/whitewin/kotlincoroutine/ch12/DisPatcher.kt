package me.whitewin.kotlincoroutine.ch12

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

//var i = 0
//suspend fun main(): Unit = coroutineScope {
////    repeat(10_000) {
////        launch(Dispatchers.IO) {
////            i++
////        }
////    }
////    delay(1000)
////    println(i)
//
//    val dispatcher = Executors.newSingleThreadExecutor()
//        .asCoroutineDispatcher()
//
//    repeat(10_000) {
//        launch(dispatcher) {
//            i++
//        }
//    }
//    delay(1000)
//    println(i)
//
//}

suspend fun main(): Unit = coroutineScope {
    val dispatcher = Dispatchers.Default
        .limitedParallelism(1)

    val job = Job()
    repeat(5) {
        launch(dispatcher + job) {
            Thread.sleep(1000)
        }
    }
    job.complete()
    val time = measureTimeMillis { job.join() }
    println("Took $time")
}