package com.justplay1994.github.unifiedauth.controller;

import com.justplay1994.github.unifiedauth.api.AuthorizationApi;
import com.justplay1994.github.unifiedauth.api.model.TokenModel;
import com.justplay1994.github.unifiedauth.api.model.http.AuthResponseModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.justplay1994.github.unifiedauth.controller
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/31 15:00
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 15:00
 * @Update_Description: huangzezhou 补充
 **/
@RestController
public class AuthorizationController implements AuthorizationApi {
    @Override
    public AuthResponseModel<Boolean> validatePermission(String token, String[] permissions) {
        return null;
    }
}
