package ${PACKAGE_NAME}.logic.componentsUI.exampleComponent2

import ${PACKAGE_NAME}.logic.useCases.loadListenerExceptionsUseCase.LoadListenerExceptionsUseCase
import javax.inject.Inject

class ExampleComponent2Impl constructor(
    @JvmField @Inject var loadListenerExceptionsUseCase: LoadListenerExceptionsUseCase
) : ExampleComponent2 {

    override fun getListenerExceptionUseCase(): LoadListenerExceptionsUseCase = loadListenerExceptionsUseCase

}