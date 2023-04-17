package ${PACKAGE_NAME}.ui.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.annotation.StringRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import ${PACKAGE_NAME}.di.ui.base.BaseFragmentDagger
import ${PACKAGE_NAME}.ui.dialogs.InformativeDialog
import org.jetbrains.annotations.NotNull

abstract class BaseFragment< T : BaseViewModel> : BaseFragmentDagger<T>(), LifecycleOwner {

    private var lifecycleRegistry: LifecycleRegistry? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            lifecycle
            lifecycleRegistry?.markState(Lifecycle.State.INITIALIZED)
        }catch (e: Exception) {
            Log.e("Error", "surgio un problema")
        }
    }

    override fun onDetach() {
        super.onDetach()
        try {
            lifecycle
            lifecycleRegistry?.markState(Lifecycle.State.DESTROYED)
        }catch (e: Exception) {
            Log.e("Error", "surgio un problema")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuracionCicloVida()
    }

    override fun onStart() {
        super.onStart()
        lifecycleRegistry?.markState(Lifecycle.State.STARTED)
    }

    override fun getLifecycle(): Lifecycle {
        if(lifecycleRegistry == null) {
            lifecycleRegistry = LifecycleRegistry(this)
        }
        return lifecycleRegistry!!
    }

    //region interaccion activity

    fun safeFunction(funcion : (()->Unit), acceptFail: (()->Unit)? = null)
            = (activity as BaseActivity<*>).safeFunction(funcion = funcion, acceptFail = acceptFail)

    fun showCustomDialog(
        tipoDialogo: InformativeDialog.TipoDialogo,
        @StringRes @NotNull titulo: Int,
        @StringRes @NotNull mensaje: Int,
        accionAceptar: (()->Unit)? = null,
        accionCancelar: (()->Unit)? = null,
    ) = (activity as BaseActivity<*>).showCustomDialog(
        accionAceptar = accionAceptar,
        accionCancelar = accionCancelar,
        tipoDialogo = tipoDialogo,
        titulo = titulo,
        mensaje = mensaje,
    )

    fun mostrarLoading() = (activity as BaseActivity<*>).mostrarProgress()
    fun ocultarLoading() = (activity as BaseActivity<*>).ocultarProgress()

    fun conEscuchadorAccionBotonAtras(escuchadorAccionBotonAtras : (()->Unit)) {
        (activity as BaseActivity<*>).escuchadorAccionBotonAtras = escuchadorAccionBotonAtras
    }

    //endregion

    //region configuracion ciclo vida
    private fun configuracionCicloVida(){
        try {
            lifecycle
            lifecycleRegistry?.markState(Lifecycle.State.CREATED)
        } catch (e: Exception) {
            Log.e("Error", "ha surgido un error",e)
        }
    }
    //endregion
}