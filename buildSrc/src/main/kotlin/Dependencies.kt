import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope

object Dependencies {
    object Kotlin {
        const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
        const val REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${Versions.KOTLIN}"
    }

    object AndroidX {
        const val CORE = "androidx.core:core-ktx:${Versions.AndroidX.CORE}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.APPCOMPAT}"

        const val ANDROID_LIFECYCLE_VIEWMODEL =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.LIFECYCLE}"
        const val ANDROID_LIFECYCLE_LIVEDATA =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.AndroidX.LIFECYCLE}"
        const val ANDROID_LIFECYCLE_COMPAILER =
            "androidx.lifecycle:lifecycle-compiler:${Versions.AndroidX.LIFECYCLE}"

        const val CONSTRAIN_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.CONSTRAIN_LAYOUT}"
        const val SWIPE_REFRESH_LAYOUT =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.AndroidX.SWIPE_REFRESH_LAYOUT}"
        const val PAGING = "androidx.paging:paging-runtime-ktx:${Versions.AndroidX.PAGING}"
        const val COMMON_PAGING = "androidx.paging:paging-common-ktx:${Versions.AndroidX.PAGING}"
        const val DATA_STORE =
            "androidx.datastore:datastore-preferences-core:${Versions.AndroidX.DATA_STORE}"
        const val DATA_STORE_PREF =
            "androidx.datastore:datastore-preferences:${Versions.AndroidX.DATA_STORE}"
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:${Versions.Google.MATERIAL}"
        const val GSON = "com.google.code.gson:gson:${Versions.Google.GSON}"
        const val ANDROID_SERVICE_MAP = "com.google.android.gms:play-services-maps:18.1.0"
        const val SERVICE_MAP = "com.google.maps:google-maps-services:0.1.20"
        const val SERVICE_LOCATION = "com.google.android.gms:play-services-location:21.0.1"
        const val SERVICE_PLACES = "com.google.android.gms:play-services-places:17.0.0"
        const val GOOGLE_PLACES = "com.google.android.libraries.places:places:2.5.0"
        const val DEXTER = "com.karumi:dexter:4.2.0"
    }

    object RxKotlin {
        const val RX_KOTLIN_2 = "io.reactivex.rxjava2:rxkotlin:2.0.1"
        const val RX_KOTLIN_3 = "io.reactivex.rxjava3:rxkotlin:3.0.1"
        const val RX_ANDROID_3 = "io.reactivex.rxjava3:rxandroid:3.0.1"

    }


    object Design {
        const val SDP = "com.intuit.sdp:sdp-android:${Versions.Design.SDP}"
        const val SSP = "com.intuit.ssp:ssp-android:${Versions.Design.SDP}"
        const val miraRecycleView =
            "com.github.yehiareda4:MiraRecycleView:${Versions.Design.miraRecycleView}"
        const val GLIDE = "com.github.bumptech.glide:glide:${Versions.Design.GLIDE}"
        const val GLIDE_COMPILER = "com.github.bumptech.glide:ksp:${Versions.Design.GLIDE}"
        const val CIRCLE_INDICATOR = "me.relex:circleindicator:${Versions.Design.CIRCLE_INDICATOR}"
        const val PIN_EDIT_TEXT =
            "com.alimuzaffar.lib:pinentryedittext:${Versions.Design.PIN_EDIT_TEXT}"
        const val COUNT_DOWN_VIEW =
            "com.github.iwgang:countdownview:${Versions.Design.COUNT_DOWN_VIEW}"
        const val TOASTY = "com.github.GrenderG:Toasty:${Versions.Design.TOASTY}"
        const val LOTTIE_ANIMATION = "com.airbnb.android:lottie:${Versions.Design.LOTTIE_ANIMATION}"
        const val INDICATOR = "com.tbuonomo:dotsindicator:${Versions.Design.INDICATOR}"
        const val ROUND_IMG = "om.makeramen:roundedimageview:${Versions.Design.ROUND_IMG}"
        const val RATE_STAR_VIEW =
            "com.github.maxwell-nc:StarRatingView:${Versions.Design.RATE_STAR_VIEW}"
        const val RANGE_SEEK_BAR =
            "com.github.Jay-Goo:RangeSeekBar:${Versions.Design.RANGE_SEEK_BAR}"
        const val IMAGE_SLIDER =
            "com.github.denzcoskun:ImageSlideshow:${Versions.Design.IMAGE_SLIDER}"
        const val STEPPER = "com.github.kAvEh--:slider-view:Tag"
        const val pinView = "com.chaos.view:pinview:${Versions.Design.pinView}"
        const val AWESOME_DIALOG = "com.github.chnouman:AwesomeDialog:1.0.5"
        const val CHOCO_BAR = "com.github.Pradyuman7.ChocoBar:chocobar:V2.0"
        const val LOCUS = "com.github.BirjuVachhani:locus-android:4.1.2"
    }

    object SocketIO {
        const val socket_io = "io.socket:socket.io-client:${Versions.Network.SOCKET}"
        const val json_org = "org.json:json:20200518"
    }

    object PERMISSION {
        const val TED_PERMISSION = "io.github.ParkSangGwon:tedpermission-normal:3.3.0"
    }

    object Test {
        object Unit {
            const val JUNIT = "junit:junit:${Versions.Test.JUNIT}"
        }

        object Integration {
            const val JUNIT = "androidx.test.ext:junit:${Versions.Test.JUNIT_INTEGRATION}"
            const val ESPRESSO_CORE =
                "androidx.test.espresso:espresso-core:${Versions.Test.ESPRESSO}"
        }

    }

    object Firebase {
        const val FIREBASE_BOM =
            "com.google.firebase:firebase-bom:${Versions.Firebase.FIREBASE_BOM}"
        const val FIREBASE_MESSAGING =
            "com.google.firebase:firebase-messaging-ktx"
        const val FIRESTORE =
            "com.google.firebase:firebase-firestore:${Versions.Firebase.FIRESTORE}"
        const val FIREBASE_ANALYTICS =
            "com.google.firebase:firebase-analytics-ktx"
    }

    object AnnotationProcessorsDependencies {
        const val DAGGER = "com.google.dagger:dagger:${Versions.Network.DAGGER}"
        const val DAGGER_HILT = "com.google.dagger:hilt-android:${Versions.Network.HILT}"
        const val DAGGER_HILT_COMPILER =
            "com.google.dagger:hilt-android-compiler:${Versions.Network.HILT}"

        const val ROOM = "androidx.room:room-compiler:${Versions.Network.ROOM}"
        const val ANDROID_ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.Network.ROOM}"
        const val ANDROID_ROOM_KTX = "androidx.room:room-ktx:${Versions.Network.ROOM}"

        const val RETROFIT_GSON =
            "com.squareup.retrofit2:converter-gson:${Versions.Network.RETROFIT}"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.Network.RETROFIT}"
        const val RETROFIT_CONVERTER_MOSHI =
            "com.squareup.retrofit2:converter-moshi:${Versions.Network.RETROFIT}"
        const val COROUTINE_ADAPTER =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.Network.COROUTINE_ADAPTER}"
        const val COROUTINE_EXPERIMENTAL_ADAPTER =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-experimental-adapter:${Versions.Network.EXPERIMENTAL_COROUTINE_ADAPTER}"
        const val KOTLIN_COROUTINE_ADAPTER =
            "com.github.jakewharton:retrofit2-kotlin-coroutines-adapter:${Versions.Network.EXPERIMENTAL_COROUTINE_ADAPTER}"

        const val OKHTTP_LOGGER =
            "com.squareup.okhttp3:logging-interceptor:${Versions.Network.OKHTTP3}"

        const val LOGGINIG_INTERCEPTOR =
            "com.github.ihsanbal:LoggingInterceptor:${Versions.Network.LOGGINIG_INTERCEPTOR}"
    }

    object Coroutines {
        const val COROOUTINES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutines.Coroutines}"
        const val COROOUTINES_CORE =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutines.Coroutines}"
    }

    object ClassPath {
        const val BUILD_TOOLS = "com.android.tools.build:gradle:${Versions.GRADLE}"
        const val JETBRAINS_KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    }

    object Navigation {
        const val NAVIGATION_FRAGMENT =
            "androidx.navigation:navigation-fragment-ktx:${Versions.Navigation.NAVIGATION}"
        const val NAVIGATION_UI =
            "androidx.navigation:navigation-ui-ktx:${Versions.Navigation.NAVIGATION}"
    }


    object SmoothBottomNav {
        const val SMOOTH_BOTTOM_NAV =
            "com.github.ibrahimsn98:SmoothBottomBar:${Versions.Design.SMOOTH_BOTTOM_NAV}"
    }

    object PDFViewer {
        const val PDF_VIEWER =
            "com.github.barteksc:android-pdf-viewer:${Versions.Design.PDF_VIEWER}"
    }


    fun DependencyHandlerScope.common() {
        api(AndroidX.APPCOMPAT)
        api(AndroidX.CORE)
        api(PERMISSION.TED_PERMISSION)
    }

    fun DependencyHandlerScope.commonIntegrationTest() {
        testImplementation(Test.Integration.JUNIT)
        testImplementation(Test.Integration.ESPRESSO_CORE)
        testImplementation(Test.Unit.JUNIT)
    }

    fun DependencyHandlerScope.commonUnitTest() {
        testImplementation(Test.Unit.JUNIT)
    }

    fun DependencyHandlerScope.google() {
        api(Google.MATERIAL)
        api(Google.GSON)
        api(Google.GOOGLE_PLACES)
        api(Google.ANDROID_SERVICE_MAP)
        api(Google.SERVICE_MAP)
        api(Google.SERVICE_LOCATION)
        api(Google.SERVICE_PLACES)
    }

    fun DependencyHandler.lifecycle() {
        kapt(AndroidX.ANDROID_LIFECYCLE_COMPAILER)
        api(AndroidX.ANDROID_LIFECYCLE_VIEWMODEL)
        api(AndroidX.ANDROID_LIFECYCLE_LIVEDATA)
    }

    fun DependencyHandler.paging() {
        api(AndroidX.PAGING)
    }

    fun DependencyHandler.commonPaging() {
        api(AndroidX.COMMON_PAGING)
    }

    fun DependencyHandler.retrofit() {
        api(AnnotationProcessorsDependencies.RETROFIT_GSON)
        api(AnnotationProcessorsDependencies.RETROFIT)
        api(AnnotationProcessorsDependencies.RETROFIT_CONVERTER_MOSHI)
        api(AnnotationProcessorsDependencies.COROUTINE_ADAPTER)
        api(AnnotationProcessorsDependencies.LOGGINIG_INTERCEPTOR)
        api(AnnotationProcessorsDependencies.COROUTINE_EXPERIMENTAL_ADAPTER)
        api(AnnotationProcessorsDependencies.COROUTINE_EXPERIMENTAL_ADAPTER)
    }

    fun DependencyHandler.room() {
        api(AnnotationProcessorsDependencies.ANDROID_ROOM_RUNTIME)
        api(AnnotationProcessorsDependencies.ANDROID_ROOM_KTX)
        kapt(AnnotationProcessorsDependencies.ROOM)
    }

    fun DependencyHandler.navigation() {
        api(Navigation.NAVIGATION_FRAGMENT)
        api(Navigation.NAVIGATION_UI)
    }

    fun DependencyHandler.firebase() {
        api(Firebase.FIREBASE_BOM)
        api(Firebase.FIREBASE_MESSAGING)
        api(Firebase.FIREBASE_ANALYTICS)
    }

    fun DependencyHandler.hilt() {
        api(AnnotationProcessorsDependencies.DAGGER_HILT)
        kapt(AnnotationProcessorsDependencies.DAGGER_HILT_COMPILER)
    }

    fun DependencyHandler.dagger() {
        api(AnnotationProcessorsDependencies.DAGGER)
    }

    fun DependencyHandler.dataStore() {
        implementation(AndroidX.DATA_STORE)
        implementation(AndroidX.DATA_STORE_PREF)
    }

    fun DependencyHandler.coroutines() {
        api(Coroutines.COROOUTINES)
    }

    fun DependencyHandler.design() {
        implementation(AndroidX.CONSTRAIN_LAYOUT)
        api(Design.SSP)
        api(Design.miraRecycleView)
        api(Design.SDP)
        api(Design.GLIDE)
        ksp(Design.GLIDE_COMPILER)
        api(Design.TOASTY)
    }

    fun DependencyHandler.rxKotlin() {
        api(RxKotlin.RX_KOTLIN_3)
        api(RxKotlin.RX_ANDROID_3)
    }

    fun DependencyHandler.socketIO() {
        api(SocketIO.socket_io)
        api(SocketIO.json_org)
    }
}
