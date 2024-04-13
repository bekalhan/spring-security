package com.kalhan.springsecurity.dto;

import com.kalhan.springsecurity.model.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequest (
        String name,
        String username,
        String password,
        Set<Role> authorities
){
}
