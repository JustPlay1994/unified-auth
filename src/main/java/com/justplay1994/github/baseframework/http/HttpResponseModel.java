package com.justplay1994.github.baseframework.http;

import com.justplay1994.github.unifiedauth.UnifiedAuthApplication;
import com.justplay1994.github.unifiedauth.api.model.http.AuthCode;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jca.context.SpringContextResourceAdapter;

/**
 * @Package: com.justplay1994.github.framework.http
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/31 10:44
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 10:44
 * @Update_Description: huangzezhou 补充
 **/
public class HttpResponseModel<T> {

    Integer code; //状态码
    String message; //描述信息
    T   data;      //数据

    public HttpResponseModel(){
        this.code = UnifiedAuthApplication.applicationContext.getBean(SysCode.class).UNKNOWN_ERROR_CODE;
        this.message = UnifiedAuthApplication.applicationContext.getBean(SysCode.class).message(code);
        this.data = null;
    }


    public HttpResponseModel(Integer code){
        this.code = code;
        this.message = UnifiedAuthApplication.applicationContext.getBean(SysCode.class).message(code);
        this.data = null;
    }

    public HttpResponseModel(Exception e){
        this.code = UnifiedAuthApplication.applicationContext.getBean(SysCode.class).UNKNOWN_ERROR_CODE;
        this.message = UnifiedAuthApplication.applicationContext.getBean(SysCode.class).message(code);
        this.message += e.getMessage();
        this.data = null;
    }

    public HttpResponseModel(Integer code, T data){
        this.code = code;
        this.message = UnifiedAuthApplication.applicationContext.getBean(SysCode.class).message(code);
        this.data = data;
    }

    public HttpResponseModel(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
