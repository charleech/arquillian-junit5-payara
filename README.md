# arquillian-junit5-payara
The POC for Arquillian and JUnit5 with Payara

## How to execute

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

The **Maven Failsafe Plugin**  version `3.0.0-M5` does not play nicely with
**Payara Embedded All** since there are a failure.

The suspected error is during starting up the **Payara Embedded All** there is
a failure as the following: -

```
INFO: Network Listener JMS_PROXY_default_JMS_host started in: 2ms - bound to [/0.0.0.0:7676]
May 07, 2021 11:22:09 AM org.glassfish.hk2.classmodel.reflect.Parser awaitTermination
INFO: visiting unvisited references
May 07, 2021 11:22:09 AM org.glassfish.deployment.admin.DeployCommand execute
SEVERE: Illegal char <<> at index 43: 
    org\jboss\shrinkwrap\descriptor\api\Mutable<org\jboss\shrinkwrap\descriptor\api\Immutable<org\jboss\shrinkwrap\descriptor\api\Immutable>>.class
```

On the other hand the  **Maven Failsafe Plugin** version `3.0.0-M5` plays 
nicely with **Payara Microo** since all test are passed.

### My Environment

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
  * JUnit5 version `5.8.0-M1`
  * Payara version `5.2021.3`
  * Payara Aqrquillian Container version `2.4.1`
