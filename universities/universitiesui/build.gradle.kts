import Dependencies.rxKotlin


plugins {
    id(Plugins.COMMON)
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.aait.homeui"
}

dependencies {

    implementation(project(Modules.NAVIGATION))
    implementation(project(Modules.Core.CORE_UI))
    implementation(project(Modules.Core.CORE_DOMAIN))
    implementation(project(Modules.UNIVERSITIES.UNIVERSITIES_DOMAIN))
    rxKotlin()
}