package ${PACKAGE_NAME}.di.logic

import ${PACKAGE_NAME}.logic.datasources.exampleDatasource.ExampleDatasource
import ${PACKAGE_NAME}.logic.datasources.exampleDatasource.ExampleDatasourceImpl
import dagger.Module
import dagger.Provides

@Module
class DatasourceModule {
    
    @Provides
    fun providesExampleDatasource(): ExampleDatasource = ExampleDatasourceImpl()

}