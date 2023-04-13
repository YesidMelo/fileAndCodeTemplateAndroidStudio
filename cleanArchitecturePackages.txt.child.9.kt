package ${PACKAGE_NAME}.logic.datasources.exampleDatasource

import ${PACKAGE_NAME}.logic.models.ExampleModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ExampleDatasourceImpl : ExampleDatasource {
    override fun loadExample(): Flow<ExampleModel> = flow {
        emit(ExampleModel(value = 100.0))
    }
}