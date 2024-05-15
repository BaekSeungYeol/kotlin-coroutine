package me.whitewin.kotlincoroutine.ch10

import kotlinx.coroutines.*
import me.whitewin.kotlincoroutine.ch3.delay

//fun main(): Unit = runBlocking {
//    val scope = CoroutineScope(SupervisorJob())
//    scope.launch {
//        delay(1000L)
//        throw Error("Some error")
//    }
//
//    scope.launch {
//        delay(2000)
//        println("Will be printed")
//    }
//
//    delay(3000)
//}

//fun main(): Unit = runBlocking {
//    val job = SupervisorJob()
//    launch(job) {
//        delay(1000)
//        throw Error("Some error")
//    }
//
//    launch(job) {
//        delay(2000)
//        println("Will be printed")
//    }
//    delay(3000)
//}

fun main(): Unit = runBlocking {
    supervisorScope {
        launch {
            delay(1000)
            throw Error("Some error")
        }

        launch {
            delay (2000)
            println("Will be printed")
        }
    }
    delay(1000)
    println("Done")
}

//suspend fun notifyAnalytics(actions: List<UserAction>) =
//    supervisorScope {
//        actions.forEach { action ->
//            launch {
//                notifyAnalytics(actions)
//            }
//        }
//    }