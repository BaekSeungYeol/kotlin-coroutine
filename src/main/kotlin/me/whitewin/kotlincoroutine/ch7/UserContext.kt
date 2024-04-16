package me.whitewin.kotlincoroutine.ch7

import kotlinx.coroutines.withContext
import java.util.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

data class User(val id: String, val name: String)

abstract class UuidProviderContext : CoroutineContext.Element {

    abstract fun nextUuid(): String

    override val key: CoroutineContext.Key<*>
        get() = Key

    companion object Key : CoroutineContext.Key<UuidProviderContext>
}

class RealUuidProviderContext: UuidProviderContext() {
    override fun nextUuid(): String =
        UUID.randomUUID().toString()
}

class FakeUuidProviderContext(
    private val fakeUuid: String
): UuidProviderContext() {
    override fun nextUuid(): String = fakeUuid

}

suspend fun nextUuid(): String =
    checkNotNull(coroutineContext[UuidProviderContext]) {
        "UuidProviderContext not present"
    }.nextUuid()

suspend fun makeUser(name: String) = User(
    id = nextUuid(),
    name = name
)

suspend fun main(): Unit {
    withContext(RealUuidProviderContext()) {
        println(makeUser("Michal"))
    }
    withContext(FakeUuidProviderContext("FAKE_UUID")) {
        val user = makeUser("Michal")
        println(user)
    }
}