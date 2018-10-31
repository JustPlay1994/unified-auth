package com.justplay1994.github.baseframework.http;

/**
 * @Package: com.justplay1994.github.framework.http
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/31 10:44
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 10:44
 * @Update_Description: huangzezhou ����
 **/
public class HttpResponseModel<T> {

    String code; //״̬��
    String message; //������Ϣ
    T   data;      //����

    public interface Code{
        public final static int SUCCESS_CODE = 0;
        public final static String SUCCESS_MESSAGE = "������Ӧ����";

        public final static int UNKOWN_ERROR_CODE = -1;
        public final static String UNKOWN_ERROR_MESSAGE = "ϵͳ����δ֪����";
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
