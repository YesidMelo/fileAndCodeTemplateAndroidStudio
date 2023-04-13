package ${PACKAGE_NAME}.sources.room.converters

import android.annotation.SuppressLint
import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
class CustomConverter {

    @TypeConverter
    fun toString(fecha: Date) : String {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return simpleDateFormat.format(fecha)
    }

    @TypeConverter
    fun toDate(fechaString: String) : Date? {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return simpleDateFormat.parse(fechaString)
    }
}