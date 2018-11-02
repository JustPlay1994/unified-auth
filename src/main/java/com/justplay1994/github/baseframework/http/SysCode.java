package com.justplay1994.github.baseframework.http;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Package: com.justplay1994.github.baseframework.http
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/11/2 14:46
 * @Updater: huangzezhou
 * @Update_Date: 2018/11/2 14:46
 * @Update_Description: huangzezhou 补充
 **/
@Component
public class SysCode {

    public HashMap<Integer,String> map = new HashMap<Integer,String>();

    public final int SYS_SUCCESS_CODE = 0;
    public final String SYS_SUCCESS_MESSAGE = "正常响应请求";

    public final int UNKNOWN_ERROR_CODE = -1;
    public final String UNKNOWN_ERROR_MESSAGE = "系统发生未知错误";

    public SysCode(){
        map.put(SYS_SUCCESS_CODE, SYS_SUCCESS_MESSAGE);
        map.put(UNKNOWN_ERROR_CODE,UNKNOWN_ERROR_MESSAGE);
    }

    public String message(int code){
        return map.get(code);
    }
}
