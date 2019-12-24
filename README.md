# Single Maven Module Quarkus project
Project to reproduce found issues eliminating the unnecessary complexity.

### Describe the issue:
No issues.


### To reproduce the issue

1) mvn install

Check that tests will fail with the following error:

```
[ERROR] Tests run: 2, Failures: 0, Errors: 2, Skipped: 0, Time elapsed: 3.816 s <<< FAILURE! - in org.acme.ExampleResourceTest
[ERROR] testHelloEndpoint  Time elapsed: 0.01 s  <<< ERROR!
org.junit.jupiter.api.extension.TestInstantiationException: TestInstanceFactory [io.quarkus.test.junit.QuarkusTestExtension] failed to instantiate test class [org.acme.ExampleResourceTest]
Caused by: java.lang.ExceptionInInitializerError
Caused by: java.lang.RuntimeException: Failed to start quarkus
Caused by: java.lang.RuntimeException: Failed to initialize Arc
Caused by: java.lang.ClassFormatError: Duplicate method name "listAll" with signature "()Ljava.util.List;" in class file org/acme/ExampleRepository
```

### Running the project:

1) mvn compile

2) mvn quarkus:dev

3) Check webservices on http://0.0.0.0:8080/swagger-ui 



