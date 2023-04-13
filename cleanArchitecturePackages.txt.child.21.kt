package ${PACKAGE_NAME}.di.sources

import ${PACKAGE_NAME}.application.CustomApplication
import ${PACKAGE_NAME}.sources.room.DBApp
import dagger.Module
import dagger.Provides

@Module
class BaseDatosModule {

    @Provides
    fun providesBaseDatosLocal(): DBApp = DBApp.getInstance(context = CustomApplication.getInstance()!!.applicationContext)

}