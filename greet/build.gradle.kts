plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "me.justmambo.libraries.greet"
    compileSdk = 32

    defaultConfig {
        minSdk = 24
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles ("consumer-rules.pro")
        externalNativeBuild {
            cmake {
                cppFlags += ""
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.18.1"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.register("checkForRequiredFiles"){
    println("-".repeat(20).plus("> Running File check"))
    val filePath = "${rootProject.rootDir}/details.cpp"
    val file = File(filePath)

    if(file.exists().not()) throw GradleException("ERROR : details.cpp file not found in root project")

    println("SUCCESS : details.cpp file found successfully ")

}

tasks.matching{ it.name != "checkForRequiredFiles" }.all {
    println("Executing task : ${this.name}")
    this.dependsOn("checkForRequiredFiles")
}

dependencies {

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}

afterEvaluate {
    publishing {
        publications {
            register("release", MavenPublication::class) {
                from(components["release"])
                groupId = "me.justmambo.libraries"
                artifactId = "greet"
                version = "0.0.1"
            }
        }
    }
}