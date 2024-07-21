package me.whitewin.kotlincoroutine.ch15

import org.jetbrains.annotations.Async.Schedule
import org.springframework.scheduling.annotation.Scheduled

class ScheduledNoti {

    @Scheduled(fixedRate = 5000)
    fun sendNotifications() {
        // coroutine schedule job
    }
}