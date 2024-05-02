import Dependencies.socketIO
import Dependencies.coroutines
import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id(Plugins.COMMON)
}

android {
    namespace = "com.coredata"

    defaultConfig {
        val properties = Properties()
        if (project.rootProject.file("config").canRead()) {
            properties.load(FileInputStream(project.rootProject.file("config")))
        }
        buildConfigField("String", "API_KEY", properties.getProperty("API_KEY"))
        buildConfigField("String", "REMOTE_URL", properties.getProperty("REMOTE_URL"))
        buildConfigField("String", "SOCKET_PORT", properties.getProperty("SOCKET_PORT"))
    }

}

dependencies {

    implementation(project(Modules.Core.CORE_DOMAIN))

    socketIO()
    coroutines()
//    room()
}