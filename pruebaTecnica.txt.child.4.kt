@file:OptIn(DelicateCoroutinesApi::class)

package ${PACKAGE_NAME}.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import ${PACKAGE_NAME}.models.Cat
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiCats {
    fun getCatsLiveData() : MutableLiveData<List<Cat>?>
    fun loadCats()
}

class ApiCatsImpl: ApiCats {
    private val liveDataCats = MutableLiveData<List<Cat>?>()

    private val retrofit = Retrofit.Builder()
        .baseUrl(ApiConstants.API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apis = retrofit.create(Apis::class.java)

    override fun getCatsLiveData() = liveDataCats

    override fun loadCats() {
        GlobalScope.launch {
            try {
                val list = apis.getCats()
                liveDataCats.postValue(list)
            } catch (e: Exception) {
                Log.e("Error", "Consumo", e)
            }
        }
    }

}