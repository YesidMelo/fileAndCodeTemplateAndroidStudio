package ${PACKAGE_NAME}.di.ui.base

import android.content.Context
import androidx.lifecycle.ViewModel
import ${PACKAGE_NAME}.di.ui.customs.DaggerFragmentCustom

abstract class BaseFragmentDagger<T: ViewModel> : DaggerFragmentCustom() {

    //region variables
    private var viewModel: T? = null
    //endregion

    abstract fun traerViewModel() : T

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = traerViewModel()
    }
}