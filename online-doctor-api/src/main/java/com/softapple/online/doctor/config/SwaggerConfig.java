package com.softapple.online.doctor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Md. Zakir Hossain
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.softapple.online.doctor"))
                .build()
                .apiInfo(metaData());
    }
    
        private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Online Doctor API",
                "A restfull api for online-doctor client",
                "1.0",
                "Terms of service",
                new Contact("Soft Apple", "http://www.facebook.com/softapplepage/", "softapplebd@gmail.com"),
               "Soft Apple",
                "http://www.facebook.com/softapplebd");
        return apiInfo;
    }
}
