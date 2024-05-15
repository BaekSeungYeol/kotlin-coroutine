package me.whitewin.kotlincoroutine.ch10

import kotlinx.coroutines.*

class MyException: Throwable()

//suspend fun main() = supervisorScope {
//    val str1 = async<String> {
//        delay(1000)
//        throw MyException()
//    }
//
//    val str2 = async {
//        delay(2000)
//        "Text2"
//    }
//
//    try {
//        println(str1.await())
//    } catch (e: MyException) {
//        println(e)
//    }
//
//    println(str2.await())
//}

//object MyNonPropagatingException : CancellationException()
//
//suspend fun main(): Unit = coroutineScope {
//    launch {
//        launch {
//            delay(2000)
//            println("Will not be printed")
//        }
//        throw MyNonPropagatingException
//    }
//    launch {
//        delay(2000)
//        println("Will be printed")
//    }
//}

fun main(): Unit = runBlocking {
    val handler = CoroutineExceptionHandler { ctx, exception ->
            println("Caught $exception")
        }
    val scope = CoroutineScope(SupervisorJob() + handler)
    scope.launch {
        delay(1000)
        throw Error("Some error")
    }

    scope.launch {
        delay(2000)
        println("Will be printed")
    }

    delay(3000)
}