plugins {
    id(Plugins.COMMON)
    id("androidx.navigation.safeargs")
    kotlin(Plugins.KOTLIN_KAPT)
}

android {
    namespace = "com.aait.navigation"
}

dependencies {
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}")
    api("org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}")
    implementation(project(Modules.UNIVERSITIES.UNIVERSITIES_DOMAIN))
}