package com.iothings.config;



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
 * @author: Huanglei
 * @time:2020/10/27 9:45 PM
 * @Description：
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.iothings"))
                .paths(PathSelectors.any()).build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("人才培养服务平台-课程微服务 APIs ")
                .description("北京络捷斯特科技发展股份有限公司")
                .termsOfServiceUrl("http://www.063520.com")
                .contact(new Contact("黄磊","","379880669@qq.com"))
                .version("v1.0.0").build();
    }


}