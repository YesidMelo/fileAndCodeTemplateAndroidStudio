package ${PACKAGE_NAME}.ui.fragments.first

import ${PACKAGE_NAME}.logic.componentsUI.BaseUI
import ${PACKAGE_NAME}.logic.componentsUI.exampleComponent1.ExampleComponent1
import ${PACKAGE_NAME}.ui.base.BaseViewModel
import javax.inject.Inject

class FirstViewModel (@JvmField @Inject var exampleComponent1: ExampleComponent1) : BaseViewModel() {

    override fun getBaseUI(): BaseUI = exampleComponent1
}