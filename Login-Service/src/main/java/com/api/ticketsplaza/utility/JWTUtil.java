package com.api.ticketsplaza.utility;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil  {
	
	@Value("${jwt.secretkey}")
	String secretKey;
	int jwtExpirationms = 3600000;
	public String generateToken(String userName) {
		return Jwts.builder()
				.setSubject(userName)
				.setExpiration(new Date(System.currentTimeMillis()+jwtExpirationms))
				.setIssuedAt(new Date())
				.signWith(key())
				.compact();
	}
	
	 private Key key(){
	        return Keys.hmacShaKeyFor(
	                Decoders.BASE64.decode(secretKey)
	        );
	    }
	

}
