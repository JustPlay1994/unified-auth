package com.justplay1994.github.unifiedauth.service.Impl;

import com.justplay1994.github.unifiedauth.api.AuthorizationApi;
import com.justplay1994.github.unifiedauth.api.model.http.AuthResponseModel;
import org.springframework.stereotype.Service;

/**
 * @Package: com.justplay1994.github.unifiedauth.service
 * @Project: unified-auth
 * @Description: //权限校验逻辑
 * @Creator: huangzezhou
 * @Create_Date: 2018/11/1 14:29
 * @Updater: huangzezhou
 * @Update_Date: 2018/11/1 14:29
 * @Update_Description: huangzezhou 补充
 **/
@Service
public class AuthorizationServiceImpl {

    /**
     * 流程：
     * 1.校验token是否有效
     * 2.获取该用户的所有权限
     * 3.判断是否contains权限，只要有一个未被包含，则返回false
     * @param token
     * @param permissions
     * @return
     */
    public AuthResponseModel<Boolean> validatePermission(String token, String[] permissions) {
        return null;
    }

}
