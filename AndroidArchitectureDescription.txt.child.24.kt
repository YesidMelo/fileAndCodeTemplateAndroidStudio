package ${PACKAGE_NAME}.ui.views.splashView

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
open class SplashViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(SplashUIState())
    val uiState: StateFlow<SplashUIState> = _uiState.asStateFlow()
    data class SplashUIState (val loadingState: LoadingState = LoadingState.START)

    fun loadSplash() {
        viewModelScope.launch {
            _uiState.emit(SplashUIState(loadingState = LoadingState.LOADING))
            delay(3_000)
            _uiState.emit(SplashUIState(loadingState = LoadingState.LOADED))
        }
    }

}