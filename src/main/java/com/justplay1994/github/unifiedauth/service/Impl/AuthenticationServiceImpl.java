package com.justplay1994.github.unifiedauth.service.Impl;

import com.justplay1994.github.baseframework.http.HttpResponseModel;
import com.justplay1994.github.unifiedauth.api.model.http.AuthCode;
import com.justplay1994.github.unifiedauth.dao.UserDao;
import com.justplay1994.github.unifiedauth.dao.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @Package: com.justplay1994.github.unifiedauth.service.Impl
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/11/2 16:42
 * @Updater: huangzezhou
 * @Update_Date: 2018/11/2 16:42
 * @Update_Description: huangzezhou 补充
 **/
@Service
public class AuthenticationServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    UserDao userDao;

    @Autowired
    AuthCode authCode;

    @Autowired
    JwtServiceImpl jwtService;

    public HttpResponseModel<String> login(String account, String password, String captcha) {
        HttpResponseModel<String> result;
        //1.校验密码
        UserEntity userEntity = userDao.selectByAccount(account);
        if (!password.equals(userEntity.getPassword())){
            result = new HttpResponseModel<String>(
                    authCode.LOGIN_FAIL_CODE,
                    null
            );
            return result;
        }
        //TODO 2.验证验证码
        //3.生成token
        String token = null;
        try {
            token = jwtService.token(account);
        } catch (InterruptedException e) {
            logger.error("登录失败!"+userEntity);
            return new HttpResponseModel<String>(
                    authCode.LOGIN_FAIL_CODE,
                    e,
                    null
            );
        } catch (UnsupportedEncodingException e) {
            logger.error("登录失败!" + userEntity);
            return new HttpResponseModel<String>(
                    authCode.LOGIN_FAIL_CODE,
                    e,
                    null
            );
        }
        if (token!=null)
            return new HttpResponseModel<String>(authCode.SYS_SUCCESS_CODE, token);
        return new HttpResponseModel<String>();
    }
}