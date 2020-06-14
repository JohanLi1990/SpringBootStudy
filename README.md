# Spring Boot Notes

## 1. Spring Fundamentals

### 1.1. Beans

Dependency injections. Do not have to instantiate objects everywhere.

#### 1.1.1 Bean Configuration can be done via

+ XML
+ Annoatations
+ Java Bean COnfiguration
+ Groovy Bean Configuration

#### 1.1.2 Bean Scope

Singleton, Prototype, request, session, global session

#### 1.1.3. Dependency Injection

```java
// Property based injection
@Autowired
private NotificationServeice notif;

// Setter based injection
@Autowired
private void setNotificaiton(NotificationService n){
    this.notif = n;
}

// Constructor based injeciton
@Autowired
public theClassName className(Notification n){
    this.notif = n;
}
```

### 2.1. Application Properties and Application.yaml

+ Both can be used to configure values inside spring boot application.
+ use @Values("${variable name}") to define values.
+ ${} can be used as place holders too.

One can also use @Configuration Properties to give bunch of values to beans
for example

```java
// Omitted

@Component
@ConfigurationProperties(prefix = "myappconfig")
public class MyAppConfig {
 private String firstname;
 private String lastname;
 private String emailAddress;

// Omitted....
//
 @Override
 public String toString() {
  return "MyAppConfig [firstname=" + firstname + ", lastname=" + lastname + ", emailAddress=" + emailAddress + "]";
 }
}

```

### 2.2. Auto Configuration

@SpringBootApplication =  @EnableAutoConfiguration + @Configuration + @ComponentScan

## 2. Spring Web Application

Spring MVC patterns
> we can load htmls, css, inside static folder
> we can implement templates in template folder
> rest controller always writes to the page
> controller looks for the view to to return to page

### 2.1 Static Contents

do not put in the src/main/webapp folder, if you put it there, it cannot be built as jar

easiest way is to use webjar dependencies from maven, and call bootstrap / jquery from html
