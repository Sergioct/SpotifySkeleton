pluginManagement {
    includeBuild("core/build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SpotifySkeleton"
include(":app")
include(":presentation")
include(":presentation:splash")
include(":domain")
include(":data")
include(":core")
include(":core:navigation")
include(":core:ui")
include(":core:preferences")
include(":presentation:artistsearch")
include(":presentation:trackdetail")
include(":core:common")
include(":core:testing")
