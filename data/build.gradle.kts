plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.sergiocrespotoubes.data"
    compileSdk = 34
    defaultConfig {
        minSdk = 28
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://api.spotify.com\"",
            )
            buildConfigField(
                "String",
                "BASE_AUTH_URL",
                "\"https://accounts.spotify.com\"",
            )
        }
        debug {
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://api.spotify.com\"",
            )
            buildConfigField(
                "String",
                "BASE_AUTH_URL",
                "\"https://accounts.spotify.com\"",
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
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(":core:preferences"))
    api(project(":core:common"))
    api(project(":domain"))

    // Networking
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.retrofit.adapters.result)
    implementation(libs.logging.interceptor)

    // Serialization
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit2.kotlinx.serialization.converter)

    // DI - Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Database - Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
}
