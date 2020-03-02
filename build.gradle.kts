plugins {
    scala
    id ("cz.alenkacz.gradle.scalafmt") version "1.13.0"
    id ("org.scoverage") version "4.0.1"
    id ("com.github.johnrengelman.shadow") version "5.2.0"
}

repositories {
    mavenLocal()
    google()
    mavenCentral()
}

dependencies {
    implementation("org.scala-lang:scala-library:2.12.10")
    implementation("org.apache.beam:beam-sdks-java-core:2.19.0")
    implementation("org.apache.beam:beam-runners-flink-1.9:2.19.0")
    testImplementation("org.scalatest:scalatest_2.12:3.1.1")
    testImplementation("junit:junit:4.12")
}

scala {
    zincVersion.set("1.3.4")
}

tasks {
    named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
        manifest {
            attributes(mapOf("Main-Class" to "com.github.izhangzhihao.WordCount"))
        }
    }
}