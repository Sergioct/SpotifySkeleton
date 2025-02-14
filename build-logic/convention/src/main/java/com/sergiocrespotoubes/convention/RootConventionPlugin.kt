package com.sergiocrespotoubes.convention

import com.sergiocrespotoubes.convention.settings.configureSpotless
import org.gradle.api.Plugin
import org.gradle.api.Project

class RootConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        configureSpotless()
    }
}
    // configureSpotless configuration
    // configureGradleDoctor
    // configureDetekt
    // configureDependenciesTools
        // owasp dependencies-tools
        // autonomousapps dependency analysis
