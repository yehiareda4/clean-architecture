
plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
    // This should be in-sync with the Gradle version exposed by `Versions.kt`
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    // This should be in-sync with the Gradle version exposed by `Versions.kt`
    implementation("com.android.tools.build:gradle:8.1.1")

    // This should be in-sync with the Kotlin version exposed by `Versions.kt`
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")

//    dagger()
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.46.1")

    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.1")

    implementation(kotlin("script-runtime"))
}
