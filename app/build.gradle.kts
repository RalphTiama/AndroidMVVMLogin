plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    alias(libs.plugins.google.dagger.hilt)


}

android {
    namespace = "com.example.androidmvvmlogin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidmvvmlogin"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        //noinspection DataBindingWithoutKapt
        dataBinding = true
        viewBinding = true
    }
    kapt{
        correctErrorTypes = true
    }


}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // ViewModel & LiveData dependencies (Lifecycle components)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Coroutines dependency
    implementation(libs.kotlinx.coroutines.android)

    //Dagger Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    //Lottie
    implementation(libs.lottie)

    //Room
    implementation( libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt (libs.androidx.room.compiler)

}