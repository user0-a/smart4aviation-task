plugins {
	java
	id("org.springframework.boot") version "3.1.4"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "smart4aviation"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.1.4")
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.4")

//	implementation("mysql:mysql-connector-java:8.0.33")

	implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")
	// https://mvnrepository.com/artifact/junit/junit
	testImplementation("junit:junit:4.13.2")



}

tasks.withType<Test> {
	useJUnitPlatform()
}
