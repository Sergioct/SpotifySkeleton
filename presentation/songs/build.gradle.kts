plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.sergiocrespotoubes.songs"
    compileSdk = 34
    defaultConfig {
        minSdk = 28
        targetSdk = 34
    }
}

dependencies {
    api(project(":core:ui"))
    api(project(":core:navigation"))
    implementation(":data")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}