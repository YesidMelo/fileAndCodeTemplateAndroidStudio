package ${PACKAGE_NAME}.viewmodels

import androidx.lifecycle.MutableLiveData
import ${PACKAGE_NAME}.MainDispatcherRule
import ${PACKAGE_NAME}.data.ApiCats
import ${PACKAGE_NAME}.models.Cat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ListCatsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val listCat = emptyList<Cat>()
    private val mutableLiveData = MutableLiveData<List<Cat>?>()
    private val listCatsViewModel = ListCatsViewModel(object : ApiCats {
        override fun getCatsLiveData(): MutableLiveData<List<Cat>?> = mutableLiveData

        override fun loadCats() {
            mutableLiveData.postValue(listCat)
        }

    })

    @Test
    fun loadListCats() = runTest {
        val collectJob = launch {
            listCatsViewModel.loadListCats()
            val value = listCatsViewModel.getCatsLivData().value
            assertEquals(listCat, value)
        }
        collectJob.cancel()
    }
}