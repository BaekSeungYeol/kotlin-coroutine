package me.whitewin.kotlincoroutine.ch15

import kotlinx.coroutines.*

class FetchUserUseCase(
    private val repo: UserDataRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun fetchUserData() = withContext(ioDispatcher) {
        val name = async { repo.getName() }
        val friends = async { repo.getFriends() }
        val profile = async { repo.getProfile() }

        User(
            name = name.await(),
            friends = friends.await(),
            profile = profile.await()
        )
    }

}