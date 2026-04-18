
# ReadIT — Quick run

Prereq: Java JDK installed (`javac` + `java` on PATH).

From the project root (the folder that contains `src/`):

Build (compile):

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
```

Run CLI:

```bash
java -cp out cli.LibraryCLI
```

Run GUI:

```bash
java -cp out gui.MainGui
```

Quick troubleshooting:

- If you get "Could not find or load main class", try running from the `src` classpath:

```bash
java -cp src cli.LibraryCLI
```