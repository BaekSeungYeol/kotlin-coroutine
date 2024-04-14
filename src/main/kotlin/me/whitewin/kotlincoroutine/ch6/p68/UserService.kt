package me.whitewin.kotlincoroutine.ch6.p68

import org.springframework.stereotype.Service

@Service
class UserService {
    fun findUserById(userId: Long): User {
        return User(1L)
    }

}
data class User(
    val id: Long
) {
}