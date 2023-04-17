package ${PACKAGE_NAME}.viewmodels

import androidx.lifecycle.ViewModel
import ${PACKAGE_NAME}.data.ApiCats

class ListCatsViewModel: ViewModel() {
    private val apiCats = ApiCats()
    fun getCatsLivData() = apiCats.getCatsLiveData()

    fun loadListCats() = apiCats.loadCats()
}