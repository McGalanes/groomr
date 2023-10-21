package com.github.mcgalanes.groomr.core.data.injection

import com.github.mcgalanes.groomr.core.data.local.GroomrDao
import com.github.mcgalanes.groomr.core.data.local.GroomrDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun providesGroomrDao(
        database: GroomrDatabase,
    ): GroomrDao = database.dao
}
