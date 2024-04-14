package me.whitewin.kotlincoroutine.ch6

import kotlinx.coroutines.*

fun main() = runBlocking {
//    val resultDeferred = GlobalScope.async {
//        delay(1000L)
//        42
//    }
//
//    println(resultDeferred.await())

//    val res1 = GlobalScope.async { // == luanch but 값을 반환
//        delay(1000L)
//        "Text 1"
//    }
//
//    val res2 = GlobalScope.async {
//        delay(2000L)
//        "Text 2"
//    }
//
//    val res3 = GlobalScope.async {
//        delay(2000L)
//        "Text 3"
//    }
//
//    println(res1.await())
//    println(res2.await())
//    println(res3.await())

    val news = async {
        getNews()
    }
    val newsSummary = getNewsSummary()

    showNews(
        newsSummary,
        news.await()
    )


}

fun showNews(newsSummary: List<String>, await: List<String>) {
    TODO("DO SOMETHING..")
}

fun getNews(): List<String> = listOf("news1", "news2")
fun getNewsSummary(): List<String> = listOf("news1-sum1", "news2-sum2")