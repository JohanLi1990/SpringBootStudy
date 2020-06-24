# Spring Boot Notes

## 1. Spring Fundamentals

### Beans

Dependency injections. Do not have to instantiate objects everywhere.

#### Bean Configuration can be done via

+ XML
+ Annoatations
+ Java Bean COnfiguration
+ Groovy Bean Configuration

#### Bean Scope

Singleton, Prototype, request, session, global session

#### Dependency Injection

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

### Application Properties and Application.yaml

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

### Auto Configuration

@SpringBootApplication =  @EnableAutoConfiguration + @Configuration + @ComponentScan

## 2. Spring Web Application

Spring MVC patterns
> we can load htmls, css, inside static folder
> we can implement templates in template folder
> rest controller always writes to the page
> controller looks for the view to to return to page

### Static Contents

> do not put in the src/main/webapp folder, if you put it there, it cannot be built as jar
> easiest way is to use webjar dependencies from maven, and call bootstrap / jquery from html
> useful tools include bower and grunt

### Template Engines (add Dynamic Content)

ThymeLeaf and GSP (Groovy Server Pages)
Dynamically generate static content with Http Request.
GSP offers great tags.

internationalization (i18n)

### Error and exception Handling

dedicated page for handling errors, you can customize errors.

```java
@Controller
public class CustomErrorController implements ErrorController {
 private static final String ERROR_PATH = "/error";
 private static final String ERROR_TEMPLATE = "customeError";
 private final ErrorAttributes errorAttributes;

 @Autowired
 public CustomErrorController(ErrorAttributes errorAttributes) {
  this.errorAttributes = errorAttributes;
 }

 @RequestMapping(ERROR_PATH)
 public String error(Model model,HttpServletRequest request) {
  
  // {error={timestamp=Mon Nov 02 12:40:50 EST 2015, status=404, error=Not Found, message=No message available, path=/foo}}
  Map<String,Object> error = getErrorAttributes(request, true);
  model.addAttribute("timestamp", error.get("timestamp"));
  return ERROR_TEMPLATE;
 }

 private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
  WebRequest requestAttributes = new ServletWebRequest(request);
  return this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
 }

}
```

Use global exception handler, for best practices. use @ControllerAdvice

### Chapter Summary

> How to generate dynamic content with static html (use webjar to incldue bootstrap and jquery)
> how to use templates to achieve dynamic content generation (ThymeLeaf, GSP)
> How to handle errors and exception(ControllerAdvice)

## 3. Data Access with Spring Boot

### h2 database JPA setup

nothing fancy here, standard maven dependency
note the JDBC is in memory JDBC.

Flag model as JPA persistent, @Engtity
> we can use annotations to create table in the database straightaway (via hibernate)
> we cab do CRUD, use **crud repository** interface

### how to laod data into repository

sql data types can be defined in JPA (TEXT, VARCHAR....)
> use sql script in resource folder to load data
> or use postConstruct to load data in @Service modules.
