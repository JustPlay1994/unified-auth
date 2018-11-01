package com.justplay1994.github.unifiedauth;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * @Package: com.justplay1994.github.unifiedauth
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/31 12:01
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 12:01
 * @Update_Description: huangzezhou 补充
 **/

/**
 * HEADER:
 * {
 * "alg": "HS256",
 * "typ": "JWT"
 * }
 * PAYLOAD:
 * {
 * "sub": "1234567890",
 * "name": "John Doe",
 * "iat": 1516239022
 * }
 * VERIFY SIGNATURE:
 * HMACSHA256(
 * base64UrlEncode(header) + "." +
 * base64UrlEncode(payload),
 * <p/>
 * your-256-bit-secret
 * <p/>
 * ) secret base64 encoded
 */

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = UnifiedAuthApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JwtTest {

    @Test
    public void produceJwtHmacSHA256Test() throws UnsupportedEncodingException {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        byte[] b = new byte[32];
        SecretKeySpec keySpec = new SecretKeySpec(b, "HmacSHA256");
        String jws = Jwts.builder().setSubject("Joe").signWith(keySpec).compact();
        System.out.println("key:\n" + Base64.getEncoder().encode(keySpec.getEncoded()));
        System.out.println("jwt:\n" + jws);
    }

    @Test
    public void validateJwtHmacSHA256Test() throws NoSuchAlgorithmException {
        String jws = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifQ.xzeFbcloO8WFiNntIpxGN08hIHU53YW4YBOg5i0P6HE";
        byte[] b = new byte[32];
        SecretKeySpec keySpec = new SecretKeySpec(b, "HmacSHA256");
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(keySpec).parseClaimsJws(jws);
            System.out.println(claimsJws.getHeader());
            System.out.println(claimsJws.getBody());
            System.out.println(claimsJws.getSignature());
            //OK, we can trust this JWT
            System.out.println("\n\ntrue!!!\n\n");
        } catch (JwtException e) {
            //don't trust the JWT!
            System.out.println("\n\nfalse!!!\n\n");
        }
    }


    @Test
    public void jwtExpirationTest() throws UnsupportedEncodingException, InterruptedException {
        byte[] b = new byte[32];
        SecretKeySpec keySpec = new SecretKeySpec(b, "HmacSHA256");
        String jws = Jwts.builder()
                .setIssuer("me")
                .setSubject("Bob")
                .setAudience("you")
                .setExpiration(new Date(new Date().getTime()+7000)) //a java.util.Date ,有效期至该时间
                .setNotBefore(new Date(new Date().getTime()+3000)) //a java.util.Date ,在这个时间之前，不受理
                .setIssuedAt(new Date()) // for example, now
                .setId(String.valueOf(UUID.randomUUID())) //just an example id
        .signWith(keySpec).compact();

        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(keySpec).parseClaimsJws(jws);
            System.out.println(claimsJws.getHeader());
            System.out.println(claimsJws.getBody());
            System.out.println(claimsJws.getSignature());
            //OK, we can trust this JWT
            System.out.println("\n\ntrue!!!\n\n");
        } catch (JwtException e) {
            //don't trust the JWT!
            System.out.println("\n\nfalse!!!\n\n");
            System.out.println(e);
        }

        System.out.println("I will sleep 3 s!");
        Thread.sleep(3000);
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(keySpec).parseClaimsJws(jws);
            System.out.println(claimsJws.getHeader());
            System.out.println(claimsJws.getBody());
            System.out.println(claimsJws.getSignature());
            //OK, we can trust this JWT
            System.out.println("\n\ntrue!!!\n\n");
        } catch (JwtException e) {
            //don't trust the JWT!
            System.out.println("\n\nfalse!!!\n\n");
            System.out.println(e);
        }

        System.out.println("I will sleep 4 s!");
        Thread.sleep(4000);
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(keySpec).parseClaimsJws(jws);
            System.out.println(claimsJws.getHeader());
            System.out.println(claimsJws.getBody());
            System.out.println(claimsJws.getSignature());
            //OK, we can trust this JWT
            System.out.println("\n\ntrue!!!\n\n");
        } catch (JwtException e) {
            //don't trust the JWT!
            System.out.println("\n\nfalse!!!\n\n");
            System.out.println(e);
        }

    }
}
