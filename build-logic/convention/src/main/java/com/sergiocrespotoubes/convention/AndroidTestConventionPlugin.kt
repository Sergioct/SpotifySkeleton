package com.sergiocrespotoubes.convention

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("*** AndroidTestConventionPlugin invoked ***")
    }
}