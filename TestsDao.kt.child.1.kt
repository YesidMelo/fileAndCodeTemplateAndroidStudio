package com.pragma.entomologo.sources.database.insectDao

import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

//file name: ${MethodName}${NameEntity}Test

@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalCoroutinesApi::class)
class ${MethodName}${NameEntity}Test : Base${NameDao}Test() {

    @Test
    fun ${MethodName}${NameEntity}IntoDB() = runTest {

        //Given
        val urlPhoto1 = "urlPhoto1"
        val entity = InsectEntity(
            specieName = "SpaceName",
            urlPhoto = "UrlPhoto",
            moreInformation = "MoreInformation"
        )
        //When
        insectDao.insertElement(entity)
        insectDao.updateElement(entity.apply {
            id = 1
            urlPhoto = urlPhoto1
        })

        val insectFlow = insectDao.getAllInsects()
        val list = mutableListOf<InsectEntity>()

        val job = launch {

            insectFlow.collect{
                list.addAll(it)
                //Then
                Assert.assertEquals(1, list.size)
                Assert.assertEquals(urlPhoto1, it[0].urlPhoto)
            }
        }

        //finish job
        advanceUntilIdle()
        job.cancel()

    }
}