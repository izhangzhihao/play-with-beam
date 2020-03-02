plugins {
    scala
    id ("cz.alenkacz.gradle.scalafmt") version "1.13.0"
    id ("org.scoverage") version "4.0.1"
}

repositories {
    mavenLocal()
    google()
    mavenCentral()
}

dependencies {
    implementation("org.scala-lang:scala-library:2.12.10")
    testImplementation("org.scalatest:scalatest_2.12:3.1.1")
    testImplementation("junit:junit:4.12")
}

scala {
    zincVersion.set("1.3.4")
}