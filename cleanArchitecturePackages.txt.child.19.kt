package ${PACKAGE_NAME}.logic.exception

enum class OrigenError { Sistema, Usuario }

open class LogicException constructor(
    var mensaje : String = "Surgio un problema inesperado intentelo mas tarde",
    val origenError: OrigenError = OrigenError.Sistema
) : Exception(mensaje)