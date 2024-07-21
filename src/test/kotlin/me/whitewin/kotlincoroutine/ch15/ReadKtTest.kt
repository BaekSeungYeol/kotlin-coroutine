//package me.whitewin.kotlincoroutine.ch15
//
//import kotlinx.coroutines.test.advanceTimeBy
//import kotlinx.coroutines.test.advanceUntilIdle
//import kotlinx.coroutines.test.runCurrent
//import kotlinx.coroutines.test.runTest
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Test
//
//class ReadKtTest {
//
//    @Test
//    fun `should show progress bar when sending data`() = runTest {
//        // given
//        val database = FakeDatabase()
//        val vm = UserViewModel(database)
//
//        // when
//        launch {
//            vm.sendUserData()
//        }
//
//        // then
//        assertEquals(false, vm.progressBarVisible.value)
//
//        // when
//        advanceTimeBy(1000)
//
//        // then
//        assertEquals(false, vm.progressBarVisibility.value)
//
//        // when
//        runCurrent()
//
//        // then
//        assertEquals(true, vm.progressBarVisibility.value)
//
//        // when
//        advanceUntilIdle()
//
//        // then
//        assertEquals(false, vm.progressBarVisibility.value)
//
//
//
//    }
//}