package me.whitewin.kotlincoroutine.ch7

import kotlin.coroutines.CoroutineContext

class MyCustomContext: CoroutineContext.Element {

    override val key: CoroutineContext.Key<*>
        get() = Key

    companion object Key : CoroutineContext.Key<MyCustomContext>
}