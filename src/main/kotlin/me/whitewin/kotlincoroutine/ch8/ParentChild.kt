package me.whitewin.kotlincoroutine.ch8

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import me.whitewin.kotlincoroutine.ch3.delay

//fun main(): Unit = runBlocking(CoroutineName("main")) {
//    val name = coroutineContext[CoroutineName]?.name
//    println(name)
//    launch {
//        delay(1000)
//        val name = coroutineContext[CoroutineName]?.name
//        println(name)
//    }
//}