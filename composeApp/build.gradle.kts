import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    // see: https://kotlinlang.org/docs/ksp-quickstart.html
    id("com.google.devtools.ksp") version "2.0.20-1.0.24"
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

    jvm("desktop")

    sourceSets {
        val desktopMain by getting
        val koin_annotations_version = "1.3.1"
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
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
            implementation("com.google.dagger:dagger-compiler:2.51.1")
//            ksp("com.google.dagger:dagger-compiler:2.51.1")
            implementation(kotlin("stdlib-jdk8"))
            implementation("com.google.dagger:dagger-compiler:2.51.1")
//            ksp("com.google.dagger:dagger-compiler:2.51.1")
            // Koin Annotations
            api("io.insert-koin:koin-annotations:$koin_annotations_version")
        }
            commonMain.configure {
                kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
            }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

dependencies {
    add("kspCommonMainMetadata", libs.koin.ksp.compiler)
    // All of the following are broken
//    /*
    add("kspAndroid", libs.koin.ksp.compiler) // TODO: fix broken this
    add("kspIosX64", libs.koin.ksp.compiler)
    add("kspIosArm64", libs.koin.ksp.compiler)
    add("kspIosSimulatorArm64", libs.koin.ksp.compiler)

//     */
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
