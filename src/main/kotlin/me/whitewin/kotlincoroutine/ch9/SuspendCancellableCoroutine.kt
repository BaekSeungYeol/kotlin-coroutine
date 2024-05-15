package me.whitewin.kotlincoroutine.ch9

import kotlinx.coroutines.suspendCancellableCoroutine
import me.whitewin.kotlincoroutine.ch3.continuation

suspend fun someTask() = suspendCancellableCoroutine<String> { cont ->
    cont.invokeOnCancellation {

    }
    //
}
