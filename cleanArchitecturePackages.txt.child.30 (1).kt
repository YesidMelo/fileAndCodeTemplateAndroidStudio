package ${PACKAGE_NAME}.ui.dialogs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import ${PACKAGE_NAME}.databinding.DialogfragmentLoadingBinding
import ${PACKAGE_NAME}.ui.base.BaseActivity
import dagger.android.support.DaggerDialogFragment

class LoadingDialog : DaggerDialogFragment() {

    private lateinit var binding: DialogfragmentLoadingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        isCancelable = false
        binding = DialogfragmentLoadingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
    }


    companion object {

        private var instance : LoadingDialog? = null

        fun mostrarProgress(activity: BaseActivity<*>) {
            if(instance != null) return
            instance = LoadingDialog()
            instance?.show(activity.supportFragmentManager, "loadingdialog")
        }

        fun ocultarrProgress() {
            instance?.dismiss()
            instance = null
        }
    }

}