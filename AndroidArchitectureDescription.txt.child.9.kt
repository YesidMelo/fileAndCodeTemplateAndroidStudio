package ${PACKAGE_NAME}.ui.views.loginView

//file name: ui/loginView/LoginViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ${PACKAGE_NAME}.ui.constants.LoadingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class LoginViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState: StateFlow<LoginUIState> = _uiState.asStateFlow()

    data class LoginUIState(val loadingState: LoadingState = LoadingState.START)

    fun loadExample() {
        viewModelScope.launch {
            _uiState.emit(LoginUIState(loadingState = LoadingState.LOADING))
            delay(3_000)
            _uiState.emit(LoginUIState(loadingState = LoadingState.LOADED))
        }
    }

}