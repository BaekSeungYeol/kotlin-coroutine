package me.whitewin.kotlincoroutine.ch7

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

suspend fun main(): Unit = coroutineScope {
    launch(CoroutineName("Name1")) {
        // TODO ..
    }
    launch(CoroutineName("Name2") + Job()) {
        // TODO ..
    }

//    val name: CoroutineName = CoroutineName("A Name")
//    val element: CoroutineContext.Element = name
//    val context: CoroutineContext = element
//
//    val job: Job = Job()
//    val jobElement: CoroutineContext.Element = job
//    val jobContext: CoroutineContext = jobElement

//    val ctx: CoroutineContext = CoroutineName("A name")
//    val coroutineName: CoroutineName? = ctx[CoroutineName]
//    println(coroutineName?.name)
//    val job: Job? = ctx[Job]
//    println(job)

//    val ctx1: CoroutineContext = CoroutineName("Name1")
//    println(ctx1[CoroutineName]?.name)
//    println(ctx1[Job]?.isActive)
//
//    val ctx2: CoroutineContext = Job()
//    println(ctx2[CoroutineName]?.name)
//    println(ctx2[Job]?.isActive)
//
//    val ctx3 = ctx1 + ctx2
//    println(ctx3[CoroutineName]?.name)
//    println(ctx3[Job]?.isActive)
//
//    val empty: CoroutineContext = EmptyCoroutineContext
//    println(empty[CoroutineName])
//    println(empty[Job])
//
//    val ctxName = empty + CoroutineName("Name1") + empty
//    println(ctxName[CoroutineName])

//    val ctx = CoroutineName("Name1") + Job()
//    println(ctx[CoroutineName]?.name)
//    println(ctx[Job]?.isActive)
//
//    val ctx2 = ctx.minusKey(CoroutineName)
//    println(ctx2[CoroutineName]?.name)
//    println(ctx2[Job]?.isActive)
//
//    val ctx3 = (ctx + CoroutineName("Name2"))
//        .minusKey(CoroutineName)
//    println(ctx3[CoroutineName]?.name)
//    println(ctx3[Job]?.isActive)

//    val ctx = CoroutineName("Name1") + Job()
//    ctx.fold("") { acc, element -> "$acc$element"}
//        .also(::println)

//    log("Started")
//    val v1 = async(CoroutineName("c1")) {
//        delay(500)
//        log("Running async")
//        42
//    }
//    launch {
//        delay(1000)
//        log("Running launch")
//    }
//    log("The answer is ${v1.await()}")

//    printName()
//    withContext(CoroutineName("Outer")) {
//        printName()
//        launch(CoroutineName("Inner")) {
//            printName()
//        }
//        delay(10)
//        printName()
//    }

}

fun CoroutineScope.log(msg: String) {
    val name = coroutineContext[CoroutineName]?.name
    println("[$name] $msg")
}

suspend fun printName() {
    println(coroutineContext[CoroutineName]?.name)
}