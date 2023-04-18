package ${PACKAGE_NAME}.logic.datasources.exampleDatasource

import ${PACKAGE_NAME}.logic.models.ExampleModel
import kotlinx.coroutines.flow.Flow

interface ExampleDatasource {
    fun loadExample(): Flow<ExampleModel>
}