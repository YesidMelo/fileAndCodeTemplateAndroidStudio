package ${PACKAGE_NAME}.logic.useCases.exampleUseCase

import ${PACKAGE_NAME}.logic.models.ExampleModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ExampleUseCaseImpl : ExampleUseCase {
    override fun invoke(): Flow<ExampleModel> = flow {
        emit(ExampleModel(value = 100.0))
    }
}