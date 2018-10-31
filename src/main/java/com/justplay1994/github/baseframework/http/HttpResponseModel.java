package com.justplay1994.github.baseframework.http;

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

    String code; //状态码
    String message; //描述信息
    T   data;      //数据

    public interface Code{
        public final static int SUCCESS_CODE = 0;
        public final static String SUCCESS_MESSAGE = "正常响应请求";

        public final static int UNKOWN_ERROR_CODE = -1;
        public final static String UNKOWN_ERROR_MESSAGE = "系统发生未知错误";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
