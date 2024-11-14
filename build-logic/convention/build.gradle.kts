plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.gradlePlugin.kotlin)
    compileOnly(libs.gradlePlugin.spotless)
}

gradlePlugin {
    plugins {
        register("root"){
            id = "com.spotifyskeleton.root"
            implementationClass = "com.sergiocrespotoubes.convention.RootConventionPlugin"
        }
    }
}