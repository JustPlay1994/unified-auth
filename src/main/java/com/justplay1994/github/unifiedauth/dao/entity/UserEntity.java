package com.justplay1994.github.unifiedauth.dao.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Package: com.justplay1994.github.unifiedauth.api.model
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/31 14:52
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 14:52
 * @Update_Description: huangzezhou 补充
 **/

public class UserEntity {

    @ApiModelProperty(value = "账号: admin", required = true)
    String account;     //唯一账号
    @ApiModelProperty(value = "密码: 123", required = true)
    String password;    //密码
    @ApiModelProperty(value = "账号是否有效", required = true)
    boolean enabled;     //是否有效，1有效，0被禁用
    @ApiModelProperty(value = "手机号", required = true)
    String phoneNumber; //手机号
    @ApiModelProperty(value = "身份证", required = true)
    String id_card;     //身份证
    @ApiModelProperty(value = "真实姓名", required = true)
    String real_name;   //真实姓名

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }
    @Override
    public String toString() {
        return "[UserEntity = " +
                "account:" + account +
                ", password:" + password+
                ", enabled:" +enabled+
                ", phoneNumber:" +phoneNumber+
                ", id_card:" +id_card+
                ", real_name:" +real_name+
                "]";
    }
}
