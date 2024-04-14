package me.whitewin.kotlincoroutine.ch6.p68

import org.springframework.stereotype.Service

@Service
class TokenService {

    fun readUserId(authorization: String): Long {
        return 1L
    }
}