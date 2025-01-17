import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.10"
    `maven-publish`
}

group = "cu.suitetecsa"
version = "0.2-alpha02"

publishing {
    // Configure el paquete de salida publicado, un proyecto puede tener múltiples salidas, pero solo una es
    publications {
        create<MavenPublication>("suitetecsa-core") {
            from(components["java"])
        }
    }
}


repositories {
    mavenCentral()
    mavenLocal()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("org.jsoup:jsoup:1.16.1")
    implementation("junit:junit:4.13.2")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("com.github.kittinunf.fuel:fuel:2.3.1")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:1.13.7")
    testImplementation("org.mockito:mockito-core:3.12.4")
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
    testImplementation("com.google.code.gson:gson:2.10.1")
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit:junit:4.13.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}
kotlin {
    jvmToolchain(17)
}
