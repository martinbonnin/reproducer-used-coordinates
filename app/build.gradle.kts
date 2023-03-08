plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.apollographql.apollo3")
}

configureStuff()

android {
    namespace = "com.example.app"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.app"
        versionCode = 1
        versionName = "1.0"

        minSdk = 22
        targetSdk = 33
    }
}

dependencies {
    implementation(project(":lib"))
    add("apolloApi1DebugConsumer", project(":lib"))
    add("apolloApi1ReleaseConsumer", project(":lib"))
    add("apolloApi2DebugConsumer", project(":lib"))
    add("apolloApi2ReleaseConsumer", project(":lib"))

    add("apolloApi1DebugSchemaConsumer", project(":lib"))
    add("apolloApi1ReleaseSchemaConsumer", project(":lib"))
    add("apolloApi2DebugSchemaConsumer", project(":lib"))
    add("apolloApi2ReleaseSchemaConsumer", project(":lib"))
}