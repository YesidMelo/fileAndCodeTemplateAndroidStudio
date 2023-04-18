package ${PACKAGE_NAME}.logic.useCases.exceptionUseCase

import kotlinx.coroutines.flow.Flow

interface ExceptionUseCase {
    fun invoke(): Flow<Boolean>
}