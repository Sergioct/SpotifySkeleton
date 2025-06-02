plugins {
    id("com.spotifyskeleton.android.library")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.sergiocrespotoubes.artistdetail"
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
    api(project(":core:ui"))
    implementation(project(":core:navigation"))
    implementation(project(":domain"))

    // DI - Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
}
