package me.whitewin.kotlincoroutine.ch12

import kotlinx.coroutines.*
import me.whitewin.kotlincoroutine.ch3.delay
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

suspend fun main(): Unit = withContext(newSingleThreadContext("Thread1")) {
    var continuation: Continuation<Unit>? = null

    launch(newSingleThreadContext("Thread2")) {
        delay(1000)
        continuation?.resume(Unit)
    }

    launch(Dispatchers.Unconfined) {
        println(Thread.currentThread().name)

        suspendCancellableCoroutine<Unit> {
            continuation = it
        }

        println(Thread.currentThread().name)

        delay(1000)

        println(Thread.currentThread().name)
    }
}