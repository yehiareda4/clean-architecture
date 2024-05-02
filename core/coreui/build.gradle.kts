import Dependencies.design

plugins {
    id(Plugins.COMMON)
    id("org.jetbrains.kotlin.android")
    kotlin(Plugins.KOTLIN_KAPT)
}

android {
    namespace = "com.aait.coreui"
}

dependencies {

    implementation(project(Modules.NAVIGATION))
    implementation(project(Modules.Core.CORE_DOMAIN))

    api("androidx.work:work-runtime:2.8.1")
    api("org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}")
    api(Dependencies.Design.CHOCO_BAR)
    design()
    api(Dependencies.Design.AWESOME_DIALOG)
}