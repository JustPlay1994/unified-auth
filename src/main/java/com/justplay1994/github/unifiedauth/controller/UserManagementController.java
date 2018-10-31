package com.justplay1994.github.unifiedauth.controller;

import com.justplay1994.github.unifiedauth.api.UserManagementApi;
import com.justplay1994.github.unifiedauth.api.model.TokenModel;
import com.justplay1994.github.unifiedauth.api.model.User;
import com.justplay1994.github.unifiedauth.api.model.http.AuthResponseModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
public class UserManagementController implements UserManagementApi {
    @Override
    public AuthResponseModel<Boolean> createUser(User user) {
        return null;
    }
}
