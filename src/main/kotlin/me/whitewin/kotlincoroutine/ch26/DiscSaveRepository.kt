package me.whitewin.kotlincoroutine.ch26

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//class DiscSaveRepository(
//    private val discReader: DiscReader
//): SaveRepository {
//
//    override suspend fun loadSave(name: String): SaveData =
//        withContext(Dispatchers.IO) {
//            discReader.read("save/$name")
//        }
//}