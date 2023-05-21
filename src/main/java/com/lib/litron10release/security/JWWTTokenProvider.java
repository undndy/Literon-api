package com.lib.litron10release.security;

import com.lib.litron10release.entity.UserLiter;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWWTTokenProvider {
    public static final Logger LOG = LoggerFactory.getLogger(JWWTTokenProvider.class);

    public String generateToken(Authentication authentication){
        UserLiter userLiter = (UserLiter) authentication.getPrincipal();
        Date date = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(date.getTime() + SecurityConstants.EXPIRATION_TIME);

        String userId = Long.toString(userLiter.getId());

        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("id", userId);
        claimsMap.put("firstName", userLiter.getFirstName());
        claimsMap.put("lastName", userLiter.getLastName());

        return Jwts.builder()
                .setSubject(userId)
                .addClaims(claimsMap)
                .setIssuedAt(date)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET)
                    .parseClaimsJws(token);
            return true;
        }catch (SignatureException |
                MalformedJwtException |
                ExpiredJwtException |
                UnsupportedJwtException |
                IllegalArgumentException exception){
            LOG.error(exception.getMessage());
            return false;
        }
    }

    public Long getUserIdFromToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
                .parseClaimsJws(token)
                .getBody();
        String id = (String) claims.get("id");
        return Long.parseLong(id);
    }
}
