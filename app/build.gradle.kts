@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kover)
}

android {
    namespace = "com.example.koverissue530"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.koverissue530"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

kover {
    useJacoco("0.8.11")
}

koverReport {
    defaults {
        mergeWith("debug")
    }

    filters {
        excludes {
            annotatedBy("*Generated*")
        }
    }

    verify {
        rule {
            minBound(80)
            maxBound(100)
        }
    }

    androidReports("debug") {}
}

tasks.withType(Test::class.java).configureEach {
    finalizedBy(tasks.named("koverXmlReport"))
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.robolectric)
    testImplementation(libs.junit)
}