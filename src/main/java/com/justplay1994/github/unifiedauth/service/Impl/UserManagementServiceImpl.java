package com.justplay1994.github.unifiedauth.service.Impl;

import com.justplay1994.github.baseframework.http.HttpResponseModel;
import com.justplay1994.github.unifiedauth.api.model.http.AuthCode;
import com.justplay1994.github.unifiedauth.dao.UserDao;
import com.justplay1994.github.unifiedauth.dao.UserRolesDao;
import com.justplay1994.github.unifiedauth.dao.entity.UserEntity;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.justplay1994.github.unifiedauth.service.Impl
 * @Project: unified-auth
 * @Description: //用户管理服务
 * @Creator: huangzezhou
 * @Create_Date: 2018/11/2 9:38
 * @Updater: huangzezhou
 * @Update_Date: 2018/11/2 9:38
 * @Update_Description: huangzezhou 补充
 **/
@Service
public class UserManagementServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(UserManagementServiceImpl.class);

    @Autowired
    AuthCode code;

    @Autowired
    UserDao userDao;

    @Autowired
    UserRolesDao userRolesDao;

    @Transactional  //异常则回滚
    public HttpResponseModel<Boolean> createUser(UserEntity userEntity, String[] role) {
        HttpResponseModel<Boolean> result;
        //事务提交：1.创建用户，2.创建用户与角色关联。如果失败，事务回滚。

        int insertResult = userDao.insert(userEntity);
        HashMap map = new HashMap();
        map.put("account",userEntity.getAccount());
        map.put("roles", Arrays.asList(role));
        userRolesDao.insertRolesPerUser(map);
        result = new HttpResponseModel<Boolean>(
                code.SYS_SUCCESS_CODE,
                BooleanUtils.toBoolean(insertResult)
        );
        return result;

    }
}
