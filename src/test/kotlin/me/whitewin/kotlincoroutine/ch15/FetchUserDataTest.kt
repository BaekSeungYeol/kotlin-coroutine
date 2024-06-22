package me.whitewin.kotlincoroutine.ch15

import kotlinx.coroutines.*
import kotlinx.coroutines.test.currentTime
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FetchUserDataTest {


    @Test
    fun `should load data concurrently`() = runTest {
        // given
        val userRepo = FakeUserDataRepository()
        val useCase = FetchUserUseCase(userRepo)

        // when
        useCase.fetchUserData()

        // then
        assertEquals(1000, currentTime)
    }

    @Test
    fun `should construct user`() = runTest {
        // given
        val userRepo = FakeUserDataRepository()
        val useCase = FetchUserUseCase(userRepo)

        // when
        val result = useCase.fetchUserData()

        // then
        val expectedUser = User(
            name = "Ben",
            friends = listOf(Friend("some-friend-id-1")),
            profile = Profile("Example description")
        )

        assertEquals(expectedUser, result)
    }

    @Test
    fun `should increment counter`() = runTest {
        var i = 0
        launch {
            while(true) {
                delay(1000)
                i++
            }
        }
        delay(1001)
        assertEquals(1, i)
        delay(1000)
        assertEquals(2, i)
    }

    @Test
    fun `should increment counter v2`() = runTest {
        var i = 0
        backgroundScope.launch {
            while(true) {
                delay(1000)
                i++
            }
        }
        delay(1001)
        assertEquals(1, i)
        delay(1000)
        assertEquals(2, i)
    }

    @Test
    fun `should map async and keep elements order`() = runTest {
        val transforms = listOf(
            suspend { delay(3000); "A"},
            suspend { delay(2000); "B"},
            suspend { delay(4000); "C"},
            suspend { delay(1000); "D" }
        )

        val res = transforms.mapAsync { it() }
        assertEquals(listOf("A" , "B", "C", "D"), res)
        assertEquals(4000, currentTime)
    }

    suspend fun <T,R> Iterable<T>.mapAsync(
        transformation: suspend (T) -> R
    ): List<R> = coroutineScope {
        this@mapAsync.map { async { transformation(it) }}
            .awaitAll()
    }

}