//plugins {
//    id ("com.android.application") version "7.3.1" apply false
//    id ("com.android.library") version "7.3.1" apply false
//    id("org.jetbrains.kotlin.android") version "1.8.0"
//}
plugins {
    id(Plugins.KOTLIN_KSP) version Versions.Plugins.KOTLIN_KSP apply false
}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://www.jitpack.io") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}")
        classpath ("com.google.gms:google-services:4.3.15")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.1")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.Network.DAGGER}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven ( url = "https://www.jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
