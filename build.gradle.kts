plugins {
    kotlin("jvm") version "1.9.21"
    application /*追記*/
    id("com.github.johnrengelman.shadow") version "7.0.0" /*追記*/
}

group = "com.github.yutarou12"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://m2.dv8tion.net/releases") /*追記*/
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    implementation("net.dv8tion:JDA:5.0.0-beta.23") /*追記*/
}

application {/*applicationブロックごと追記*/
    mainClass.set("${group}.${rootProject.name}.MainKt")
    /*pluginブロック内のapplicationと同時に書いた場合ブロックに警告が出ますが続行してください。*/
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}