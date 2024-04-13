package com.kalhan.springsecurity.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;


@Data
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    //UserDetailsden implemnte edilirse securityContext içerisine alınır ve spring securityden gelindiği bilinir
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;

    private boolean accountNonExpired;
    private boolean isEnabled;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER) //users tablosuyla ilişkili ayrı bir tabloda role classını tut
    @JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id")) //tablonun adı ne olacağı ve hangi alanla ilişkilendirileceği
    @Column(name = "role", nullable = false) //authorities tablosunda role columnu olacak ve null olmayacak
    @Enumerated(EnumType.STRING) // karakter dizisi olarak saklanacak
    private Set<Role> authorities;
}
