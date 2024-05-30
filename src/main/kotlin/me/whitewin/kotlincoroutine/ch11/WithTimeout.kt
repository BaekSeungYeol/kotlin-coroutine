package me.whitewin.kotlincoroutine.ch11

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

suspend fun test(): Int = withTimeout(1500) {
    delay(1000)
    println("Still thinking")
    delay(1000)
    println("Done!")
    42
}

//suspend fun main(): Unit = coroutineScope {
//    try {
//        test()
//    } catch (e: TimeoutCancellationException) {
//        println("Cancelled")
//    }
//    delay(1000)
//}

//suspend fun main(): Unit = coroutineScope {
//    launch { // 1
//        launch { // 2
//            delay(2000)
//            println("Will not be printed")
//        }
//        withTimeout(1000) {
//            delay(1500)
//        }
//    }
//    launch { // 3
//        delay(5000)
//        println("Done")
//    }
//}

//suspend fun fetchUser(): User {
//    while(true) {
//        yield()
//    }
//}
//
//suspend fun getUserOrNull(): User? =
//    withTimeoutOrNull(5000) {
//        fetchUser()
//    }
//
//suspend fun main(): Unit = coroutineScope {
//    val user = getUserOrNull()
//    println("User: $user")
//}
//
//suspend fun calculateAnswerOrNull(): User? =
//    withContext(Dispatchers.Default) {
//        withTimeoutOrNull(1000) {
//            calculateAnswer()
//        }
//    }

//val analyticsScope = CoroutineScope(SupervisorJob())
//suspend fun showUserData() = coroutineScope {
//    val name = async { repo.getName() }
//    val friends = async { repo.getFriends() }
//    val profile = async { repo.getProfile() }
//    val user = User(
//        name = name.await(),
//        friends = friends.await(),
//        profile = profile.await()
//    )
//    view.show(user)
//    analyticsScope.launch { repo.notifyProfileShown() }
//}