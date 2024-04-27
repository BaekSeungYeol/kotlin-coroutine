package me.whitewin.kotlincoroutine.ch8

import kotlinx.coroutines.*
import java.lang.Thread.sleep

//fun main(): Unit = runBlocking {
//    val job1 = launch {
//        delay(1000)
//        println("Test1")
//    }
//
//    val job2 = launch {
//        delay(2000)
//        println("Test2")
//    }
//
//    job1.join()
//    job2.join()
//
////    val children = coroutineContext[Job]
////        ?.children
////
////    val childrenNum = children?.count()
////    println("Number of children: $childrenNum")
////    children?.forEach { it.join() }
//
//    println("All tests are done")
//}

//suspend fun main(): Unit = coroutineScope {
//    val job = Job()
//    launch(job) {
//        delay(1000)
//        println("Text 1")
//    }
//
//    launch(job) {
//        delay(2000)
//        println("Text 2")
//    }
//
////    job.children.forEach { it.join() }
//    println("Will not be printed")
//}

//fun main() = runBlocking {
//    val job = Job()
//
//    launch(job) {
//        repeat(5) { num ->
//            delay(200)
//            println("Rep$num")
//        }
//    }
//
//    launch {
//        delay(500)
//        job.completeExceptionally(Error("Some error"))
//    }
//
//    job.join()
//
//    launch(job) {
//        println("Will not be printed")
//    }
//
//    println("Done")
//}

suspend fun main(): Unit = coroutineScope {
    val parentJob = Job()
    val job = Job(parentJob)
    launch(job) {
        delay(1000)
        println("Text 1")
    }

    launch(job) {
        delay(2000)
        println("Text 2")
    }
    delay(1100)
    parentJob.cancel()
    job.children.forEach { it.join() }
}