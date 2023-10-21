package com.github.mcgalanes.groomr.core.data.injection

import com.github.mcgalanes.groomr.core.data.local.GroomrDatabase
import com.github.mcgalanes.groomr.core.data.local.UserStoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun providesUserStoryDao(
        database: GroomrDatabase,
    ): UserStoryDao = database.dao
}
