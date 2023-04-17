package ${PACKAGE_NAME}.di.ui.builders.fragments

import ${PACKAGE_NAME}.logic.componentsUI.exampleComponent1.ExampleComponent1
import ${PACKAGE_NAME}.logic.componentsUI.exampleComponent2.ExampleComponent2
import ${PACKAGE_NAME}.ui.fragments.first.FirstViewModel
import ${PACKAGE_NAME}.ui.fragments.second.SecondViewModel
import dagger.Module
import dagger.Provides

@Module
class FragmentViewModelModule {

    @Provides
    fun providesFirstViewModel(exampleComponent1: ExampleComponent1) : FirstViewModel = FirstViewModel(exampleComponent1 = exampleComponent1)

    @Provides
    fun providesSecondViewModel(exampleComponent2: ExampleComponent2) : SecondViewModel = SecondViewModel(exampleComponent2 = exampleComponent2)
}