plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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
            resValue("string", "app_name", "\"Bugün ne yapsam Dev\"")
    }
        create("prod") {
            dimension = "version"
            applicationIdSuffix = ".prod"
            buildConfigField("boolean", "TEST_ENABLED", "false")
            resValue("string", "app_name", "\"Bugün ne yapsam\"")
        }

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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    testOptions {
        unitTests {
            unitTests.isReturnDefaultValues = true
        }
    }
}
tasks.withType(type = org.jetbrains.kotlin.gradle.tasks.KaptGenerateStubs::class) {
    kotlinOptions.jvmTarget = "11"
}
configurations.all {
    resolutionStrategy.force("junit:junit:4.13.2")
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
    implementation("com.android.volley:volley:1.2.1")
    //Test Implementations
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test.ext:junit:1.1.5")
    testImplementation("com.google.truth:truth:1.4.2")
    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
}