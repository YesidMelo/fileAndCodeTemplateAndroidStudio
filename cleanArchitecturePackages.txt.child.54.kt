package ${PACKAGE_NAME}.ui.activities.main

import ${PACKAGE_NAME}.logic.componentsUI.BaseUI
import ${PACKAGE_NAME}.logic.componentsUI.mainComponent.MainComponentUI
import ${PACKAGE_NAME}.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel (@Inject @JvmField var mainComponentUI: MainComponentUI) : BaseViewModel(){
    
    override fun getBaseUI(): BaseUI = mainComponentUI
}