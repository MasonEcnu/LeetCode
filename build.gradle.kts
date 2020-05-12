import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.72"
}

group = "com.mason"
version = "1.0-SNAPSHOT"

repositories {
    maven {
        url = uri("https://maven.aliyun.com/repository/public")
    }
//        mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.72")
    implementation("com.alibaba:fastjson:1.2.58")
    implementation("com.google.code.gson:gson:2.7")
    implementation("com.typesafe.akka:akka-http-core_2.12:10.0.14")
    implementation("com.typesafe.akka:akka-stream_2.12:2.5.21")
    implementation("com.typesafe.akka:akka-http_2.12:10.1.5")
    implementation("com.squareup.okhttp:okhttp:2.5.0")
    implementation("com.vdurmont:emoji-java:4.0.0")
    implementation("commons-codec:commons-codec:1.10")
    implementation("org.apache.commons:commons-text:1.6")
    implementation("com.google.guava:guava:24.1.1-jre")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.1")
    implementation("org.slf4j:slf4j-api:1.7.21")
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit", "junit", "4.12")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}