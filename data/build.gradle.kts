plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.sergiocrespotoubes.data"
    compileSdk = 34
}

dependencies {
    implementation(libs.retrofit)
}