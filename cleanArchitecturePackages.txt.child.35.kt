package ${PACKAGE_NAME}.ui.base

import android.os.Bundle
import android.util.Log
import androidx.annotation.StringRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import ${PACKAGE_NAME}.di.ui.base.BaseActivityDagger
import ${PACKAGE_NAME}.logic.exception.LogicException
import ${PACKAGE_NAME}.logic.exception.OrigenError
import ${PACKAGE_NAME}.ui.dialogs.InformativeDialog
import ${PACKAGE_NAME}.ui.dialogs.LoadingDialog
import ${PACKAGE_NAME}.ui.utils.extentions.traerMensajeStringRes
import ${PACKAGE_NAME}.ui.utils.extentions.traerTituloStringRes
import kotlinx.coroutines.flow.collect
import org.jetbrains.annotations.NotNull
import java.util.*
import javax.inject.Inject


/**
 * documentacion lifecycle aqui : https://developer.android.com/topic/libraries/architecture/lifecycle
 */
abstract class BaseActivity<T: BaseViewModel> : BaseActivityDagger<T>(), LifecycleOwner {

    //region variables
    //region inyecciones
    //endregion
    private var lifecycleRegistry: LifecycleRegistry? = null

    var escuchadorAccionBotonAtras : (()->Unit)? = null
    private var escuchadorAccionAceptarFallo : (()->Unit)? = null
    //endregion

    //region ciclo de vida normal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuracionCicloVida(savedInstanceState = savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        lifecycleRegistry?.markState(Lifecycle.State.STARTED)
        configurarEscuchadorExcepciones()
    }

    //endregion


    //region ciclo vida seguros
    open fun safeOnCreate(savedInstanceState: Bundle?) {}

    override fun getLifecycle(): Lifecycle {
        if(lifecycleRegistry == null) {
            lifecycleRegistry = LifecycleRegistry(this)
        }
        return lifecycleRegistry!!
    }


    fun safeFunction(funcion : (()->Unit), acceptFail: (()->Unit)? = null) {
        try {
            escuchadorAccionAceptarFallo = acceptFail
            funcion.invoke()
        } catch (e: LogicException) {
            showCustomDialog(
                tipoDialogo = if (e.origenError == OrigenError.Usuario) InformativeDialog.TipoDialogo.ERROR_USUARIO else InformativeDialog.TipoDialogo.ERROR_SISTEMA,
                titulo = e.traerTituloStringRes(),
                mensaje = e.traerMensajeStringRes(),
                accionAceptar = acceptFail
            )

        }
    }

    //region dialogs

    fun showCustomDialog(
        tipoDialogo: InformativeDialog.TipoDialogo,
        @StringRes @NotNull titulo: Int,
        @StringRes @NotNull mensaje: Int,
        accionAceptar: (()->Unit)? = null,
        accionCancelar: (()->Unit)? = null,
    ) {
        InformativeDialog.showCustomDialog(
            accionAceptar = accionAceptar,
            accionCancelar = accionCancelar,
            activity = this,
            mensaje = mensaje,
            tipoDialogo = tipoDialogo,
            titulo = titulo,
        )
    }

    fun mostrarProgress() { runOnUiThread { LoadingDialog.mostrarProgress(activity = this) } }

    fun ocultarProgress() { runOnUiThread { LoadingDialog.ocultarrProgress() }}

    //endregion

    //endregion

    //region metodos privados
    //region configuracion ciclo vida
    private fun configuracionCicloVida(savedInstanceState: Bundle?){
        try {
            lifecycle
            lifecycleRegistry?.markState(Lifecycle.State.CREATED)
            safeOnCreate(savedInstanceState = savedInstanceState)
        } catch (e: Exception) {
            Log.e("Error", "ha surgido un error",e)
        }
    }
    //endregion

    private fun configurarEscuchadorExcepciones() {
        if(getViewModel().getBaseUI().getListenerExceptionUseCase().invoke() == null) return
        runOnUiThread {
            val casoUso = getViewModel().getBaseUI().getListenerExceptionUseCase().invoke()
                casoUso?.observe(this) {
                    if (it == null) return@observe
                    showCustomDialog(
                        tipoDialogo = if (it.origenError == OrigenError.Usuario) InformativeDialog.TipoDialogo.ERROR_USUARIO else InformativeDialog.TipoDialogo.ERROR_SISTEMA,
                        titulo = it.traerTituloStringRes(),
                        mensaje = it.traerMensajeStringRes(),
                        accionAceptar = {
                            escuchadorAccionAceptarFallo?.invoke()
                            escuchadorAccionAceptarFallo = null
                            ocultarProgress()
                        }
                    )
                }
        }
    }
    //endregion
}