package me.whitewin.kotlincoroutine.ch26

import kotlinx.coroutines.suspendCancellableCoroutine

//suspend fun requestNews(): News {
//    return suspendCancellableCoroutine<News> { cont ->
//        val call = requestNewsApi { news ->
//            cont.resume(news)
//        }
//        cont.invokeOnCancellation {
//            call.cancel()
//        }
//    }
//}