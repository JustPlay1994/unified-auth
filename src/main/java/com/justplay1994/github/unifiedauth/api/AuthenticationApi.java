package com.justplay1994.github.unifiedauth.api;

import com.justplay1994.github.baseframework.http.HttpResponseModel;
import com.justplay1994.github.unifiedauth.api.model.CaptchaModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: com.justplay1994.github.unifiedauth.api.service
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/31 11:00
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/31 11:00
 * @Update_Description: huangzezhou 补充
 **/

@Api(description = "认证逻辑")
@RequestMapping("/authentication")
public interface AuthenticationApi {

    @ApiOperation(value = "登录接口", notes = "登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码sha256值", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "captcha", value = "验证码值", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HttpResponseModel<String> login(String account, String password, String captcha);

    @ApiOperation(value = "注销接口", notes = "注销接口")
    @ApiImplicitParam(name = "token", value = "令牌", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HttpResponseModel<Boolean> logout(String token);

    @ApiOperation(value = "请求验证码", notes = "请求验证码接口")
    @ApiImplicitParam(name = "captcha", value = "验证码", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/captcha/query", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HttpResponseModel<CaptchaModel> queryCaptcha();

    @ApiOperation(value = "验证令牌是否有效", notes = "验证令牌是否有效接口")
    @ApiImplicitParam(name = "token", value = "令牌", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/token/validate", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HttpResponseModel<Boolean> validateToken(String token);

    @ApiOperation(value = "刷新token", notes = "刷新token接口。用之前的有效令牌来换取新的令牌，之前令牌失效")
    @ApiImplicitParam(name = "token", value = "有效令牌", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/token/refresh", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HttpResponseModel<String> refreshToken(String token);

}
