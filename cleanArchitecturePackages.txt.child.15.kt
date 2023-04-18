package ${PACKAGE_NAME}.logic.componentsUI.exampleComponent2

import ${PACKAGE_NAME}.logic.useCases.exceptionUseCase.ExceptionUseCase
import ${PACKAGE_NAME}.logic.useCases.loadListenerExceptionsUseCase.LoadListenerExceptionsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExampleComponent2Impl constructor(
    @JvmField @Inject var loadListenerExceptionsUseCase: LoadListenerExceptionsUseCase,
    @JvmField @Inject var exceptionsUseCase: ExceptionUseCase
) : ExampleComponent2 {
    
    override fun loadError(): Flow<Boolean> = exceptionsUseCase.invoke()

    override fun getListenerExceptionUseCase(): LoadListenerExceptionsUseCase =
        loadListenerExceptionsUseCase

}