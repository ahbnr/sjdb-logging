import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // id("com.github.johnrengelman.shadow") version "7.1.0"
    kotlin("jvm") version "1.5.31"
    `java-library`
}

group = "de.ahbnr.semanticweb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

// tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
//     archiveBaseName.set("Logging")
//     mergeServiceFiles()
// }

// tasks {
//     build {
//         dependsOn(shadowJar)
//     }
// }

tasks.withType<JavaCompile>() {
    sourceCompatibility = "11"
    targetCompatibility = "11"
}

tasks.withType<KotlinCompile>() {
    sourceCompatibility = "11"
    targetCompatibility = "11"

    kotlinOptions.jvmTarget = "11"
}

tasks.jar {
    manifest {
        attributes(
            mapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version
            )
        )
    }
}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}