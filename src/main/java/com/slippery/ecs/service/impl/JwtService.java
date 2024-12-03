package com.slippery.ecs.service.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    public SecretKey generateSecretKey(){
        String SECRETSTRING = "c7a05abf73533c64fa7fbd5dea7a26be366747eb71b12c60a6d727f4c831a87657650bbb9e8a2cc900e208b97ec4f1d25be6184975c9fc3166eafc9686308a7d3738e1530358554f6a9741c6727a06ab7b88f53c0a26537d089074ec3704d02f640025209049eb3a565669527c94ebf11ecf8447e2c3a47d2791b5175ee37e27d88f23219457c924fe0cee6dfaf2b0e16498b1e805e0854ec1012851af33368401a05e6e95f62b8db53011d56b71e9b53feb77018f8c7b2ef3e7cab93e1eba0a6131a33092ff50eb41f570559529e2f6cb9944eec7e0164729e7364cf8c8ff595dda601006ed788784d6a2fd2da13fa6d045922b676c33595027c8ee7e84b2c8";
        byte[] keyBytes = Base64.getDecoder().decode(SECRETSTRING);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String generateJwtToken(String username){
        Map<String,Object> claims =new HashMap<>();
        long EXPIRATIONTIME = 86_400_000L;
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ EXPIRATIONTIME))
                .and()
                .signWith(generateSecretKey())
                .compact();
    }
}
