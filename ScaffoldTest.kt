package ${PACKAGE_NAME}

import android.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule

//first test: ${NameFunction}

@OptIn(ExperimentalCoroutinesApi::class)
abstract class Base${NameClassTest}Test {

    @get:Rule
    var  rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCorutineRule = MainCoroutineRule()

    @get:Rule
    val mockkRule = MockKRule(this)
    /* example mock with Mockk
    @MockK
    lateinit var mockInsectModel : InsectModel
    */
    protected lateinit var ${NameClassTest}: ${NameClassTest}

    @Before
    fun setUp() {
        ${NameClassTest} =  ${NameClassTest}Impl()
    }
}