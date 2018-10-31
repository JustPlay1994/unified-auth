package com.justplay1994.github.unifiedauth.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;

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
    @ApiModelProperty(value = "描述", required = true)
    String description;
    @ApiModelProperty(value = "组织编号", required = true)
    String organizationId;
    @ApiModelProperty(value = "权限", required = true)
    ArrayList<String> permissions;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public ArrayList<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<String> permissions) {
        this.permissions = permissions;
    }
}
