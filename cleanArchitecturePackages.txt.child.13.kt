package ${PACKAGE_NAME}.di

import ${PACKAGE_NAME}.application.CustomApplication
import ${PACKAGE_NAME}.di.logic.ComponentUIModule
import ${PACKAGE_NAME}.di.logic.DatasourceModule
import ${PACKAGE_NAME}.di.logic.UseCasesModule
import ${PACKAGE_NAME}.di.sources.CacheModule
import ${PACKAGE_NAME}.di.sources.DBModule
import ${PACKAGE_NAME}.di.ui.builders.activities.ActivityBuilder
import ${PACKAGE_NAME}.di.ui.builders.activities.ActivityViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        //region sources
        CacheModule::class,
        DBModule::class,
        //endregion

        //region logic
        DatasourceModule::class,
        UseCasesModule::class,
        ComponentUIModule::class,
        //endregion

        //region ui
        AndroidInjectionModule::class,
        
        //region activities
        ActivityViewModelModule::class,
        ActivityBuilder::class
        //endregion
        //endregion
    ]
)
interface ApplicationComponent : AndroidInjector<CustomApplication> {

    interface Builder : AndroidInjector.Factory<CustomApplication>

}