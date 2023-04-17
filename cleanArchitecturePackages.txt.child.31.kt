package ${PACKAGE_NAME}.di.logic

import ${PACKAGE_NAME}.logic.useCases.exampleUseCase.ExampleUseCase
import ${PACKAGE_NAME}.logic.useCases.exampleUseCase.ExampleUseCaseImpl
import ${PACKAGE_NAME}.logic.useCases.exceptionUseCase.ExceptionUseCase
import ${PACKAGE_NAME}.logic.useCases.exceptionUseCase.ExceptionUseCaseImpl
import ${PACKAGE_NAME}.logic.useCases.loadListenerExceptionsUseCase.LoadListenerExceptionsUseCase
import ${PACKAGE_NAME}.logic.useCases.loadListenerExceptionsUseCase.LoadListenerExceptionsUseCaseImpl
import ${PACKAGE_NAME}.sources.cache.Cache
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun providesExampleUseCase(): ExampleUseCase = ExampleUseCaseImpl()

    @Provides
    fun providesExceptionUseCase(): ExceptionUseCase = ExceptionUseCaseImpl()

    @Provides
    fun providesLoadListenerExceptionsUseCase(cache: Cache)
            : LoadListenerExceptionsUseCase = LoadListenerExceptionsUseCaseImpl(cache = cache)
}