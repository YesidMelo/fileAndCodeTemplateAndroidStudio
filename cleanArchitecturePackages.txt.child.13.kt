package ${PACKAGE_NAME}.logic.componentsUI.exampleComponent1

import ${PACKAGE_NAME}.logic.useCases.loadListenerExceptionsUseCase.LoadListenerExceptionsUseCase
import javax.inject.Inject

class ExampleComponent1Impl constructor(
    @JvmField @Inject var loadListenerExceptionsUseCase: LoadListenerExceptionsUseCase
): ExampleComponent1 {

    override fun getListenerExceptionUseCase(): LoadListenerExceptionsUseCase = loadListenerExceptionsUseCase
}