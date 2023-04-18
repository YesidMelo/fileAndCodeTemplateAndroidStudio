package ${PACKAGE_NAME}.logic.utils.extentions

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

enum class TipoAdicion {
    DIAS_MES,
    MESES,
    ANIOS,
    SEMANAS,
    DIAS_ANIO,
}

enum class FormatoFecha (private val formato: String){
    ISO_8601("yyyy-MM-dd'T'HH:mm:ss"),
    DIA_MES_ANIO_GUIONES("dd-MM-yyyy"),
    ANIO_MES_DIA_GUIONES("yyyy-MM-dd"),
    ANIO_MES_GUIONES("yyyy-MM"),
    ANIO_CUATRO_DIGITOS("yyyy"),
    ;
    fun traerFormato() = formato
}


/**
 * funcion encargada de adicionar o quitar tiempo de una fecha
*/
fun Date.adicionaQuitaTiempo( adicionar:TipoAdicion,  periodo:Int ):Date{
    val calG = GregorianCalendar()
    calG.time= this
    when(adicionar){
        TipoAdicion.DIAS_MES->{
            calG.add(Calendar.DAY_OF_MONTH,periodo)
        }
        TipoAdicion.MESES->{
            calG.add(Calendar.MONTH,periodo)
        }
        TipoAdicion.ANIOS->{
            calG.add(Calendar.YEAR,periodo)
        }
        TipoAdicion.SEMANAS->{
            calG.add(Calendar.WEEK_OF_YEAR,periodo)
        }
        TipoAdicion.DIAS_ANIO->{
            calG.add(Calendar.DAY_OF_YEAR,periodo)
        }
    }
    return  calG.time
}

@SuppressLint("SimpleDateFormat")
fun Date.convertirAFormato(formatoFecha: FormatoFecha) : String {
    val simpleDateFormat = SimpleDateFormat(formatoFecha.traerFormato())
    return simpleDateFormat.format(this)
}

fun Date.reiniciarMes() : Date {
    val calG = GregorianCalendar()
    calG.time= this
    calG.set(Calendar.DAY_OF_MONTH, 1)
    return calG.time
}

fun Date.reiniciarAnio() : Date {
    val calG = GregorianCalendar()
    calG.time= this
    calG.set(Calendar.MONTH, 0)
    return calG.time
}

fun Date.esElMismoMes(fecha: Date) : Boolean {
    val calActual = GregorianCalendar()
    val calRevisar = GregorianCalendar()
    calActual.time= this
    calRevisar.time= fecha
    return calActual.get(Calendar.MONTH) == calRevisar.get(Calendar.MONTH)
}

fun Date.esElMismoAnio(fecha: Date) : Boolean {
    val calActual = GregorianCalendar()
    val calRevisar = GregorianCalendar()
    calActual.time= this
    calRevisar.time= fecha
    return calActual.get(Calendar.YEAR) == calRevisar.get(Calendar.YEAR)
}

fun Date.esLaMismaFecha(fecha: Date) : Boolean {
    val calActual = GregorianCalendar()
    val calRevisar = GregorianCalendar()
    calActual.time= this
    calRevisar.time= fecha
    return  calActual.get(Calendar.MONTH) == calRevisar.get(Calendar.MONTH) &&
            calActual.get(Calendar.DAY_OF_MONTH) == calRevisar.get(Calendar.DAY_OF_MONTH) &&
            calActual.get(Calendar.YEAR) == calRevisar.get(Calendar.YEAR)
}

fun Date.esElMismoMesYAnio(fecha: Date) : Boolean {
    val calActual = GregorianCalendar()
    val calRevisar = GregorianCalendar()
    calActual.time= this
    calRevisar.time= fecha
    return  calActual.get(Calendar.MONTH) == calRevisar.get(Calendar.MONTH) &&
            calActual.get(Calendar.YEAR) == calRevisar.get(Calendar.YEAR)
}

fun Date.traerDiaDelMes() : Int {
    val calActual = GregorianCalendar()
    calActual.time = this
    return calActual.get(Calendar.DAY_OF_MONTH)
}

fun Date.traerMes() : Int {
    val calActual = GregorianCalendar()
    calActual.time = this
    return calActual.get(Calendar.MONTH) + 1
}