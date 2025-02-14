package com.sergiocrespotoubes.convention

import com.android.build.api.dsl.ApplicationExtension
import com.sergiocrespotoubes.convention.settings.configureAndroid
import com.sergiocrespotoubes.convention.settings.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("*** AndroidApplicationConventionPlugin invoked ***")
        with(target) {
            with(pluginManager) {
                apply("com.android.application") // Include android application plugin
                apply("org.jetbrains.kotlin.android") // Ensure project build.gradle declared this plugin
            }
            extensions.configure<ApplicationExtension> {
                configureAndroid(this)
                configureKotlin()
            }
        }
    }
}
