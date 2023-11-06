package com.token.example;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;;import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;

public class JwtExample {


    private static String SECRET_KEY = "I'm cool";

    public static void main(String[] args){

        Map<String,Object> customClaims = new HashMap<>();
        customClaims.put("emailId", "e@gmail.com");

        //create a JWT
        String jwtToken = createJWT("Ashish",customClaims);

        //print JWT
        System.out.println("jwtToken-token : " + jwtToken);

        //parse and then verify the JWT
        Claims claims = parseJWT(jwtToken);

        System.out.println("claims : " + claims);

        System.out.println("subject : " + claims.getSubject());
        System.out.println("email : " + claims.get("emailId"));



        Map<String, Object> parsedClaims = getClaims(jwtToken);
        System.out.println("parsedClaims : " + parsedClaims);





    }


    private static  String createJWT(String subject,   Map<String,Object> claims){
        return Jwts.builder()
                .setSubject(subject)
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + 3600))
                .setIssuedAt(new Date())
                .compact();
    }

    public static Claims parseJWT(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public static Map<String, Object> getClaims(String token){

      Jwt parse =   Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parse(token);

        Map<String, Object> claims  = (Map<String, Object>) parse.getBody();
        return claims;
    }


    public static Object getClaims(String token, String key){

        Jwt parse =   Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parse(token);

        Map<String, Object> claims  = (Map<String, Object>) parse.getBody();
        return claims.get(key);
    }


    public static String getEmailId(){

    }




}
