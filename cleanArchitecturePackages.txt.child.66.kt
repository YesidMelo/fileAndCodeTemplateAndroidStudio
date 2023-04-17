package ${PACKAGE_NAME}.di.ui.builders.fragments

import ${PACKAGE_NAME}.ui.fragments.first.FirstFragment
import ${PACKAGE_NAME}.ui.fragments.second.SecondFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuilder {
    
    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    fun providesFirstFragment(): FirstFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    fun providesSecondFragment(): SecondFragment
}
