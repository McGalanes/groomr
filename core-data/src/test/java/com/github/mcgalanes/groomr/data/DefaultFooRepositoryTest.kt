/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.mcgalanes.groomr.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import com.github.mcgalanes.groomr.core.data.DefaultFooRepository
import com.github.mcgalanes.groomr.core.database.Foo
import com.github.mcgalanes.groomr.core.database.FooDao

/**
 * Unit tests for [DefaultFooRepository].
 */
@OptIn(ExperimentalCoroutinesApi::class) // TODO: Remove when stable
class DefaultFooRepositoryTest {

    @Test
    fun foos_newItemSaved_itemIsReturned() = runTest {
        val repository = DefaultFooRepository(FakeFooDao())

        repository.add("Repository")

        assertEquals(repository.foos.first().size, 1)
    }

}

private class FakeFooDao : FooDao {

    private val data = mutableListOf<Foo>()

    override fun getFoos(): Flow<List<Foo>> = flow {
        emit(data)
    }

    override suspend fun insertFoo(item: Foo) {
        data.add(0, item)
    }
}
