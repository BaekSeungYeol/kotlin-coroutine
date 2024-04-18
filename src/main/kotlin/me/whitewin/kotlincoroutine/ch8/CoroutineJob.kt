package me.whitewin.kotlincoroutine.ch8

import kotlinx.coroutines.*
import me.whitewin.kotlincoroutine.ch3.delay

suspend fun main() = coroutineScope {
    val job = Job()
    println(job)
    job.complete()
    println(job)

    val activeJob = launch {
        delay(1000)
    }

    println(activeJob)
    activeJob.join()
    println(activeJob)

    val lazyJob = launch(start = CoroutineStart.LAZY) {
        delay(1000)
    }
    println(lazyJob)
    lazyJob.start()
    println(lazyJob)
    lazyJob.join()
    println(lazyJob)

}