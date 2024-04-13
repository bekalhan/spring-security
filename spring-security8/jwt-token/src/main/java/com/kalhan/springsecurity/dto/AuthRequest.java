package com.kalhan.springsecurity.dto;

public record AuthRequest (
        String username,
        String password
){
}
