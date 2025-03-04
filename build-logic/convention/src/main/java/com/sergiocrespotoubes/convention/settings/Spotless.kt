package com.sergiocrespotoubes.convention.settings

import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.spotless.LineEnding.PLATFORM_NATIVE
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

fun Project.configureSpotless() {
    with(pluginManager) {
        apply("com.diffplug.spotless")
    }

    spotless {
        lineEndings = PLATFORM_NATIVE

        // ratchetFrom("origin/develop")
        format("misc") {
            target("**/*.gradle", "**/*.md", "**/.gitignore")
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }
        kotlin {
            target("**/*.kt")
            ktlint()
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }
        kotlinGradle {
            target("**/*.kts")
            ktlint()
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }
        format("toml") {
            target("**/*.toml")
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }
    }
}

private fun Project.spotless(action: SpotlessExtension.() -> Unit) = extensions.configure<SpotlessExtension>(action)
