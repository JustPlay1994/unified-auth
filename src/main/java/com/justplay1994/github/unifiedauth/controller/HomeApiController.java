package com.justplay1994.github.unifiedauth.controller;

import com.justplay1994.github.unifiedauth.api.HomeApi;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Package: com.justplay1994.github.baseframework.controller
 * @Project: base-framework
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/22 9:14
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/22 9:14
 * @Update_Description: huangzezhou 补充
 **/
@RestController
public class HomeApiController implements HomeApi {
    @Override
    public void getHome(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui.html");
    }

    @Override
    public String index(String code) {
        return "welcome";
    }

}
