package me.whitewin.kotlincoroutine.ch15

import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ScheduledNotiTest {

    @Test
    fun testSendNotifications() {
        // given
//        val notifications = List(100) { Notification(it)}
//        val repo = FakeNotificationRepository(
//            delayMillis = 200,
//            notifications = notifications
//        )
//        val service = FakeNotificationsService(
//            delayMillis = 300,
//        )

        val testScope = TestScope()
        testScope.advanceUntilIdle() // 모든 대기중인 작업이 완료될때까지 시간을 자동으로 이동
    }

}