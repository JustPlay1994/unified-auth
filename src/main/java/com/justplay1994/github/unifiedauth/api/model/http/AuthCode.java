package com.justplay1994.github.unifiedauth.api.model.http;

import com.justplay1994.github.baseframework.http.SysCode;
import org.springframework.stereotype.Component;

/**
 * @Package: com.justplay1994.github.unifiedauth.api.model.http
 * @Project: unified-auth
 * @Description: //登录模块状态码
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/31 10:53
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 10:53
 * @Update_Description: huangzezhou 补充
 **/
@Component
public class AuthCode extends SysCode {
    public final int LOGIN_FAIL_CODE = 10000;
    public final String LOGIN_FAIL_MESSAGE = "登录失败";

    public final int CREATE_USER_ERROR_CODE = 10001;
    public final String CREATE_USER_ERROR_MESSAGE = "创建用户失败";
    AuthCode() {
        map.put(CREATE_USER_ERROR_CODE, CREATE_USER_ERROR_MESSAGE);
        map.put(LOGIN_FAIL_CODE, LOGIN_FAIL_MESSAGE);
    }
}
