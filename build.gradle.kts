import org.gradle.kotlin.dsl.test

plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies { testImplementation("org.testng:testng:7.12.0") }

tasks.test(Test::useTestNG)