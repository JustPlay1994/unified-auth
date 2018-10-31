/**
 *
 * Created by HZZ on 2018/10/31.
 *
 */
package com.justplay1994.github.unifiedauth.controller;

import com.justplay1994.github.unifiedauth.api.RoleManagementApi;
import com.justplay1994.github.unifiedauth.api.model.Role;
import com.justplay1994.github.unifiedauth.api.model.http.AuthResponseModel;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HZZ on 2018/10/31.
 */
@RestController
public class RoleManagementController implements RoleManagementApi {
    @Override
    public AuthResponseModel<Boolean> addRole(Role role) {
        return null;
    }

    @Override
    public AuthResponseModel<Boolean> queryAllPermissions() {
        return null;
    }
}
