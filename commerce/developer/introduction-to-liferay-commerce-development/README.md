# Introduction to Liferay Commerce Development

## What You Need

* JDK 1.8+
* Docker
* Gradle

## Create the Basic Project Directory Structure

In a project directory of your choosing, create the following subdirectory structure; for example, with `mkdir -p src/main/java/hello` on *nix systems:

```bash
    └── src
        └── main
            └── java
                └── hello
```

## Create a Gradle build file

Below is the initial `build.gradle` file:

```gradle
buildscript {
	dependencies {
		classpath group: "com.liferay", name: "com.liferay.gradle.plugins.defaults", version: "latest.release"
	}

	repositories {
		mavenLocal()

		maven {
			url "https://repository-cdn.liferay.com/nexus/content/groups/public"
		}
	}
}

apply plugin: "com.liferay.root.defaults.plugin"
```
