/**
 *
 * Created by HZZ on 2018/10/31.
 *
 */
package com.justplay1994.github.unifiedauth.controller;

import com.justplay1994.github.baseframework.http.HttpResponseModel;
import com.justplay1994.github.unifiedauth.api.OrganizationManagementApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HZZ on 2018/10/31.
 */
@RestController
public class OrganizationManagementController implements OrganizationManagementApi {
    @Override
    public HttpResponseModel<Boolean> queryAllOrganizations() {
        return null;
    }
}
