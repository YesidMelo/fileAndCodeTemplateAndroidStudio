package ${PACKAGE_NAME}

import io.mockk.every
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

//file name ${NameFunction}Test

@OptIn(ExperimentalCoroutinesApi::class)
class ${NameFunction}Test : Base${NameClassTest}Test() {

    @Test
    fun success${NameFunction}Test() = runTest {
    /*
        //Given
        val longArrayTest = longArrayOf(1,2,3,4,5)
        every { mockInsectLocalDatasource.insertInsect(insectModel = any()) } returns flow {
            emit(longArrayTest)
        }

        //when
        addInsectUseCase
            .invoke(insectModel = mockInsectModel)
            .collect {
                Assert.assertEquals(longArrayTest.first(), it)
            }

        //then
        verify (exactly = 1) { mockInsectLocalDatasource.insertInsect(insectModel = any()) }
        */
    }
}