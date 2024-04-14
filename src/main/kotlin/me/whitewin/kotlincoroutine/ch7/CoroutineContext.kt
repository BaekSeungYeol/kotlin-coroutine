package me.whitewin.kotlincoroutine.ch7

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

suspend fun main() = coroutineScope {
    launch(CoroutineName("Name1")) {
        // TODO ..
    }
    launch(CoroutineName("Name2") + Job()) {
        // TODO ..
    }

    val name: CoroutineName = CoroutineName("A Name")
    val element: CoroutineContext.Element = name
    val context: CoroutineContext = element

    val job: Job = Job()
    val jobElement: CoroutineContext.Element = job
    val jobContext: CoroutineContext = jobElement

}