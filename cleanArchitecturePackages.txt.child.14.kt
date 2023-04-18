package ${PACKAGE_NAME}.logic.componentsUI.exampleComponent2

import ${PACKAGE_NAME}.logic.componentsUI.BaseUI
import kotlinx.coroutines.flow.Flow

interface ExampleComponent2 : BaseUI {
    fun loadError() : Flow<Boolean>
}