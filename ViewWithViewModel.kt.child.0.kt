package ${PACKAGE_NAME}.viewModel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

//file name: viewModel/${Name_view}ViewModelImpl

@HiltViewModel
class ${Name_view}ViewModelImpl @Inject constructor() : ${Name_view}ViewModel() {

    override fun load${Name_view}() {
        viewModelScope.launch {
            updateState(loadingState = true)
            delay(3_000)
            updateState(
                loadingState = false,
                throwable = null,
                states${Name_view}UI = States${Name_view}UI.SHOW_ERROR
            )
        }
    }

    override fun closeException() {
        viewModelScope.launch {
            updateState(throwable = null)
        }
    }

    override fun updateState(
        loadingState: Boolean,
        throwable: Throwable?,
        states${Name_view}UI: States${Name_view}UI
    ) {
        viewModelScope.launch {
            _uiState.emit(
                ${Name_view}UIState(
                    loadingState = loadingState,
                    throwable = throwable,
                    states${Name_view}UI = states${Name_view}UI
                )
            )
        }
    }
}