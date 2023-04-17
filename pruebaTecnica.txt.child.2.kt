package ${PACKAGE_NAME}.data

import ${PACKAGE_NAME}.models.Cat
import retrofit2.http.GET
import retrofit2.http.Header

interface Apis {
    @GET("breeds")
    suspend fun getCats(@Header("x-apikey") apikey: String = ApiConstants.API_KEY) : List<Cat>
}