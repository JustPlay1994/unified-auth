package com.justplay1994.github.unifiedauth.controller;

import com.justplay1994.github.unifiedauth.api.AuthenticationApi;
import com.justplay1994.github.unifiedauth.api.model.CaptchaModel;
import com.justplay1994.github.unifiedauth.api.model.TokenModel;
import com.justplay1994.github.unifiedauth.api.model.http.AuthResponseModel;
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

    @Override
    public AuthResponseModel<TokenModel> login(String username, String password, String captcha) {
        return null;
    }

    @Override
    public AuthResponseModel<Boolean> logout(String token) {
        return null;
    }

    @Override
    public AuthResponseModel<CaptchaModel> queryCaptcha() {
        return null;
    }

    @Override
    public AuthResponseModel<Boolean> validateToken(String token) {
        return null;
    }

    @Override
    public AuthResponseModel<TokenModel> refreshToken(String token) {
        return null;
    }
}
