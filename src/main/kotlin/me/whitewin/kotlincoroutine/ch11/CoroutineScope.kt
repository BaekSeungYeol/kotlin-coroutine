package me.whitewin.kotlincoroutine.ch11

import kotlinx.coroutines.*

//fun main() = runBlocking {
//    val a = coroutineScope {
//        delay(1000)
//        10
//    }
//    println("a is calculated")
//    val b = coroutineScope {
//        delay(1000)
//        20
//    }
//    println(a)
//    println(b)
//}

suspend fun longTask() = coroutineScope {
    launch {
        delay(1000)
        val name = coroutineContext[CoroutineName]?.name
        println("[$name] Finished task 1")
    }
    launch {
        delay(2000)
        val name = coroutineContext[CoroutineName]?.name
        println("[$name] Finished taask 2")
    }
}

fun main(): Unit = runBlocking {
    val job = launch(CoroutineName("Parent")) {
        longTask()
    }
    delay(1500)
    job.cancel()
}