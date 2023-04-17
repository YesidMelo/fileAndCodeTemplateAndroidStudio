package ${PACKAGE_NAME}.ui.utils.extentions

import ${PACKAGE_NAME}.R
import ${PACKAGE_NAME}.logic.exception.LogicException

fun <T : LogicException> T.traerMensajeStringRes() : Int {
    return R.string.surgio_problema_inesperado
}

fun <T : LogicException>  T.traerTituloStringRes() : Int {
    return R.string.problema_inesperado
}