package ${PACKAGE_NAME}.ui.base

import androidx.lifecycle.ViewModel
import ${PACKAGE_NAME}.logic.componentsUI.BaseUI

abstract class BaseViewModel : ViewModel() {
    abstract fun getBaseUI() : BaseUI
}