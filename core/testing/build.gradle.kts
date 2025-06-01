plugins {
    id("com.spotifyskeleton.android.library")
}

android {
    namespace = "com.sergiocrespotoubes.testing"
    compileSdk = 35

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    // Testing
    runtimeOnly(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlin.test)
    implementation(libs.junit4)
}
