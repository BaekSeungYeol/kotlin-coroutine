package me.whitewin.kotlincoroutine.ch9

import kotlinx.coroutines.*

//class ProfileViewModel {
//    private val scope =
//        CoroutineScope(Dispatchers.Main + SupervisorJob())
//
//    fun onCreate() {
////        scope.launch { loadUserData() }
//    }
//
//    fun onCleared() {
//        scope.coroutineContext.cancelChildren()
//    }
//}

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            repeat(1_000) { i ->
                delay(200)
                println("Printing $i")
            }
        } catch (e: CancellationException) {
            println(e)
            throw e
        }
    }
    delay(1100)
    job.cancelAndJoin()
    println("Cancelled successfully")
    delay(1000)
}
