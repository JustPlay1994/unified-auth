package com.justplay1994.github.unifiedauth.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Authorization;

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
@ApiModel("User")
public class User {

    @ApiModelProperty(value = "账号", required = true)
    String account;     //唯一账号
    @ApiModelProperty(value = "密码", required = true)
    String password;    //密码
    @ApiModelProperty(value = "手机号", required = true)
    String phoneNumber; //手机号
    @ApiModelProperty(value = "身份证", required = true)
    String id_card;     //身份证
    @ApiModelProperty(value = "真实姓名", required = true)
    String real_name;   //真实姓名
    @ApiModelProperty(value = "角色", required = true)
    String role;        //角色
    @ApiModelProperty(value = "账号是否有效", required = true)
    boolean enable;     //是否有效，1有效，0被禁用

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
