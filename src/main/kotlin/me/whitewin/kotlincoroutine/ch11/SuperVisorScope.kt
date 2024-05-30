package me.whitewin.kotlincoroutine.ch11

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

//    supervisorScope {
//        launch {
//            delay(1000)
//            throw Error()
//        }
//
//        launch {
//            delay(2000)
//            println("Done")
//        }
//    }

fun main() = runBlocking {
    println("Before")

    withContext(SupervisorJob()) {
            launch {
                delay(1000)
                throw Error()
            }

            launch {
                delay(2000)
                println("Done")
            }
    }

    println("After")
}

//suspend fun notifyAnalytics(actions: List<UserAction>) = supervisorScope {
//    actions.forEach { action ->
//        launch {
//            notifyAnalytics(action)
//        }
//    }
//}
