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

plugins {
    alias(libs.plugins.groomr.android.library)
    alias(libs.plugins.groomr.android.room)
    alias(libs.plugins.groomr.android.hilt)
    `java-test-fixtures`
}

android {
    namespace = "com.github.mcgalanes.groomr.core.data"
    testFixtures.enable = true
}

dependencies {
    implementation(projects.groomr.core.domain)

    implementation(libs.kotlinx.coroutines.android)

    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)

    testImplementation(testFixtures(projects.groomr.core.domain))
}
