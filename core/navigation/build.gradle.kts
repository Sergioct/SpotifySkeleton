plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.sergiocrespotoubes.navigation"
    compileSdk = 34
    defaultConfig {
        minSdk = 28
        targetSdk = 34
    }
}

dependencies {
    //implementation (libs.androidx.navigation.compose)
}