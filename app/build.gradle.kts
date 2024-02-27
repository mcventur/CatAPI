plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.mpd.pmdm.catapi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mpd.pmdm.catapi"
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
        viewBinding = true
    }
}

dependencies {
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //Moshi para convertir Json a objetos Java/Kotlin
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    //Para usar el adaptador de Moshi kotlin, que permite usar anotaciones especiales en las Data Class para la
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")
    //Coil para renderizar imágenes de diversas fuentes (en este caso de una url)
    implementation("io.coil-kt:coil:2.6.0")

    //Para usar viewModels en fragmentos
    implementation("androidx.fragment:fragment-ktx:1.6.2")


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}