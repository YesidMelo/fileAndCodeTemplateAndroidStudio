package ${PACKAGE_NAME}.logic.useCases.loadListenerExceptionsUseCase

import androidx.lifecycle.MutableLiveData
import ${PACKAGE_NAME}.logic.exception.LogicException

interface LoadListenerExceptionsUseCase {
    fun invoke() : MutableLiveData<LogicException?>?
}