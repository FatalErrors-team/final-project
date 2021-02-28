package com.gama.finalproject.core.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket apis() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.gama.finalproject"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "Documentaçao da API",
            "Se trata de uma <b>API Spring Boot criada para gerenciar alunos</b>. Proposta como projeto de conclusão de Java solicitado pelo professor <b>Marcos</b> no treinamento da <b>Gama Academy</b>.",
            "1.0",
            "Termos de Uso",
            null,
            "Licença",
            "https://github.com/FatalErrors-team/final-project/blob/main/LICENSE", new ArrayList<>());
    }
}
