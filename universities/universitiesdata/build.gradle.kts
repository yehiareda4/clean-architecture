plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id(Plugins.COMMON)
}

android {
    namespace = "com.aait.moredata"
}

dependencies {

    implementation(project(Modules.Core.CORE_DATA))
    implementation(project(Modules.Core.CORE_DOMAIN))
    implementation(project(Modules.UNIVERSITIES.UNIVERSITIES_DOMAIN))

}