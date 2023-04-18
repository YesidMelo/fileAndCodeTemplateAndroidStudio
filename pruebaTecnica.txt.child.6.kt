package ${PACKAGE_NAME}.viewmodels

import androidx.lifecycle.ViewModel
import ${PACKAGE_NAME}.data.ApiCats
import ${PACKAGE_NAME}.data.ApiCatsImpl

class ListCatsViewModel (val apiCats: ApiCats = ApiCatsImpl()): ViewModel() {
    
    fun getCatsLivData() = apiCats.getCatsLiveData()

    fun loadListCats() = apiCats.loadCats()
}