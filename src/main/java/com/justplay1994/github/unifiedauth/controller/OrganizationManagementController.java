/**
 *
 * Created by HZZ on 2018/10/31.
 *
 */
package com.justplay1994.github.unifiedauth.controller;

import com.justplay1994.github.unifiedauth.api.OrganizationManagementApi;
import com.justplay1994.github.unifiedauth.api.model.http.AuthResponseModel;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HZZ on 2018/10/31.
 */
@RestController
public class OrganizationManagementController implements OrganizationManagementApi {
    @Override
    public AuthResponseModel<Boolean> queryAllOrganizations() {
        return null;
    }
}
