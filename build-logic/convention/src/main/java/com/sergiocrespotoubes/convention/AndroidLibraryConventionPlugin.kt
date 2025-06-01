package com.sergiocrespotoubes.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.sergiocrespotoubes.convention.settings.configureAndroid
import com.sergiocrespotoubes.convention.settings.configureFlavors
import com.sergiocrespotoubes.convention.settings.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("*** AndroidLibraryConventionPlugin invoked ***")
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<LibraryExtension> {
                configureAndroid(this)
                configureKotlin()
                configureFlavors(this)
            }
        }
    }
}
