package ${PACKAGE_NAME}.di.logic

import ${PACKAGE_NAME}.logic.componentsUI.exampleComponent1.ExampleComponent1
import ${PACKAGE_NAME}.logic.componentsUI.exampleComponent2.ExampleComponent2
import ${PACKAGE_NAME}.logic.componentsUI.exampleComponent1.ExampleComponent1Impl
import ${PACKAGE_NAME}.logic.componentsUI.exampleComponent2.ExampleComponent2Impl
import ${PACKAGE_NAME}.logic.componentsUI.mainComponent.MainComponentUI
import ${PACKAGE_NAME}.logic.componentsUI.mainComponent.MainComponentUIImpl
import ${PACKAGE_NAME}.logic.useCases.loadListenerExceptionsUseCase.LoadListenerExceptionsUseCase
import dagger.Module
import dagger.Provides

@Module
class ComponentUIModule {

    @Provides
    fun providesExampleComponent1(loadListenerExceptionsUseCase: LoadListenerExceptionsUseCase)
            : ExampleComponent1 =
        ExampleComponent1Impl(loadListenerExceptionsUseCase = loadListenerExceptionsUseCase)

    @Provides
    fun providesExampleComponent2(loadListenerExceptionsUseCase: LoadListenerExceptionsUseCase)
            : ExampleComponent2 =
        ExampleComponent2Impl(loadListenerExceptionsUseCase = loadListenerExceptionsUseCase)

    @Provides
    fun providesMainComponentUI (loadListenerExceptionsUseCase: LoadListenerExceptionsUseCase): MainComponentUI
        = MainComponentUIImpl(loadListenerExceptionsUseCase = loadListenerExceptionsUseCase)
}