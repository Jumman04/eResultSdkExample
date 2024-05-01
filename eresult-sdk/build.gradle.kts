plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    namespace = "com.eresult.sdk"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = "com.github.lazy-pr0grammer"
                artifactId = "eresult-sdk"
                version = "1.0"

                afterEvaluate {
                    from(components.findByName("java"))
                }
            }
        }
    }
}
