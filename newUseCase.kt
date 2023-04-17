package ${PACKAGE_NAME}

import kotlinx.coroutines.flow.Flow

interface ${NAME} {
    fun invoke(): Flow<Boolean>
}