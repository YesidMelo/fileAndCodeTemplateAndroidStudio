package ${PACKAGE_NAME}.logic.componentsUI

import ${PACKAGE_NAME}.logic.useCases.loadListenerExceptionsUseCase.LoadListenerExceptionsUseCase

interface BaseUI {
    fun getListenerExceptionUseCase() : LoadListenerExceptionsUseCase 
}