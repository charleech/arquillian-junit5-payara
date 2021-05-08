# arquillian-junit5-payara
The POC for Arquillian and JUnit5 with Payara

## How to execute

* Install the `parent pom`

```bash
cd path/to/arquillian-junit5-payara

mvn clean install -N
```

* Then change directory to each `sub module`

```
cd path/to/arquillian-junit5-payara/<submodule>

# e.g.
# cd path/to/arquillian-junit5-payara/my-cdi-junit5

```

* Execute with `Payara Embedded All`

```bash
mvn clean install -Dpayara-embedded=true
```

* Execute with `Payara Micro`

```bash
mvn clean install -Dpayara-micro=true
```

## What does this project focus?

* Try to use the **JUnit5** with **JBoss Arquillian** and **Payara** 
(embedded-all and micro)

### The arquillian-junit5-payara/my-cdi-junit4 

It is a baseline which is a current implementation with **JUnit4** and 
**Maven Failsafe Plugin** version `2.22.2`.

### The arquillian-junit5-payara/my-cdi-junit5 

It is a newly implementation by using **JUnit5** and **Maven Failsafe Plugin** 
version `3.0.0-M5`.

## The problem

### 1. The Payara Embeded All with JUnit5 and Arquillian

The **Maven Failsafe Plugin**  version `3.0.0-M5` does not play nicely with
**Payara Embedded All** since there are a failure.

The suspected error is during starting up the **Payara Embedded All** there is
a failure as the following: -

#### 1.1 How to execute

```
cd path/to/arquillian-junit5-payara

mvn clean install -N

cd path/to/arquillian-junit5-payara/my-cdi-junit5

mvn clean install -Dpayara-embedded=true

INFO: Network Listener JMS_PROXY_default_JMS_host started in: 2ms - bound to [/0.0.0.0:7676]
May 07, 2021 11:22:09 AM org.glassfish.hk2.classmodel.reflect.Parser awaitTermination
INFO: visiting unvisited references
May 07, 2021 11:22:09 AM org.glassfish.deployment.admin.DeployCommand execute
SEVERE: Illegal char <<> at index 43: 
    org\jboss\shrinkwrap\descriptor\api\Mutable<org\jboss\shrinkwrap\descriptor\api\Immutable<org\jboss\shrinkwrap\descriptor\api\Immutable>>.class
```

On the other hand the  **Maven Failsafe Plugin** version `3.0.0-M5` plays 
nicely with **Payara Microo** since all test are passed.

#### 1.2 My Environment

* OS: Windows 10 Home Edition 64 Bits
* JDK: AdoptOpenJDK-11.0.11+9

```
openjdk version "11.0.11" 2021-04-20
OpenJDK Runtime Environment AdoptOpenJDK-11.0.11+9 (build 11.0.11+9)
OpenJDK 64-Bit Server VM AdoptOpenJDK-11.0.11+9 (build 11.0.11+9, mixed mode)
```

* Build Tools: Apache Maven 3.8.1

```
Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
Maven home: C:\Java.Application\Apache\apache-maven\bin\..
Java version: 11.0.11, vendor: AdoptOpenJDK, runtime: C:\Java.Application\Sun\Java\jdk-11.0.11
Default locale: en_US, platform encoding: UTF-8
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

* Dependencies
  * Arquillian version `1.7.0.Alpha9`
  * Arquillian Suite Extension version `1.2.2`
  * JUnit4 version `4.13.2`
  * JUnit5 version `5.8.0-M1`
  * JUnit5 Platform version `1.8.0-M1`
  * Payara version `5.2021.3`
  * Payara Aqrquillian Container version `2.4.1`

### 2. The Arquillian-Suite-Extension with JUnit 5 `@RunWith(JUnitPlatform.class)`

Since the **JUnit5** does not have the `Test Suite` and provide the interim solution by
the `JUnitPlatform` which requires the `junit:junit:4.13.2` in the classpath.

* [Using JUnit 4 to run the JUnit Platform](https://junit.org/junit5/docs/current/user-guide/)
* [Using JUnit 4 to run the JUnit Platform: Test Suite](https://junit.org/junit5/docs/current/user-guide/#running-tests-junit-platform-runner-test-suite)

By using it, it causes the **Arquillian-Suite-Extension** to deploy multiple times 
(each time for each test suite) !


#### 2.1 How to execute

#### 2.1.1 The multiple tester without test suite

```
cd path/to/arquillian-junit5-payara

