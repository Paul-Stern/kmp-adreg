import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

val kspVersion: String by project

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    // see: https://kotlinlang.org/docs/ksp-quickstart.html
    alias(libs.plugins.ksp)
    kotlin("plugin.serialization") version "2.0.20"
    alias(libs.plugins.sqldelight)
//    alias(libs.plugins.serialization)
//    id("com.google.devtools.ksp") version "2.0.20-1.0.24"
//    kotlin("jvm")
}

/*
// see: https://github.com/google/ksp/blob/9faf2165dc393363f98948442333b88751676ffa/examples/multiplatform/build.gradle.kts#L5
allprojects {
    repositories {
        mavenCentral()
    }
}
// see: https://kotlinlang.org/docs/ksp-quickstart.html#add-a-processor
repositories {
    mavenCentral()
}
*/


kotlin {
    /*
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "composeApp"
        browser {
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }
     */
    /*
    js(IR) {
        binaries.executable()
    }
    error:
    Could not resolve all artifacts for configuration ':composeApp:jsCompileClasspath'.
> Could not resolve com.google.devtools.ksp:symbol-processing-api:2.0.20-1.0.25.
  Required by:
      project :composeApp
     */

    jvm("desktop")

    sourceSets {
        val desktopMain by getting
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha07")
//            implementation(libs.compose.navigation)
            // Koin:
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
            implementation(libs.koin.annotations)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel.navigation)
//            implementation(libs.koin.ksp.compiler)
            implementation(kotlin("stdlib-jdk8"))
            // Koin Annotations KSP Compiler
            implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
//            ksp(libs.koin.ksp.compiler)
            // Koin Annotations
//            api("io.insert-koin:koin-annotations:$koin_annotations_version")
//            implementation(libs.kotlinx.serialization.json)
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
            // DataStore
            // see: https://developer.android.com/jetpack/androidx/releases/datastore
            // see: https://search.brave.com/search?q=kotlin+datastore+use+sqlite+db&source=web&summary=1&summary_og=27ccc0c0e822cc98cb91c9:w
            implementation("androidx.datastore:datastore-preferences:1.1.1")
        }
        commonMain.configure {
            kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
        }
        jvmMain.dependencies {
            implementation(libs.native.driver)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
        nativeMain.dependencies {
            implementation(libs.native.driver)
        }
        /*
        androidMain.dependencies {
            implementation(libs.native.driver)
        }

         */
    }

}

dependencies {
    add("kspCommonMainMetadata", libs.koin.ksp.compiler)
    // All of the following are broken
    /*
    add("kspAndroid", libs.koin.ksp.compiler) // TODO: fix broken this
    add("kspIosX64", libs.koin.ksp.compiler)
    add("kspIosArm64", libs.koin.ksp.compiler)
    add("kspIosSimulatorArm64", libs.koin.ksp.compiler)

     */
}
/*
// see: https://insert-koin.io/docs/setup/annotations#kotlin--multiplatform
project.tasks.withType(KotlinCompilationTask::class.java).configureEach {
    if(name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}
 */


compose.desktop {
    application {
        mainClass = "org.example.project.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.example.project"
            packageVersion = "1.0.0"
        }
    }
}

// see: https://cashapp.github.io/sqldelight/2.0.2/multiplatform_sqlite/

sqldelight {
    databases {
        create("Users") {
            packageName.set("org.example.project.db")
        }
    }
}
