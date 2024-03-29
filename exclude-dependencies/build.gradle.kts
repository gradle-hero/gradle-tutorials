plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.5")
    implementation("org.springframework.boot:spring-boot-starter-log4j2:3.1.5")
}

configurations.implementation {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
}

application {
    mainClass = "com.tomgregory.LoggingExample"
}