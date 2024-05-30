package me.whitewin.kotlincoroutine.ch11

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withTimeout
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WithTimeoutKtTest {

    @Test
    fun testTime2() = runTest {
        withTimeout(1000) {
            delay(900)
        }
    }


    @Test
    fun testTimeoutCancellationException(): Unit = runTest {
        assertThrows<TimeoutCancellationException> {
            // 예외를 발생시키는 코루틴 함수 호출
            withTimeout(1000) {
                delay(1100)
            }
        }
    }

    @Test
    fun testTime3() = runBlocking {
        withTimeout(1000) {
            delay(900)
        }
    }
}