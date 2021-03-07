import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31"
    application
}

object Versions {
    const val JACKSON = "2.12.1"
}

group = "me.nick252"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

with(Versions){
    dependencies {
        implementation("com.fasterxml.jackson.core:jackson-core:$JACKSON")
        implementation("com.fasterxml.jackson.core:jackson-databind:$JACKSON")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$JACKSON")
        implementation("org.java-websocket:Java-WebSocket:1.5.1")
        testImplementation(kotlin("test-junit"))
    }
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}