# Java Quiz System

Lightweight Java console application for managing and running quizzes.

**Contents:**
- **Description:** Simple quiz management and runner implemented in Java with Gradle.
- **Build / Run:** Instructions to build and run locally using the Gradle wrapper.
- **Upload:** Commands to push this repo to GitHub.

## Prerequisites
- Java JDK 11 or later installed and `java` available on PATH.
- Git installed for pushing to GitHub.

## Build
From the project root on Windows (PowerShell or CMD):

```bash
.\gradlew clean build
```

This compiles sources and places class files under `build/classes/java/main`.

## Run
If the project defines a `run` task you can use:

```bash
.\gradlew run
```

Or run the main class directly using the compiled classes:

```bash
java -cp build/classes/java/main QuizSystem
```

Adjust the main class name if different (see `src/main/java`).

## Tests
If there are tests available, run:

```bash
.\gradlew test
```

## Prepare & Upload to GitHub
Create a new repository on GitHub (via the website or `gh`), then push:

```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo>.git
git push -u origin main
```

Or create & push in one step with the GitHub CLI:

```bash
gh repo create <repo> --public --source=. --remote=origin --push
```

## Files added
- [.gitignore](.gitignore)
- [README.md](README.md)

---
If you want, I can run the git commands here (you'll need to provide the GitHub remote URL or authenticate), or you can run them locally using the commands above.
