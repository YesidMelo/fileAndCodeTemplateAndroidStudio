package ${PACKAGE_NAME}.di.ui.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import ${PACKAGE_NAME}.di.ui.customs.DaggerActivityCustom

abstract class BaseActivityDagger<T: ViewModel> : DaggerActivityCustom() {

    private var viewModel : T? = null

    abstract fun getViewModel() : T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = if(viewModel == null) getViewModel() else this.viewModel
    }
}