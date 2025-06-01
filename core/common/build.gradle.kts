plugins {
    id("com.spotifyskeleton.android.library")
}

android {
    namespace = "com.sergiocrespotoubes.common"
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    api(libs.kotlinx.coroutines.core)
}
