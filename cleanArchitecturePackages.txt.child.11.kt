package ${PACKAGE_NAME}.logic.useCases.exampleUseCase

import ${PACKAGE_NAME}.logic.models.ExampleModel
import kotlinx.coroutines.flow.Flow

interface ExampleUseCase {
    fun invoke(): Flow<ExampleModel>
}