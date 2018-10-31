package com.justplay1994.github.unifiedauth.api.model.http;

import com.justplay1994.github.baseframework.http.HttpResponseModel;

/**
 * @Package: com.justplay1994.github.unifiedauth.api.model.http
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/31 10:53
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 10:53
 * @Update_Description: huangzezhou 补充
 **/
public class AuthResponseModel<T> extends HttpResponseModel<T> {

    interface Code extends HttpResponseModel.Code{
        public final static int LOGIN_SUCCESS_CODE = 10000;
        public final static String LOGIN_SUCCESS_MESSAGE = "登录成功";
    }
}
