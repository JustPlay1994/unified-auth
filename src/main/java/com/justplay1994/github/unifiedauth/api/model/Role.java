package com.justplay1994.github.unifiedauth.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Package: com.justplay1994.github.unifiedauth.api.model
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/31 16:46
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 16:46
 * @Update_Description: huangzezhou 补充
 **/

@ApiModel("Role")
public class Role {
    @ApiModelProperty(value = "角色名",required = true)
    String name;
    @ApiModelProperty(value = "描述",  required = true)
    String description;

}
