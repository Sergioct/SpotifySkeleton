plugins {
    id("com.spotifyskeleton.android.library")
}

android {
    namespace = "com.sergiocrespotoubes.testing"
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
    // Testing
    runtimeOnly(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlin.test)
    implementation(libs.junit4)
}
