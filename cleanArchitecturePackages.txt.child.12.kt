package ${PACKAGE_NAME}.di

import ${PACKAGE_NAME}.application.CustomApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AplicationModule {

    @Singleton
    @Provides
    fun providesContext(aplication: CustomApplication) = aplication
}