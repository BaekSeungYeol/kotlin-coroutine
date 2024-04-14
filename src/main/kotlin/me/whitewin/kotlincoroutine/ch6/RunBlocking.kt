package me.whitew

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//fun main() {
//    runBlocking {// 코루틴이 중단되었을 경우 시작한 스레드를 중단시킴.
//        delay(1000L)
//        println("World!")
//    }
//
//    runBlocking {
//        delay(1000L)
//        println("World!")
//    }
//
//    runBlocking {
//        delay(1000L)
//        println("World!")
//    }
//
//    println("Hello,")
//
//
//}

fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    launch {
        delay(2000L)
        println("World!")
    }
    println("Hello,")
    // delay(3000L)
}