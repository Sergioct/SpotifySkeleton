plugins {
    id("com.spotifyskeleton.android.library")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.sergiocrespotoubes.navigation"
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
}

dependencies {
    api(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)
    api(project(":domain"))

    api(libs.androidx.hilt.navigation.compose)
}
