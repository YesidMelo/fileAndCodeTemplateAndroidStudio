package ${PACKAGE_NAME}.sources.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import ${PACKAGE_NAME}.sources.room.entities.BaseEntity
import java.util.Date

@Entity
data class ExampleEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
): BaseEntity()