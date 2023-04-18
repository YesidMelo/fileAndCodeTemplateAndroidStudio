package ${PACKAGE_NAME}.ui.fragments.second

import ${PACKAGE_NAME}.logic.componentsUI.BaseUI
import ${PACKAGE_NAME}.logic.componentsUI.exampleComponent2.ExampleComponent2
import ${PACKAGE_NAME}.logic.exception.LogicException
import ${PACKAGE_NAME}.ui.base.BaseViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SecondViewModel(@JvmField @Inject var exampleComponent2: ExampleComponent2) :
    BaseViewModel() {
    override fun getBaseUI(): BaseUI = exampleComponent2

    fun showError() {
        GlobalScope.launch {
            try {
                exampleComponent2.loadError().collect()
            } catch (e: LogicException) {
                getBaseUI().getListenerExceptionUseCase().invoke()?.postValue(e)
            } catch (e: Exception) {
                getBaseUI().getListenerExceptionUseCase().invoke()?.postValue(LogicException())
            }
        }
    }
}