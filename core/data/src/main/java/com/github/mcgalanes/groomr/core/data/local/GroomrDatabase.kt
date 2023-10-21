package com.github.mcgalanes.groomr.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.mcgalanes.groomr.core.data.local.entity.CriteriaEntity
import com.github.mcgalanes.groomr.core.data.local.entity.GherkinLineEntity
import com.github.mcgalanes.groomr.core.data.local.entity.UserStoryEntity

@Database(
    entities = [
        UserStoryEntity::class,
        CriteriaEntity::class,
        GherkinLineEntity::class,
    ],
    version = 1,
)
abstract class GroomrDatabase : RoomDatabase() {

    abstract val dao: GroomrDao

    companion object {
        private const val DATABASE_NAME = "tricount_db"
        @Volatile private var INSTANCE: GroomrDatabase? = null

        fun getInstance(context: Context): GroomrDatabase =
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = GroomrDatabase::class.java,
                    name = DATABASE_NAME,
                ).build().also { INSTANCE = it }
            }
    }
}