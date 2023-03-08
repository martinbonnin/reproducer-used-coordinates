plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.apollographql.apollo3")
}

configureStuff()

android {
    compileSdk = 33
    namespace = "com.example.lib"

    defaultConfig {
        minSdk = 22
    }
}

dependencies {
    api("com.apollographql.apollo3:apollo-runtime")

    add("apolloApi1DebugUsedCoordinatesConsumer", project(":app"))
    add("apolloApi1ReleaseUsedCoordinatesConsumer", project(":app"))
    add("apolloApi2DebugUsedCoordinatesConsumer", project(":app"))
    add("apolloApi2ReleaseUsedCoordinatesConsumer", project(":app"))
}

