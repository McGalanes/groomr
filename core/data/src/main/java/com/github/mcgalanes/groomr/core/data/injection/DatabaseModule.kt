package com.github.mcgalanes.groomr.core.data.injection

import android.content.Context
import com.github.mcgalanes.groomr.core.data.local.GroomrDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): GroomrDatabase = GroomrDatabase.getInstance(context)
}