mvn clean install -N

cd path/to/arquillian-junit5-payara/my-cdi-junit5-multiple-tester

mvn clean install -Dpayara-embedded=true

#
# Everything works fine !
#
# It is a pure JUnit 5 without any dependency to JUnit4 and 
# JUnit 5 Platform.
#
```

#### 2.1.2 The multiple test suite

```
cd path/to/arquillian-junit5-payara

mvn clean install -N

cd path/to/arquillian-junit5-payara/my-cdi-junit5-multiple-testsuite

mvn clean install -Dpayara-embedded=true

#
# Only first executed test suite success, all the rest are failed
#
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 28.145 s - in it.test.app.github.charleech.my.cdi.MyCdiJunit5IntgrtnTestSuite

#
# The second test suite case re-deployment !
#
# ... Could not setup GlassFish Embedded Bootstrap
# ... Already bootstrapped
# ...
# ... Could not setup GlassFish Embedded Bootstrap
#
[INFO] Running it.test.app.github.charleech.my.cdi.MyCdiJunit5Round2IntgrtnTestSuite
May 08, 2021 1:47:43 PM org.eu.ingwar.tools.arquillian.extension.suite.DeploymentClassFinder getDeploymentClassFromAnnotation
INFO: arquillian-suite-deployment: Found class annotated with @ArquillianSuiteDeployment: it.test.app.github.charleech.my.cdi.ArquillianSuiteDeployments
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.016 s <<< FAILURE! - in it.test.app.github.charleech.my.cdi.MyCdiJunit5Round2IntgrtnTestSuite
[ERROR] MyCdiJunit5IntgrtnTester  Time elapsed: 0.015 s  <<< ERROR!
java.lang.RuntimeException: Could not setup GlassFish Embedded Bootstrap
Caused by: org.glassfish.embeddable.GlassFishException: Already bootstrapped

[ERROR] Picked up JAVA_TOOL_OPTIONS: -Dfile.encoding=UTF-8
[ERROR] OpenJDK 64-Bit Server VM warning: ignoring option MaxPermSize=256m; support was removed in 8.0
[INFO]
[INFO] Results:
[INFO]
[ERROR] Errors:
[ERROR]   Could not setup GlassFish Embedded Bootstrap
[INFO]
[ERROR] Tests run: 3, Failures: 0, Errors: 1, Skipped: 0
```

#### 2.1.3 My Environment

* OS: Windows 10 Home Edition 64 Bits
* JDK: AdoptOpenJDK 1.8.0_292

```
openjdk version "1.8.0_292"
OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_292-b10)
OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.292-b10, mixed mode)
```

* Build Tools: Apache Maven 3.8.1

```
Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
Maven home: C:\Java.Application\Apache\apache-maven\bin\..
Java version: 1.8.0_292, vendor: AdoptOpenJDK, runtime: C:\Java.Application\Sun\Java\jdk8u292-b10\jre
Default locale: en_US, platform encoding: UTF-8
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

* Dependencies
  * Arquillian version `1.7.0.Alpha9`
  * Arquillian Suite Extension version `1.2.2`
  * JUnit4 version `4.13.2`
  * JUnit5 version `5.8.0-M1`
  * JUnit5 Platform version `1.8.0-M1`
  * Payara version `5.2021.3`
  * Payara Aqrquillian Container version `2.4.1`
