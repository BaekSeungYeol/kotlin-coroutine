package me.whitewin.kotlincoroutine.ch8

import kotlinx.coroutines.*
import me.whitewin.kotlincoroutine.ch3.delay
//
//suspend fun main() = coroutineScope {
//    val job = Job()
//    println(job)
//    job.complete()
//    println(job)
//
//    val activeJob = launch {
//        delay(1000)
//    }
//
//    println(activeJob)
//    activeJob.join()
//    println(activeJob)
//
//    val lazyJob = launch(start = CoroutineStart.LAZY) {
//        delay(1000)
//    }
//    println(lazyJob)
//    lazyJob.start()
//    println(lazyJob)
//    lazyJob.join()
//    println(lazyJob)
//
//    val job2: Job = launch {
//        delay(1000)
//        println("Test")
//    }
//
//    val deferred: Deferred<String> = async {
//        delay(1000)
//        "Test"
//    }
//    val job3: Job = deferred
//}

fun main(): Unit = runBlocking {
//    val name = CoroutineName("Some name")
//    val job = Job()
//    launch(name + job) {
//        val childName = coroutineContext[CoroutineName]
//        println(childName == name)
//        val childJob = coroutineContext[Job]
//        println(childJob == job)
//        println(childJob == job.children.first())
//    }

    val job: Job = launch {
        delay(1000)
    }

    val parentJob: Job = coroutineContext.job
    println(job == parentJob)
    val parentChildren: Sequence<Job> = parentJob.children
    println(parentChildren.first() == job)
}