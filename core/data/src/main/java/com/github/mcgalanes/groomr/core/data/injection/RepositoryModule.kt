package com.github.mcgalanes.groomr.core.data.injection

import com.github.mcgalanes.groomr.core.data.DefaultUserStoryRepository
import com.github.mcgalanes.groomr.core.domain.repository.UserStoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsUserStoryRepository(impl: DefaultUserStoryRepository): UserStoryRepository
}
