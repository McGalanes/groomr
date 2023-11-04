/*
 * Copyright 2022 The Android Open Source Project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

import com.android.build.gradle.TestExtension
import com.github.mcgalanes.groomr.modularization.configureAndroid
import com.github.mcgalanes.groomr.modularization.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.test")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
            }

            extensions.configure<TestExtension> {
                configureAndroid(this)
            }

            dependencies {
                add("implementation", libs.findLibrary("androidx.test.core").get())
                add("implementation", libs.findLibrary("androidx.compose.ui.test.junit4").get())
                add("implementation", libs.findLibrary("hilt.android").get())
                add("implementation", libs.findLibrary("hilt.android.testing").get())
                add("kapt", libs.findLibrary("hilt.compiler").get())
            }

            val kaptExtension = extensions.getByType<KaptExtension>()
            kaptExtension.apply {
                correctErrorTypes = true
            }
        }
    }
}
