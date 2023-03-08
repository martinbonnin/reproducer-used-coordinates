import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.apollographql.apollo3.gradle.api.ApolloExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

fun Project.configureStuff() {
    project.extensions.getByName("android").apply {
        this as BaseExtension
        compileOptions {
            it.sourceCompatibility = JavaVersion.VERSION_1_8
            it.targetCompatibility = JavaVersion.VERSION_1_8
        }
    }
    project.tasks.withType(KotlinCompile::class.java) {
        it.kotlinOptions {
            this as KotlinJvmOptions
            this.jvmTarget = "1.8"
        }
    }
    project.extensions.getByName("kotlin").apply {
        this as KotlinProjectExtension

    }
    project.extensions.getByName("java").apply {
        this as JavaPluginExtension
    }
    val isSchemaModule = true
    project.extensions.getByName("apollo").apply {
        this as ApolloExtension
        service("api1Debug") {
            it.packageName.set("com.example.api1")
            it.srcDir("graphql")
            it.generateApolloMetadata.set(isSchemaModule)
            it.outputDirConnection {
                it.connectToKotlinSourceSet("debug")
            }
        }
        service("api1Release") {
            it.packageName.set("com.example.api1")
            it.srcDir("graphql")
            it.generateApolloMetadata.set(isSchemaModule)
            it.outputDirConnection {
                it.connectToKotlinSourceSet("release")
            }
        }
        service("api2Debug") {
            it.packageName.set("com.example.api2")
            it.srcDir("graphql")
            it.generateApolloMetadata.set(isSchemaModule)
            it.outputDirConnection {
                it.connectToKotlinSourceSet("debug")
            }
        }
        service("api2Release") {
            it.packageName.set("com.example.api2")
            it.srcDir("graphql")
            it.generateApolloMetadata.set(isSchemaModule)
            it.outputDirConnection {
                it.connectToKotlinSourceSet("release")
            }
        }
    }
}