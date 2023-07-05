package ${PACKAGE_NAME}.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

//file name: viewModel/${Name_view}ViewModel

abstract class ${Name_view}ViewModel : ViewModel() {

    protected val _uiState = MutableStateFlow(${Name_view}UIState())
    val uiState: StateFlow<${Name_view}UIState> = _uiState.asStateFlow()
    
    enum class States${Name_view}UI {
        START,
        LOADING,
        NAVIGATE_TO_,
        SHOW_ERROR,
        ;
    }
    
    data class ${Name_view}UIState (
        val loadingState: Boolean = false,
        val throwable: Throwable? = null,
        val states${Name_view}UI: States${Name_view}UI = States${Name_view}UI.START
    )

    abstract fun load${Name_view}() 
    
    abstract fun closeException()
    
    abstract fun updateState(
        loadingState: Boolean = _uiState.value.loadingState,
        throwable: Throwable? = _uiState.value.throwable,
        states${Name_view}UI: States${Name_view}UI = _uiState.value.states${Name_view}UI
    ) 

}