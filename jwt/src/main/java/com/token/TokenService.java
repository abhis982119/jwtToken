package com.token;

import com.token.example.JwtExample;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TokenService {





    public void validateToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBc2hpc2giLCJlbWFpbElkIjoiZUBnbWFpbC5jb20iLCJleHAiOjE2OTkxNzY4MDksImlhdCI6MTY5OTE3NjgwNX0.IJl0bjfBsGksw4qN7rLZJDIVJqYb30V5WhCwdBCh1cs";
        Map<String, Object>  claims =  JwtExample.getClaims(token);

        System.out.println("email : " + claims.get("email") );
    }
}
