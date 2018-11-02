package com.justplay1994.github.unifiedauth.dao;

import com.justplay1994.github.unifiedauth.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Package: com.justplay1994.github.unifiedauth.dao.mapper
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/11/2 11:39
 * @Updater: huangzezhou
 * @Update_Date: 2018/11/2 11:39
 * @Update_Description: huangzezhou 补充
 **/
@Mapper
public interface UserDao {

    Integer insert(UserEntity userEntity);

    UserEntity selectByAccount(String account);

}
