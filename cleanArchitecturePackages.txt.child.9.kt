package ${PACKAGE_NAME}.logic.componentsUI.mainComponent

import ${PACKAGE_NAME}.logic.useCases.loadListenerExceptionsUseCase.LoadListenerExceptionsUseCase
import javax.inject.Inject

class MainComponentUIImpl (
    @JvmField @Inject var loadListenerExceptionsUseCase : LoadListenerExceptionsUseCase
        ) : MainComponentUI {

    override fun getListenerExceptionUseCase(): LoadListenerExceptionsUseCase = loadListenerExceptionsUseCase
}