package com.justplay1994.github.unifiedauth.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Package: com.justplay1994.github.unifiedauth.api.model
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/11/2 21:22
 * @Updater: huangzezhou
 * @Update_Date: 2018/11/2 21:22
 * @Update_Description: huangzezhou 补充
 **/
public class TokenModel {

    String token;       //令牌
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    Date expiration;    //有效期

    public TokenModel(){

    }

    public TokenModel(String token, Date expiration){
        this.token = token;
        this.expiration = expiration;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}
