package ${PACKAGE_NAME}

import android.content.Context
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

//file name: Base${NameDao}Test
//${NameEntity}

@RunWith(AndroidJUnit4::class)
abstract class Base${NameDao}Test {

    private lateinit var context: Context
    private lateinit var database: ${NameDatabase}
    protected lateinit var ${NameDao}: ${NameDao}

    @Before
    fun setup() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context = context, ${NameDatabase}::class.java).build()
        ${NameDao} = database.get${NameDao}()
    }

    @After
    fun cleanUp() {
        database.close()
    }

}