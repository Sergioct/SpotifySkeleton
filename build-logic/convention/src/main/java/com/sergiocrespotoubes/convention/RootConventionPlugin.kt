package com.sergiocrespotoubes.convention

import com.sergiocrespotoubes.convention.settings.configureSpotless
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.FileInputStream
import java.util.Properties

class RootConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) =
        with(target) {
            configureSpotless()
        }
}
// configureSpotless configuration
// configureGradleDoctor
// configureDetekt
// configureDependenciesTools
// owasp dependencies-tools
// autonomousapps dependency analysis

//val prop =
//    Properties().apply {
//        load(FileInputStream(rootProject.file("gradle.properties")))
        //    }
//
//dependencyCheck {
//    nvd {
//        apiKey = prop.getProperty("nvdApiKey")
        //    }
        //}

