package ${PACKAGE_NAME}.logic.useCases.loadListenerExceptionsUseCase

import androidx.lifecycle.MutableLiveData
import ${PACKAGE_NAME}.logic.exception.LogicException
import ${PACKAGE_NAME}.sources.cache.Cache
import javax.inject.Inject

class LoadListenerExceptionsUseCaseImpl constructor(
    @JvmField @Inject var cache: Cache
): LoadListenerExceptionsUseCase {

    override fun invoke(): MutableLiveData<LogicException?> {
        if(cache.listenerExceptionsLiveData == null)
        {
            cache.listenerExceptionsLiveData = MutableLiveData<LogicException?>()
        }
        return cache.listenerExceptionsLiveData!! as MutableLiveData<LogicException?>
    }
}