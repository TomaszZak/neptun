package com.tzak.neptun.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket SwaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("neptun-api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .globalResponseMessage(RequestMethod.GET,
                        responseMessagesGet());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Neptun")
                .description("Swagger for the Neptun application")
                .contact(new Contact("Tomasz Żak",
                        "no URL",
                        "no email"))
                .license("no license")
                .licenseUrl("no URL to license")
                .version("0.0.1")
                .build();
    }

    /**
     * ustawiamy globalne response messages dla różnych kodów statusów
     * @return
     */
    private List<ResponseMessage> responseMessagesGet() {
        List<ResponseMessage> responseMessages = new ArrayList();

        //dla wszystkich metod typu GET i kodu 500 zwracaj wiadomość jak w "message"
        ResponseMessage responseMessageBuilderGet500 = new ResponseMessageBuilder()
                .code(500)
                .message("Customowa odpowiedź dla kodu 500 przy GET")
                .responseModel(new ModelRef("Error"))
                .build();

        responseMessages.add(responseMessageBuilderGet500);
        return responseMessages;
    }
}
