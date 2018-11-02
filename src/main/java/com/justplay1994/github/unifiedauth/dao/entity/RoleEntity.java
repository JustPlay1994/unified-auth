package com.justplay1994.github.unifiedauth.dao.entity;

/**
 * @Package: com.justplay1994.github.unifiedauth.dao.entity
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/11/2 17:31
 * @Updater: huangzezhou
 * @Update_Date: 2018/11/2 17:31
 * @Update_Description: huangzezhou 补充
 **/
public class RoleEntity {

    String account; //账号
    String role;    //角色

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
