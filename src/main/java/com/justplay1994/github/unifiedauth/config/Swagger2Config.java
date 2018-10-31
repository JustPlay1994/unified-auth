package com.justplay1994.github.unifiedauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Package: com.justplay1994.github.baseframework.config
 * @Project: base-framework
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/22 9:07
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/22 9:07
 * @Update_Description: huangzezhou 补充
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.justplay1994.github.unifiedauth.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("JustPlay1994 Unified Auth")
                        //创建人
                .contact(new Contact("JustPlay1994", "https://github.com/JustPlay1994/unified-auth", "764804602@qq.com"))
                        //版本号
                .version("1.0")
                        //描述
                .description("统一权限认证")
                .build();
    }


}
