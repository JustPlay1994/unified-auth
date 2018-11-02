package com.justplay1994.github.unifiedauth.controller;

import com.justplay1994.github.baseframework.http.HttpResponseModel;
import com.justplay1994.github.unifiedauth.api.UserManagementApi;
import com.justplay1994.github.unifiedauth.dao.entity.UserEntity;
import com.justplay1994.github.unifiedauth.service.Impl.UserManagementServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger logger = LoggerFactory.getLogger(UserManagementServiceImpl.class);

    @Autowired
    UserManagementServiceImpl userManagementService;

    @Override
    public HttpResponseModel<Boolean> createUser(UserEntity userEntity, String[] role) {
        try {
            return userManagementService.createUser(userEntity, role);
        }catch (Exception e){
            logger.error("create user error!\n",e);
            return new HttpResponseModel<Boolean>();
        }
    }
}
