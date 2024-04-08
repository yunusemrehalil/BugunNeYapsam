import org.jetbrains.kotlin.de.undercouch.gradle.tasks.download.org.apache.commons.logging.LogFactory.release

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.nomaddeveloper.bugunneyapsam"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nomaddeveloper.bugunneyapsam"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

        flavorDimensions += "version"
    productFlavors {
        create("dev") {
            dimension = "version"
            applicationIdSuffix = ".dev"
            buildConfigField("boolean", "TEST_ENABLED", "true")
            resValue("string", "app_name", "\"Dev Bugün ne yapsam\"")
        }
        create("prod") {
            dimension = "version"
            buildConfigField("boolean", "TEST_ENABLED", "false")
            resValue("string", "app_name", "\"Bugün ne yapsam\"")
        }
    }

    buildTypes {
        debug {
            manifestPlaceholders["crashlyticsEnabled"] = false
        }
        release {
            manifestPlaceholders += mapOf()
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug") // TODO() create config file for debug and release with ext .jks
            manifestPlaceholders["crashlyticsEnabled"] = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}
dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.annotation:annotation:1.7.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    //My Login Client
    implementation(files("./libs/BaseLoginClient.aar"))
    //Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:32.8.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics")
    //Test Implementations
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test.ext:junit:1.1.5")
    testImplementation("com.google.truth:truth:1.4.2")
    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
}