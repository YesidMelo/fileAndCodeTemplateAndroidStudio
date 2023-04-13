package ${PACKAGE_NAME}.sources

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    //region entities
    entities = [],
    //endregion

    //region views
    views = [],
    //endregion

    version = 1
)
abstract class DBApp : RoomDatabase() {

    companion object {
        private val NAME_DB = "${PACKAGE_NAME}"
        private var instance: DBApp? = null

        fun traerInstancia(context: Context) : DBApp {
            if(instance == null) {
                instance = Room
                    .databaseBuilder(context,DBApp::class.java, NAME_DB)
                    .build()
            }
            return instance!!
        }
    }
}