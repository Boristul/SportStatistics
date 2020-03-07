buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        val kotlinVersion: String by project

        classpath("com.android.tools.build:gradle:3.6.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0-alpha03")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

subprojects.forEach { module ->
    module.tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            @Suppress("SuspiciousCollectionReassignment")
            freeCompilerArgs += "-Xnew-inference"
        }
    }
}
