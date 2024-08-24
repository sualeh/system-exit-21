# Illustrate differences in `System.exit(...)` in Java 21 versus Java 8

In Java 8, it is possible (easy enough) to substitute a custom security manager which can capture system exit calls, and allow code to continue executing. Java 21 makes this more difficult. However, this can cause a problem for systems that are being upgraded from Java 8 to Java 21, since processes can sometimes fail without any exceptions or logs. Tracing the source of the error can be difficult.

This project boils the problem down to essentials. Look at the results for the GitHub Actions workflows in Java 8 and Java 21 to see how it might be to locate the source of the error in a complex system.
