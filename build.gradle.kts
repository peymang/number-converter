import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
    `maven-publish`
}

group = "com.github.peymang"
version = "v3.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.peymang"
            artifactId = "number-converter"
            version = "3.0"

            from(components["java"])
        }
    }
}