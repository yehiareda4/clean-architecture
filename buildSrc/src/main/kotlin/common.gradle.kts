import Dependencies.common
import Dependencies.retrofit
import Dependencies.google
import Dependencies.navigation
import Dependencies.lifecycle
import Dependencies.dataStore
import Dependencies.hilt
import Dependencies.paging

apply(plugin = Plugins.KOTLIN_KSP)
apply(plugin = "dagger.hilt.android.plugin")

// don't add plugins with constant values
plugins {
    id("com.android.library")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = AndroidConsts.APP_ID

    compileSdk = (Versions.App.COMPILE_SDK)

    defaultConfig {
        multiDexEnabled = true
        minSdk = (Versions.App.MIN_SDK)
        targetSdk = (Versions.App.TARGET_SDK)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = Versions.JAVA
        targetCompatibility = Versions.JAVA
    }

    buildFeatures.apply {
        @Incubating
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    common()
    lifecycle()
    google()
    navigation()
    dataStore()
    hilt()
    retrofit()
    paging()
    testImplementation(Dependencies.Test.Unit.JUNIT)
}

