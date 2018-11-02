package com.justplay1994.github.unifiedauth.service.Impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @Package: com.justplay1994.github.unifiedauth.service
 * @Project: unified-auth
 * @Description: //jwt服务，处理jwt相关逻辑
 * @Creator: huangzezhou
 * @Create_Date: 2018/11/1 14:33
 * @Updater: huangzezhou
 * @Update_Date: 2018/11/1 14:33
 * @Update_Description: huangzezhou 补充
 **/
@Service
public class JwtServiceImpl {

    private static final String serverSecret = UUID.randomUUID().toString();

    public boolean validateToken(String token) throws UnsupportedEncodingException {
        SecretKeySpec keySpec = new SecretKeySpec(serverSecret.getBytes("UTF-8"), "HmacSHA256");
        Jwts.parser().setSigningKey(keySpec).parseClaimsJws(token);
        return true;
    }

    /**
     * 解码token (Jws: JSON Web Token)
     * @return
     * @throws NoSuchAlgorithmException
     */
    public Jws<Claims> decodeJws(String token) throws UnsupportedEncodingException {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(serverSecret.getBytes("UTF-8"), "HmacSHA256");
            return Jwts.parser().setSigningKey(keySpec).parseClaimsJws(token);
        } catch (JwtException e) {
            return null;    //正常逻辑，token校验失败，该方法直接处理。
        }
    }

    /**
     * token的产生逻辑
     */
    public String token(String account) throws UnsupportedEncodingException, InterruptedException {
        SecretKeySpec keySpec = new SecretKeySpec(serverSecret.getBytes("UTF-8"), "HmacSHA256");
        //有效期设置为第二天的凌晨2点
        Calendar c = Calendar.getInstance();
        c.set(c.YEAR, c.MONTH+1, c.DAY_OF_MONTH+1, 2, 0);
        return Jwts.builder()
                .setIssuer("CETC")  //签发人
                .setSubject(account)    //客体-被校验的用户
                .setAudience("CETC ") //接收token方
                .setExpiration(c.getTime()) //有效期至该时间
                .setIssuedAt(new Date())
                .setId(String.valueOf(UUID.randomUUID()))
                .signWith(keySpec).compact();
    }

}
