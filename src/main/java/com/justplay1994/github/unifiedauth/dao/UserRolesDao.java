package com.justplay1994.github.unifiedauth.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Package: com.justplay1994.github.unifiedauth.dao
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/11/2 17:32
 * @Updater: huangzezhou
 * @Update_Date: 2018/11/2 17:32
 * @Update_Description: huangzezhou 补充
 **/
@Mapper
public interface UserRolesDao {
    //插入一个用户的权限集合
//    int insertRolesPerUser(@Param("account")String account, @Param("roles")List<String> roles);
    int insertRolesPerUser(@Param("account_roles")Map account_roles);
}
