package com.sergiocrespotoubes.convention

import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

fun Project.configureSpotless() {

    with(pluginManager) {
        apply("com.diffplug.spotless")
    }

    spotless {
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
    //spotless {
    //    kotlin {
    //        target("src/**/*.kt")
    //        targetExclude("**/build/**")
//
    //        ktlint()
    //        trimTrailingWhitespace()
    //        indentWithSpaces()
    //        endWithNewline()
    //    }
    //}
}

private fun Project.spotless(action: SpotlessExtension.() -> Unit) =
    extensions.configure<SpotlessExtension>(action)
