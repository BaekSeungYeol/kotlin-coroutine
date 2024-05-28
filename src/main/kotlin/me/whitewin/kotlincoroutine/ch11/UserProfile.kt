package me.whitewin.kotlincoroutine.ch11

import kotlinx.coroutines.*

class UserProfile {

//    suspend fun getUserProfile(): String {
//        val user = getUserData()
//        val notifications = getNotifications()
//
//        return UserProfileData(
//            user = user,
//            notifications = notifications
//        )
//    }

//    suspend fun getUserProfile(): UserProfileData {
//        val user = GlobalScope.async { getUserData() }
//        val notifications = GlobalScope.async { getNotifications() }
//
//        return UserProfileData(
//            user = user.await(),
//            notifications = notifications.await()
//        )
//    }

    fun getUserData(): String {
        return ""
    }

    fun getNotifications(): String {
        return ""
    }
}

data class Details(val name: String, val followers: Int)
data class Tweet(val text: String)

fun getFollowersNumber(): Int = throw Error("Service exception")

suspend fun getUserName(): String {
    delay(500)
    return "marcinmoskala"
}

suspend fun getTweets(): List<Tweet> {
    return listOf(Tweet("Hello, world"))
}

suspend fun CoroutineScope.getUserDetails(): Details = coroutineScope{
    val userName = async { getUserName() }
    val followersNumber = async { getFollowersNumber() }
    Details(userName.await(), followersNumber.await())
}

//fun main() = runBlocking {
//    val details = try {
//            getUserDetails()
//        } catch (e: Error) {
//            null
//        }
//    val tweets = async { getTweets() }
//    println("User: $details")
//    println("Tweets: ${tweets.await()}")
//}

suspend fun main(): Unit = coroutineScope {
//    val s = async { getUserName() }
//    val t = async { throw IllegalArgumentException() }
//    println("${s.await()}")
//    println("${t.await()}")
}
