plugins {
    id("com.spotifyskeleton.android.library")
    //id("com.spotifyskeleton.android.compose")
}

android {
    namespace = "com.sergiocrespotoubes.ui"
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
    implementation(project(":domain"))

    api(libs.kotlinx.coroutines.core)
    api(libs.androidx.core.ktx)
    api(libs.androidx.appcompat)
    api(libs.material)
    api(libs.androidx.lifecycle.runtime.ktx)
    api(libs.androidx.activity.compose)
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)
    api(libs.ui.tooling.preview)
    api(libs.androidx.ui.tooling)
    api(libs.androidx.material3)
    api(libs.androidx.runtime)
    api(libs.coil.compose)
}
