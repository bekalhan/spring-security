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

## Spring Security Sequence Flow

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

Spring Security is a comprehensive security solution for Spring Framework projects, providing authentication and authorization mechanisms, HTTP security controls, protection against common web application attacks, session management, customizability, CSRF protection, and defense against DoS attacks. It offers a robust infrastructure to meet security requirements in Spring applications, enabling developers to secure their applications effectively.

<img width="1410" alt="2" src="https://github.com/bekalhan/spring-security/assets/77151270/f6026584-3733-49f8-a121-fe0d27e5d201">

## Spring Security 2 - Spring Default Config - UserDetailsService - AuthenticationProvider


Spring Security provides robust authentication and authorization mechanisms for Java applications. The UserDetailService interface is a core component used to load user-specific data during authentication. It allows developers to retrieve user details, such as username, password, and authorities, from various sources like databases or in-memory collections.

Default security configuration (defaultSecurityConfig) in Spring Security sets up sensible defaults for securing applications, reducing the initial configuration overhead. It simplifies the setup process by providing predefined configurations for common security scenarios while still allowing for customization.

AuthenticationProvider interface is pivotal in Spring Security as it authenticates users based on the provided credentials. Developers can implement this interface to integrate custom authentication mechanisms, such as LDAP or OAuth, into their applications.

Together, these components form the foundation of user authentication and authorization in Spring Security, enabling developers to build secure and reliable Java applications with ease.

<img width="622" alt="1" src="https://github.com/bekalhan/spring-security/assets/77151270/86bc3a3d-011e-499d-a74c-6a4a379669e8">


<img width="822" alt="2" src="https://github.com/bekalhan/spring-security/assets/77151270/b14f15db-003e-447d-aa42-8a480f3aa980">


<img width="751" alt="3" src="https://github.com/bekalhan/spring-security/assets/77151270/816b42ff-a71b-4bd2-ab2b-37efb45a653b">



## Spring Security 3 - Inmemory

In Spring Security, the InMemoryUserDetailsManager allows developers to define user details directly within the application's configuration. It's handy for small-scale applications or testing purposes, enabling quick setup of user credentials without an external user store like a database. However, it's best suited for simple scenarios due to scalability and persistence limitations.

<img width="985" alt="5" src="https://github.com/bekalhan/spring-security/assets/77151270/f7ba27cc-1c2c-4b2e-a266-42252c6ecbbe">


## Spring Security 4 - Basic Authentication

Spring Security is a powerful framework for implementing authentication, authorization, and other security features in Java applications. It provides robust mechanisms to secure applications against various threats, including authentication attacks and unauthorized access. With Spring Security, developers can easily configure security settings, define access control rules, and integrate with different authentication mechanisms like LDAP, OAuth, or database-based authentication. It offers flexibility, scalability, and comprehensive security features, making it a popular choice for securing Java applications across different domains and industries.

<img width="989" alt="5" src="https://github.com/bekalhan/spring-security/assets/77151270/a637aa63-c0d9-49c5-8f4e-acf880979c16">

## Spring Security 5 - CSRF Token

In Spring Security, CSRF (Cross-Site Request Forgery) protection is a crucial security feature aimed at preventing unauthorized actions initiated by malicious websites on behalf of authenticated users. When CSRF protection is enabled, Spring Security generates a unique token for each session and includes it in forms or AJAX requests. Upon submission, the server validates this token to ensure that the request originated from the expected user session, effectively thwarting CSRF attacks. This built-in mechanism helps safeguard web applications against common security threats, enhancing overall system security and protecting user data from unauthorized manipulation.

<img width="851" alt="1" src="https://github.com/bekalhan/spring-security/assets/77151270/2e3be76e-8076-4699-94f7-76e69b80879b">

## Spring Security 6 - Authorization

In Spring Security, authorization governs access to specific resources or functionalities within an application based on the roles and permissions assigned to users. This process involves determining whether a user is allowed to perform a particular action or access a certain part of the application. Spring Security provides a flexible and customizable authorization mechanism through role-based access control (RBAC), where permissions are associated with user roles, and method-level security, where access control is applied at the method level within application code. Developers can configure authorization rules using annotations, XML configuration, or programmatically, ensuring that only authorized users can perform authorized actions, thus enhancing the overall security posture of the application.

## Spring Security 7 - Custom Filter

In Spring Security, custom filters offer a powerful way to tailor the security behavior of an application to specific requirements. These filters allow developers to insert custom logic at various points in the request processing pipeline, such as before authentication or after authorization. By extending existing filter classes or implementing the javax.servlet.Filter interface, developers can define custom authentication mechanisms, perform additional security checks, or modify the behavior of standard security filters. This flexibility enables fine-grained control over the security flow, making it possible to implement complex security features or integrate with external systems seamlessly. Custom filters are a key feature of Spring Security, empowering developers to address diverse security challenges effectively within their applications.

## Spring Security 8 - Jwt Token 

<img width="991" alt="1" src="https://github.com/bekalhan/spring-security/assets/77151270/15f2029f-cd69-405a-bd14-45793a8c9bb0">



<img width="994" alt="2" src="https://github.com/bekalhan/spring-security/assets/77151270/48b447d7-00e5-45cb-8793-0f404f0ae90f">


<img width="1002" alt="3" src="https://github.com/bekalhan/spring-security/assets/77151270/ea04595a-ae60-46a8-8343-8ef4c0b99f00">

## Spring Security 9 - Jwt token With custom filter


A JSON Web Token (JWT) is a compact, URL-safe means of representing claims to be transferred between two parties. These claims are typically used to authenticate the identity of the user. JWTs are comprised of three parts: a header, a payload, and a signature. The header typically specifies the hashing algorithm being used, the payload contains the claims, and the signature is used to verify the authenticity of the token. JWTs are often used for stateless authentication in web applications, as they can securely transmit information between the client and server without the need for session storage. They are widely used in modern web development due to their simplicity, flexibility, and scalability.

<img width="863" alt="7" src="https://github.com/bekalhan/spring-security/assets/77151270/ac809c9a-e811-4468-8b0b-49bdf8a2ff8c">


## Roadmap Documentation

[doc.pdf](https://github.com/bekalhan/spring-security/files/14970507/doc.pdf)



