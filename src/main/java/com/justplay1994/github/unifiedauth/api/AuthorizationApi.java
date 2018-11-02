package com.justplay1994.github.unifiedauth.api;

import com.justplay1994.github.baseframework.http.HttpResponseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 组织架构、权限、角色。
 * 创建角色时：会绑定响应的组织架构和权限到角色上
 * 分配给用户的只有角色（带有权限和组织架构）。
 * @Package: com.justplay1994.github.unifiedauth.api.service
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/31 11:01
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 11:01
 * @Update_Description: huangzezhou 补充
 **/
@Api(description = "授权逻辑")
@RequestMapping("/authorization")
public interface AuthorizationApi {
    @ApiOperation(value = "校验当前登录用户是否有集合中的所有权限", notes = "校验当前登录用户是否有集合中的所有权限权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户令牌", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "permissions", value = "权限标识集合", paramType = "query", required = true, dataType = "Array[string]")
    })
    @RequestMapping(value = "/permission/validate", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HttpResponseModel<Boolean> validatePermission(String token, String[] permissions);


}
