import org.gradle.api.JavaVersion

object Versions {
    object App {
        const val VERSION_CODE = 3
        const val VERSION_NAME = "1.0.0"
        const val MIN_SDK = 23
        const val TARGET_SDK = 33
        const val COMPILE_SDK = 33
        const val BUILD_TOOLS = "33.0.1"
    }

    object Plugins {
        const val KOTLIN_KSP = "1.9.0-1.0.13"
    }

    object Google {
        const val MATERIAL = "1.9.0"
        const val GSON = "2.9.0"
    }

    object AndroidX {
        const val CORE = "1.8.0"
        const val APPCOMPAT = "1.6.0"
        const val PAGING = "3.1.1"
        const val LIFECYCLE = "2.6.0"
        const val CONSTRAIN_LAYOUT = "2.1.4"
        const val SWIPE_REFRESH_LAYOUT = "1.1.0"
        const val DATA_STORE = "1.0.0"
    }

    object Test {
        const val JUNIT = "4.13.2"
        const val JUNIT_INTEGRATION = "1.1.2"
        const val ESPRESSO = "3.3.0"
    }

    object Firebase {
        const val FIRESTORE = "24.4.1"
        const val FIREBASE_BOM = "31.2.3"
        const val FIREBASE_MESSAGING = "22.0.0"
    }

    object Network {
        const val HILT = "2.46.1"
        const val DAGGER = "2.46.1"
        const val RETROFIT = "2.9.0"
        const val COROUTINE_ADAPTER = "0.9.2"
        const val EXPERIMENTAL_COROUTINE_ADAPTER = "1.0.0"
        const val OKHTTP3 = "4.10.0"
        const val LOGGINIG_INTERCEPTOR = "3.1.0"
        const val ROOM = "2.4.3"
        const val SOCKET = "2.1.0"
    }

    object Coroutines {
        const val Coroutines = "1.3.9"
    }
    object Navigation {
        const val NAVIGATION = "2.6.0"
    }

    object Design {
        const val SMOOTH_BOTTOM_NAV = "1.7.9"
        const val PDF_VIEWER = "2.8.2"
        const val SEARCH_SPINNER = "1.1"
        const val SDP = "1.1.0"
        const val GLIDE = "4.16.0"
        const val PIN_EDIT_TEXT = "1.3.10"
        const val COUNT_DOWN_VIEW = "2.1.6"
        const val TOASTY = "1.5.2"
        const val LOTTIE_ANIMATION = "3.4.0"
        const val INDICATOR = "4.3"
        const val RANGE_SEEK_BAR = "2.0.4"
        const val IMAGE_SLIDER = "0.1.2"
        const val ROUND_IMG = "2.3.0"
        const val RATE_STAR_VIEW = "1.0"
        const val CIRCLE_INDICATOR = "2.1.6"
        const val pinView: String = "1.4.3"

        const val miraRecycleView = "1.0.09"
    }

    object PICKERS {
        const val MIRA_FILE = "3.1.46"
    }

    // Make sure to update `buildSrc/build.gradle.kts` when updating this
    const val GRADLE = "8.1.1"

    // Make sure to update `buildSrc/build.gradle.kts` when updating this
    const val KOTLIN = "1.9.0"

    val JAVA = JavaVersion.VERSION_17
}
