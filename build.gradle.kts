import org.jetbrains.kotlin.builtins.StandardNames.FqNames.target
import java.util.Properties
import java.io.FileInputStream

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.dynamic.feature) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.spotless) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.room) apply false
    alias(libs.plugins.dependency.check)
    id("com.spotifyskeleton.root")
}

val prop = Properties().apply {
    load(FileInputStream(rootProject.file("gradle.properties")))
}

dependencyCheck {
    nvd {
        apiKey = prop.getProperty("nvdApiKey")
    }
}
