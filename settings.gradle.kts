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

import java.nio.file.FileVisitResult
import java.nio.file.FileVisitor
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes

rootProject.name = "Groomr"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

include(":app")

listOf(
    "core",
    "feature",
).forEach { settings.includeRecursively(it) }

/**
 * Look into [path] for existing Gradle project and [Settings.include] them.
 */
fun Settings.includeRecursively(path: String): Path = Files.walkFileTree(
    /* start = */ Path.of(path),
    /* visitor = */ GradleBuildFileVisitor { include(it.parent.joinToString(":")) },
)

/**
 * This [FileVisitor] looks for gradle build files named `build.gradle.kts` and skip uninteresting directories.
 */
internal class GradleBuildFileVisitor(
    private val action: (Path) -> Unit,
) : SimpleFileVisitor<Path>() {
    override fun preVisitDirectory(dir: Path, attrs: BasicFileAttributes) =
        when (dir.fileName.toString()) {
            "build", "build-cache", "src", ".git", ".gradle" -> FileVisitResult.SKIP_SUBTREE
            else -> FileVisitResult.CONTINUE
        }

    override fun visitFile(path: Path, attrs: BasicFileAttributes): FileVisitResult {
        if (path.endsWith("build.gradle.kts")) action(path)
        return FileVisitResult.CONTINUE
    }
}
