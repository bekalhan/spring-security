# Spring Security

## What is Spring Security?

Security is for protecting your data and business logic inside your web applications.

## Different Types of Security

Security for web applications will be implementing in different way like using firewalls,HTTPS,SSL,Authentication,Authorizations etc.

## Why Security Important?

Security does not mean only losing data or money but also brand and trust from your users which you have built over years.

## Avoiding Most Common Atack

Using security we should also avoid most common security attacks like CSRF, broken Authentication inside your application.

## Without Spring Security

When we are not using Spring Security, the request is intercepted by the DispatcherServlet. The DispatcherServlet is the front controller which intercepts any HTTP Request and forwards it to the right controller. Spring Boot automatically configures the DispatcherServlet.

<img width="672" alt="1" src="https://github.com/bekalhan/spring-security/assets/77151270/add307e7-7f3c-4e89-9a50-fb9c2d46f3f2">

## With Spring Security

When Spring Security is added to the Spring Boot Application, all the request is intercepted by the Spring Security mechanism before it reaches DispatcherServlet and controller.
Whenever a request arrives at the application, it is first intercepted by a chain of filters called Filter Chain. Other than the filters provided by Spring Security, we can add our own custom filters. The FilterChain after authentication, forwards the request to the DisptacherServlet.

<img width="654" alt="2" src="https://github.com/bekalhan/spring-security/assets/77151270/4ccd9b40-d80a-403a-9a71-006ca9212494">

## Spring Security Internal Flow

<img width="1034" alt="3" src="https://github.com/bekalhan/spring-security/assets/77151270/e3cc9e12-5184-4e26-91a6-209d2066cf05">

<img width="968" alt="4" src="https://github.com/bekalhan/spring-security/assets/77151270/f35c95d9-6440-45d9-ac32-f677c5f98ba5">

##Spring Security Sequence Flow

<img width="1032" alt="5" src="https://github.com/bekalhan/spring-security/assets/77151270/26ffc11b-cf6c-4f5f-ad82-bb79bb4fab3e">

<img width="1046" alt="6" src="https://github.com/bekalhan/spring-security/assets/77151270/54934906-1a84-4c62-8021-ee35f16502bf">

## Contents

- [Spring Security 1 - Default Security](#spring-security-1---default-security)
- [Spring Security 2 - Spring Default Config - UserDetailsService - AuthenticationProvider](#spring-security-2---spring-default-config---userdetailsservice---authenticationprovider)
- [Spring Security 3 - In-Memory Authentication in Spring Security](#spring-security-3---in-memory-authentication-in-spring-security)
- [Spring Security 4 - Basic Authentication in Spring Security](#spring-security-4---basic-authentication-in-spring-security)
- [Spring Security 5 - CSRF Configuration in Spring Security](#spring-security-5---csrf-configuration-in-spring-security)
- [Spring Security 6 - Authorization in Spring Security](#spring-security-6---authorization-in-spring-security)
- [Spring Security 7 - Custom Filters in Spring Security](#spring-security-7---custom-filters-in-spring-security)
- [Spring Security 8 - JWT Configuration in Spring Security](#spring-security-8---jwt-configuration-in-spring-security)
- [Spring Security 9 - JWT Configuration with Spring Security](#spring-security-9---jwt-configuration-with-spring-security)

## Spring Security 1 - Default Security

This section covers default security configurations in Spring Security.

[//]: # (Add screenshot here)

## Spring Security 2 - Spring Default Config - UserDetailsService - AuthenticationProvider

This section covers Spring's default configurations, UserDetailsService, and AuthenticationProvider in Spring Security.

[//]: # (Add screenshot here)

...

