package com.justplay1994.github.unifiedauth.api;

import com.justplay1994.github.baseframework.http.HttpResponseModel;
import com.justplay1994.github.unifiedauth.api.model.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: com.justplay1994.github.unifiedauth.api
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/31 15:35
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 15:35
 * @Update_Description: huangzezhou 补充
 **/
@Api(description = "角色管理")
@RequestMapping("/rolemanagement")
public interface RoleManagementApi {
    @ApiOperation(value = "创建角色", notes = "注意：角色需要绑定到组织机构上，组织机构可以为空")
    @RequestMapping(value = "/user/create", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HttpResponseModel<Boolean> addRole(Role role);

    @ApiOperation(value = "查询所有权限", notes = "查询所有权限")
    @RequestMapping(value = "/permissions/queryall", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HttpResponseModel<Boolean> queryAllPermissions();
}
