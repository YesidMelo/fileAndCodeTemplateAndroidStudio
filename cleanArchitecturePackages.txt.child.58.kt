package ${PACKAGE_NAME}.sources.room.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import ${PACKAGE_NAME}.sources.room.entities.BaseEntity

@Dao
interface BaseDao<T : BaseEntity> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertElement(element: T) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertElements(elements: List<T>)

    @Update
    fun updateElement(element: T)

    @Update
    fun updateElements(elements: List<T>)

    @Delete
    fun deleteElement(element: T)

    @Delete
    fun deleteListElements(elements: List<T>)

}