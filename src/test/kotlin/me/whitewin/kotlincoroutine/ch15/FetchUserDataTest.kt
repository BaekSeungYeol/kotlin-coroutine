package me.whitewin.kotlincoroutine.ch15

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.coroutines.CoroutineContext

class FetchUserDataTest {


    @Test
    fun `should load data concurrently`() = runTest {
        // given
        val userRepo = FakeUserDataRepository()
        val useCase = FetchUserUseCase(userRepo)

        // when
        useCase.fetchUserData()

        // then
        assertEquals(1000, currentTime)
    }

    @Test
    fun `should construct user`() = runTest {
        // given
        val userRepo = FakeUserDataRepository()
        val useCase = FetchUserUseCase(userRepo)

        // when
        val result = useCase.fetchUserData()

        // then
        val expectedUser = User(
            name = "Ben",
            friends = listOf(Friend("some-friend-id-1")),
            profile = Profile("Example description")
        )

        assertEquals(expectedUser, result)
    }

    @Test
    fun `should increment counter`() = runTest {
        var i = 0
        launch {
            while(true) {
                delay(1000)
                i++
            }
        }
        delay(1001)
        assertEquals(1, i)
        delay(1000)
        assertEquals(2, i)
    }

    @Test
    fun `should increment counter v2`() = runTest {
        var i = 0
        backgroundScope.launch {
            while(true) {
                delay(1000)
                i++
            }
        }
        delay(1001)
        assertEquals(1, i)
        delay(1000)
        assertEquals(2, i)
    }

    @Test
    fun `should map async and keep elements order`() = runTest {
        val transforms = listOf(
            suspend { delay(3000); "A"},
            suspend { delay(2000); "B"},
            suspend { delay(4000); "C"},
            suspend { delay(1000); "D" }
        )

        val res = transforms.mapAsync { it() }
        assertEquals(listOf("A" , "B", "C", "D"), res)
        assertEquals(4000, currentTime)
    }

    suspend fun <T,R> Iterable<T>.mapAsync(
        transformation: suspend (T) -> R
    ): List<R> = coroutineScope {
        this@mapAsync.map { async { transformation(it) }}
            .awaitAll()
    }

    @Test
    fun `should support context propagation`() = runTest {
        var ctx: CoroutineContext? = null
        val name1 = CoroutineName("Name 1")
        withContext(name1) {
            listOf("A").mapAsync {
                ctx = currentCoroutineContext()
                it
            }
            assertEquals(name1, ctx?.get(CoroutineName))
        }
        val name2 = CoroutineName("Name 2")
        withContext(name2) {
            listOf(1,2,3).mapAsync {
                ctx = currentCoroutineContext()
                it
            }
            assertEquals(name2, ctx?.get(CoroutineName))
        }
    }

    @Test
    fun `should support cancellation`() = runTest {
        var job: Job? = null
        val parentJob = launch {
            listOf("A").mapAsync {
                job = currentCoroutineContext().job
                delay(Long.MAX_VALUE)
            }
        }
        delay(1000)
        parentJob.cancel()
        assertEquals(true, job?.isCancelled)
    }

    @Test
    fun standardTestDispatcher() {
        CoroutineScope(StandardTestDispatcher()).launch {
            print("A")
            delay(1)
            print("B")
        }

        CoroutineScope(StandardTestDispatcher()).launch {
            print("C")
            delay(1)
            print("D")
        }
    }

    @Test
    fun testName() = runTest(UnconfinedTestDispatcher()) {
         // ...
    }

//    @Test
//    fun `should change dispatcher`() = runBlocking {
//        // given
//        val csvReader = mockk<CsvReader>()
//        val startThreadName = "MyName"
//        var usedThreadName: String? = null
//        every {
//            csvReader.readCsvBlocking(
//                aFileName,
//                GameState::class.java
//            )
//        } coAnswers {
//            usedThreadName = Thread.currentThread().name
//            aGameState
//        }
//        val saveReader = SaveReader(csvReader)
//
//        // when
//        withContext(newSingleThreadContext((startThreadName))) {
//            saveReader.readSave(aFileName)
//        }
//
//        // then
//        assertNotNull(usedThreadName)
//        val expectedPrefix = "DefaultDispatcher-worker-"
//        assert(usedThreadName!!.startsWith(expectedPrefix))
//    }

    @Test
    fun `should show progress bar when sending data`() = runTest {
        // given
        val database = FakeDatabase()
        val vm = UserViewModel(database)

        // when
        launch {
            vm.sendUserData()
        }

        // then
        assertEquals(false, vm.progressBarVisible.value)

        // when
        advanceTimeBy(1000)

        // then
        assertEquals(false, vm.progressBarVisibility.value)

        // when
        runCurrent()

        // then
        assertEquals(true, vm.progressBarVisible.value)

        // when
        advanceUntilIdle()

        // then
        assertEquals(false, vm.progressBarVisibility.value)
    }

}
