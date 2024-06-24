package me.whitewin.kotlincoroutine.ch15

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//suspend fun readSave(name: String): GameState =
//    withContext(Dispatchers.IO) {
//        reader.readCsvBlocking(name, GameState::class.java)
//    }

//suspend fun calculateModel() =
//    withContext(Dispatchers.Default) {
//        model.fit(
//            dataset = newTrain,
//            epochs = 10,
//            batchSize = 100,
//            verbose = false,
//        )
//    }

suspend fun sendUserData() {
//    val userData = database.getUserData()
//    progressBarVisible.value = true
//    userRepository.sendUserData(userData)
//    progressBarVisible.value = false
}