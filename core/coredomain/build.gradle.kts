import Dependencies.coroutines
import Dependencies.commonPaging
import Dependencies.dagger

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
    api (Dependencies.SocketIO.json_org)

    dagger()
    coroutines()
    commonPaging()
//    moshi()
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    api("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
}