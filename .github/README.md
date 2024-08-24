# System Exit 21

> Illustrate differences in `System.exit(...)` in Java 21 versus Java 8

In Java 8, it is possible (easy enough) to substitute a custom security manager which can capture system exit calls, and allow code to continue executing. Java 21 makes this more difficult. However, this can cause a problem for systems that are being upgraded from Java 8 to Java 21, since processes can sometimes fail without any exceptions or logs. Tracing the source of the error can be difficult.

This project boils the problem down to essentials. We have a simple Java class that calls `System.exit(...)`, which in turn is invoked by Apache Ant. On Java 8, Ant intercepts `System.exit(...)` and the build completes. On Java 21 though, `System.exit(...)` is not intercepted, resulting in a terminated build with no logs or exceptions. Now imagine if this was your system, and it was not Ant, but a web application. Imagine that the `System.exit(...)` call was converted to a runtime exception, and caught, so that the service kept on running in Java 8. In Java 21 you would get an unexpected termination.

Look at the results for the [GitHub Actions workflows](https://github.com/sualeh/system-exit-21/actions) in Java 8 and Java 21 to see how it might be to locate the source of the error in a complex system. Compare how the build completes in Java 8 (but not so in Java 21) with:
```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
```
