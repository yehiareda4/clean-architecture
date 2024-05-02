plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id(Plugins.KOTLIN)
    kotlin(Plugins.KOTLIN_KAPT)
    id(Plugins.KOTLIN_KSP)
    kotlin(Plugins.KOTIN_SERIALIZATION) version Versions.KOTLIN
}

java {
    sourceCompatibility = Versions.JAVA
    targetCompatibility = Versions.JAVA
}

dependencies {
    implementation(project(Modules.Core.CORE_DOMAIN))

}