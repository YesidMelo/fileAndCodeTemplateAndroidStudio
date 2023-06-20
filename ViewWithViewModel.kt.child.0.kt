package ${PACKAGE_NAME}

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hefesto.jacs.ui.constants.LoadingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class ${Name_view}ViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(${Name_view}UIState())
    val uiState: StateFlow<${Name_view}UIState> = _uiState.asStateFlow()
    data class ${Name_view}UIState (val loadingState: Boolean = false)

    fun loadExample() {
        viewModelScope.launch {
            _uiState.emit(${Name_view}UIState(loadingState = true))
            delay(3_000)
            _uiState.emit(${Name_view}UIState(loadingState = false))
        }
    }

}