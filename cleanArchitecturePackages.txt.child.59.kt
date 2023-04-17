package ${PACKAGE_NAME}.di.ui.builders.activities

import ${PACKAGE_NAME}.ui.activities.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilder {

    @ContributesAndroidInjector(modules = [ActivityViewModelModule::class])
    fun providesMainActivity(): MainActivity
}