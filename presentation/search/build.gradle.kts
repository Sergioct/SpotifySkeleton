plugins {
    id("com.spotifyskeleton.android.library")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.sergiocrespotoubes.artistsearch"
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
    flavorDimensions.add("version")
    productFlavors {
        create("real") {
            dimension = "version"
        }
        create("mock") {
            dimension = "version"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.6"
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
