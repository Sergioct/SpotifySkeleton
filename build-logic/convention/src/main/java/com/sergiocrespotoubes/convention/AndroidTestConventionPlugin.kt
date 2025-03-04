package com.sergiocrespotoubes.convention

import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("*** AndroidTestConventionPlugin invoked ***")
    }
}
