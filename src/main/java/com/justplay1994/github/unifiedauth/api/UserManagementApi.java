package com.justplay1994.github.unifiedauth.api;

import com.justplay1994.github.baseframework.http.HttpResponseModel;
import com.justplay1994.github.unifiedauth.dao.entity.UserEntity;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: com.justplay1994.github.unifiedauth.api
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/31 14:58
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 14:58
 * @Update_Description: huangzezhou 补充
 **/
@Api(description = "用户管理逻辑")
@RequestMapping("/usermanagement")
public interface UserManagementApi {

    @ApiOperation(value = "管理员创建用户/修改用户信息/禁用用户", notes = "注意：创建用户接口，也可以用来覆盖修改用户信息，也可以用于禁用/启用用户")
    @ApiImplicitParam(name = "role", value = "角色: role1,role2", required = true, paramType = "query", dataType = "Array[String]")
    @RequestMapping(value = "/user/create", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HttpResponseModel<Boolean> createUser(UserEntity userEntity, String[] role);


    //修改密码、身份证校验、禁用用户、授予用户角色
}
