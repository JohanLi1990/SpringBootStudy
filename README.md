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
