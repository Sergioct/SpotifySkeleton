package com.sergiocrespotoubes.convention

import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("*** AndroidComposeConventionPlugin invoked ***")
    }
}