package com.justplay1994.github.unifiedauth.controller;

import com.justplay1994.github.baseframework.http.HttpResponseModel;
import com.justplay1994.github.unifiedauth.api.AuthenticationApi;
import com.justplay1994.github.unifiedauth.api.model.CaptchaModel;
import com.justplay1994.github.unifiedauth.service.Impl.AuthenticationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.justplay1994.github.unifiedauth.controller
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/31 11:38
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 11:38
 * @Update_Description: huangzezhou 补充
 **/

@RestController
public class AuthenticationController implements AuthenticationApi{

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    AuthenticationServiceImpl authenticationService;

    @Override
    public HttpResponseModel<String> login(String account, String password, String captcha) {
        try {
            return authenticationService.login(account, password, captcha);
        }catch (Exception e){
            logger.error("login error", e);
            return new HttpResponseModel<String>();
        }
    }

    @Override
    public HttpResponseModel<Boolean> logout(String token) {
        return null;
    }

    @Override
    public HttpResponseModel<CaptchaModel> queryCaptcha() {
        return null;
    }

    @Override
    public HttpResponseModel<Boolean> validateToken(String token) {
        try {
            return authenticationService.validateToken(token);
        }catch (Exception e){
            return new HttpResponseModel<Boolean>();
        }
    }

    @Override
    public HttpResponseModel<String> refreshToken(String token) {
        return null;
    }
}
