plugins {
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.spotifyskeleton.root")
    id("com.spotifyskeleton.android.application")
    id("com.spotifyskeleton.android.flavors")
    id("com.spotifyskeleton.android.library")
    id("com.spotifyskeleton.android.test")
    id("io.gitlab.arturbosch.detekt")
}

android {
    namespace = "com.sergiocrespotoubes.spotify"

    defaultConfig {
        applicationId = "com.sergiocrespotoubes.spotify"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        release {
            isDebuggable = false
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.6"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    api(project(":core:ui"))
    api(project(":core:navigation"))
    api(project(":core:preferences"))
    api(project(":core:common"))
    api(project(":core:testing"))
    api(project(":data"))
    api(project(":domain"))
    api(project(":presentation:trackdetail"))
    api(project(":presentation:artistdetail"))
    api(project(":presentation:search"))
    api(project(":presentation:splash"))

    // Debug
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // DI - Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
}
