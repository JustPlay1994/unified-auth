package com.justplay1994.github.unifiedauth.api;

import com.justplay1994.github.unifiedauth.api.model.http.AuthResponseModel;
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
 * @Create_Date: 2018/10/31 15:40
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 15:40
 * @Update_Description: huangzezhou 补充
 **/
@Api(description = "组织管理")
@RequestMapping("/rolemanagement")
public interface OrganizationManagementApi {

    @ApiOperation(value = "查询所有组织架构", notes = "查询所有组织架构")
    @RequestMapping(value = "/oraganization/queryall", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public AuthResponseModel<Boolean> queryAllOrganizations();

}
