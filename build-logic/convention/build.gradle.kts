plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.gradlePlugin.android)
    compileOnly(libs.gradlePlugin.kotlin)
    compileOnly(libs.gradlePlugin.spotless)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.spotifyskeleton.android.application"
            implementationClass = "com.sergiocrespotoubes.convention.AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.spotifyskeleton.android.library"
            implementationClass = "com.sergiocrespotoubes.convention.AndroidLibraryConventionPlugin"
        }
        register("androidTest") {
            id = "com.spotifyskeleton.android.test"
            implementationClass = "com.sergiocrespotoubes.convention.AndroidTestConventionPlugin"
        }
        register("androidCompose") {
            id = "com.spotifyskeleton.android.compose"
            implementationClass = "com.sergiocrespotoubes.convention.AndroidComposeConventionPlugin"
        }
        register("root") {
            id = "com.spotifyskeleton.root"
            implementationClass = "com.sergiocrespotoubes.convention.RootConventionPlugin"
        }
    }
}
