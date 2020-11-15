package com.easy.excel;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@SpringBootApplication
@EnableSwagger2
public class EasyExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyExcelApplication.class, args);
    }

    @Value("${spring.profiles.active}")
    private String activeEnvironment;


    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("zyl").enable(StrUtil.equals("dev", activeEnvironment));
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("zyl", "https://github.com/woshijianren/simple-excel.git", "2390268197@qq.com");
        return new ApiInfo("simple-excel", "通过读取excel需求完成80%的重复工作", "v-0.1", "https://github.com/woshijianren/simple-excel.git", contact, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
    }
}