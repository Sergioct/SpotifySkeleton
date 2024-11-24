plugins {
    `kotlin-dsl`
}

dependencies {
    //compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.gradlePlugin.kotlin)
    compileOnly(libs.gradlePlugin.spotless)
}

gradlePlugin {
    plugins {
        /*register("androidApplicationCompose") {
            id = "com.spotifyskeleton.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }*/
        register("root"){
            id = "com.spotifyskeleton.root"
            implementationClass = "com.sergiocrespotoubes.convention.RootConventionPlugin"
        }
    }
}