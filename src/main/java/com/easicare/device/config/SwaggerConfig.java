package com.easicare.device.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author df
 * @date 2019/8/6
 */
@EnableAutoConfiguration
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
       /* ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("token").description("登录校验token")//name表示对象名称，description表示描述
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();//required表示是否必填，defaultvalue表示默认值
        pars.add(ticketPar.build());//添加完此处一定要把下边的带***的也加上否则不生效*/

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.easicare.device.controller"))
                .paths(PathSelectors.any())
                .build();
                //.globalOperationParameters(pars);//************把消息头添加

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("测量数据上传处理API")
            .description("接口访问地址：http://192.168.1.134:8080/")
            //.contact(new Contact("df", null, null))
            .version("1.0").build();
    }

}
