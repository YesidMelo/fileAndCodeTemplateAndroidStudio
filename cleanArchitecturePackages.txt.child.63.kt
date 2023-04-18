package ${PACKAGE_NAME}.logic.useCases.exceptionUseCase

import ${PACKAGE_NAME}.logic.exception.LogicException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ExceptionUseCaseImpl : ExceptionUseCase {

    override fun invoke(): Flow<Boolean> = flow {
        throw LogicException()
    }

}