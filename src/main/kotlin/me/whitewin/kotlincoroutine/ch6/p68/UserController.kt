package me.whitewin.kotlincoroutine.ch6.p68

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class UserController(
    private val tokenService: TokenService,
    private val userService: UserService
) {

    @GetMapping("/me")
    suspend fun findUser(
        userId: String,
        authorization: String
    ): String = coroutineScope {
        val id = async { tokenService.readUserId(authorization) }
        val user = userService.findUserById(id.await())
        user.toString()
    }
}