package me.whitewin.kotlincoroutine.ch10

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import me.whitewin.kotlincoroutine.ch3.delay

//fun main(): Unit = runBlocking {
//    launch {
//        launch {
//            delay(1000)
//            throw Error("Some error")
//        }
//
//        launch {
//            delay(2000)
//            println("Will not be printed")
//        }
//
//        launch {
//            delay(500)
//            println("Will be printed")
//        }
//    }
//    launch {
//        delay(2000)
//        println("Will not be printed")
//    }
//}

//fun main(): Unit = runBlocking {
//    try {
//        launch {
//            delay(1000)
//            throw Error("Some error")
//        }
//    } catch (e: Throwable) {
//        println("Will not be printed 1")
//    }
//
//    launch {
//        delay(2000)
//        println("Will not be printed 2")
//    }
//}