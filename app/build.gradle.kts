import Dependencies.hilt


plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.GOOGLE_SERVICES)
    id(Plugins.HILT)
    kotlin(Plugins.KOTLIN_ANDROID)
    id("androidx.navigation.safeargs")
    kotlin(Plugins.KOTLIN_KAPT)
    id(Plugins.KOTLIN_KSP)
    kotlin(Plugins.KOTIN_SERIALIZATION) version Versions.KOTLIN
}


android {
    namespace = AndroidConsts.APP_ID
    compileSdk = (Versions.App.COMPILE_SDK)
    buildToolsVersion = Versions.App.BUILD_TOOLS

    defaultConfig {
        multiDexEnabled = true
        applicationId = AndroidConsts.APP_ID

        minSdk = Versions.App.MIN_SDK
        targetSdk = Versions.App.TARGET_SDK

        versionCode = Versions.App.VERSION_CODE
        versionName = Versions.App.VERSION_NAME

        testInstrumentationRunner = AndroidConsts.TEST_RUNNER


        javaCompileOptions {
            annotationProcessorOptions {
                arguments(
                    mapOf(
                        "room.schemaLocation" to "$projectDir/schemas",
                        "room.incremental" to "true",
                        "room.expandProjection" to "true"
                    )
                )
            }
        }

    }

    signingConfigs {
        create("release") {
            keyAlias = "MyKeyAlias"
            keyPassword = "MyKeyPassword"
            storeFile = file("Path/To/Key")
            storePassword = "KeyStorePassword"
        }
    }

    buildTypes {
        getByName(AndroidConsts.BuildTypes.RELEASE) {
            isMinifyEnabled = false  // remove all unused classes
            isShrinkResources = false  //remove unused resources
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            buildConfigField("String", "EXAMPLE", "\"release\"")
        }
        getByName(AndroidConsts.BuildTypes.DEBUG) {
//                applicationIdSuffix = ".debug"
            buildConfigField("String", "EXAMPLE", "\"debug\"")
        }
    }

    compileOptions {
        sourceCompatibility = Versions.JAVA
        targetCompatibility = Versions.JAVA
    }

    kotlinOptions {
        jvmTarget = Versions.JAVA.toString()
    }

    testOptions {
        animationsDisabled = true
        unitTests.apply {
            isReturnDefaultValues = true
        }
    }

    dataBinding {
        enable = true
    }

    buildFeatures.apply {
        @Incubating
        viewBinding = true
        dataBinding = true
    }


//        appsweep {
//            apiKey = "gs_appsweep_ROu4DM3_ryEcXjDesZErwC54moGFoz4sM1GHJexo"
//        }

}



dependencies {
    //Loads packaged libraries in the libs folder
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(Modules.NAVIGATION))

    implementation(project(Modules.Core.CORE))
    implementation(project(Modules.Core.CORE_UI))
    implementation(project(Modules.Core.CORE_DATA))
    implementation(project(Modules.Core.CORE_DOMAIN))

    implementation(project(Modules.UNIVERSITY.UNIVERSITY_UI))


    implementation(project(Modules.UNIVERSITIES.UNIVERSITIES_DATE))
    implementation(project(Modules.UNIVERSITIES.UNIVERSITIES_DOMAIN))
    implementation(project(Modules.UNIVERSITIES.UNIVERSITIES_UI))

    implementation ("com.android.support:multidex:2.0.1")
    hilt()
}
