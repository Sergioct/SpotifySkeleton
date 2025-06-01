package com.sergiocrespotoubes.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.sergiocrespotoubes.convention.settings.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("*** AndroidComposeConventionPlugin invoked ***")
        with(target) {
            extensions.configure<LibraryExtension> {
                configureAndroidCompose(this)
            }
        }
    }
}
