plugins {
    scala
    id("cz.alenkacz.gradle.scalafmt") version "1.13.0"
    id("org.scoverage") version "4.0.1"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

repositories {
    mavenLocal()
    google()
    mavenCentral()
}

dependencies {
    implementation("org.scala-lang:scala-library:2.12.10")
    implementation("org.apache.beam:beam-sdks-java-core:2.19.0")
    implementation("org.apache.beam:beam-runners-flink-1.9:2.19.0") {
        // taken from https://issues.apache.org/jira/browse/BEAM-7544?focusedCommentId=16863149&page=com.atlassian.jira.plugin.system.issuetabpanels%3Acomment-tabpanel#comment-16863149
        exclude(group = "org.apache.flink", module = "flink-clients_2.11")
        // flink-core is in Java, does not depend on the scalac ABI
        // flink-metrics-core is in Java, does not depend on the scalac ABI
        // flink-java is in Java, does not depend on the scalac ABI
        exclude(group = "org.apache.flink", module = "flink-runtime_2.11")
        exclude(group = "org.apache.flink", module = "flink-streaming-java_2.11")
    }
    implementation("org.apache.flink:flink-clients_2.12:1.9.2")
    implementation("org.apache.flink:flink-runtime_2.12:1.9.2")
    implementation("org.apache.flink:flink-streaming-java_2.12:1.9.2")
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

task("execute", JavaExec::class) {
    main = System.getProperty("mainClass")
    classpath = sourceSets["main"].runtimeClasspath
    @Suppress("UNCHECKED_CAST")
    systemProperties = System.getProperties().toMap() as Map<String, Any>
    args = System.getProperty("exec.args").split(" ")
}