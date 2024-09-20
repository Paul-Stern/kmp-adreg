rootProject.name = "KotlinProject"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    // see: https://github.com/google/ksp/blob/main/examples/multiplatform/settings.gradle.kts
    val kotlinVersion: String by settings
    val kspVersion: String by settings
    plugins {
        id("com.google.devtools.ksp") version kspVersion apply false
        kotlin("multiplatform") version kotlinVersion apply false
    }
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")