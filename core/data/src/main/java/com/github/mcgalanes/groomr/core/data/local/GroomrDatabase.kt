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

    abstract val userStoryDao: UserStoryDao

    companion object {
        private const val DATABASE_NAME = "tricount_db"

        fun getInstance(context: Context): GroomrDatabase =
            Room.databaseBuilder(
                context = context,
                klass = GroomrDatabase::class.java,
                name = DATABASE_NAME,
            ).build()
    }
}
