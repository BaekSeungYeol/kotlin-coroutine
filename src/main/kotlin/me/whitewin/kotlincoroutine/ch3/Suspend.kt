package me.whitewin.kotlincoroutine.ch3

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//suspend fun main() {
//    println("Before")
//
//    suspendCoroutine<Unit> { continuation ->
//        thread {
//            println("Suspended")
//            Thread.sleep(1000)
//            continuation.resume(Unit)
//            println("Resumed")
//        }
//    }
//
//    println("After")
//}

private val executor =
    Executors.newSingleThreadScheduledExecutor {
        Thread(it, "scheduler").apply { isDaemon = true }
    }

suspend fun delay(timeMillis: Long): Unit =
    suspendCoroutine { cont ->
        executor.schedule({
            cont.resume(Unit)
        }, timeMillis, TimeUnit.MILLISECONDS)
    }
suspend fun main() {
    println("Before")

    suspendCoroutine<Unit> { continuation ->
        executor.schedule({
            continuation.resume(Unit)
        },1000, TimeUnit.MILLISECONDS)
    }

    println("After")
}