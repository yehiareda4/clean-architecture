import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * @return the dependency
 */
fun DependencyHandler.debugImplementation(dependencyNotation: String): Dependency? =
    add("debugImplementation", dependencyNotation)

fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("implementation", dependencyNotation)


fun DependencyHandler.implementationPlatform(dependencyNotation: String): Dependency? =
    add("implementation", platform(dependencyNotation))


fun DependencyHandler.apiPlatform(dependencyNotation: String): Dependency? =
    add("api", platform(dependencyNotation))

fun DependencyHandler.annotationProcessor(dependencyNotation: String): Dependency? =
    add("annotationProcessor", dependencyNotation)

fun DependencyHandler.api(dependencyNotation: String): Dependency? = add("api", dependencyNotation)

fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)

fun DependencyHandler.ksp(dependencyNotation: String): Dependency? = add("ksp", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

val Project.android: BaseExtension
    get() = extensions.findByName("android") as? BaseExtension
        ?: error("Project '$name' is not an Android module")