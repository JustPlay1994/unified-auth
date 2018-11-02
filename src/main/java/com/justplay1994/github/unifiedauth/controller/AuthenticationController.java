package com.justplay1994.github.unifiedauth.controller;

import com.justplay1994.github.baseframework.http.HttpResponseModel;
import com.justplay1994.github.unifiedauth.api.AuthenticationApi;
import com.justplay1994.github.unifiedauth.api.model.CaptchaModel;
import com.justplay1994.github.unifiedauth.service.Impl.AuthenticationServiceImpl;
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

    @Autowired
    AuthenticationServiceImpl authenticationService;

    @Override
    public HttpResponseModel<String> login(String account, String password, String captcha) {
        return authenticationService.login(account, password, captcha);
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
        return null;
    }

    @Override
    public HttpResponseModel<String> refreshToken(String token) {
        return null;
    }
}
