plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.sergiocrespotoubes.domain"
    compileSdk = 34
}

dependencies {
    implementation(project(":data"))
}