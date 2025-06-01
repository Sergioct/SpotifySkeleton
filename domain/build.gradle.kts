plugins {
    id("com.spotifyskeleton.android.library")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.sergiocrespotoubes.domain"
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
    api(project(":core:common"))

    // DI - Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
}
