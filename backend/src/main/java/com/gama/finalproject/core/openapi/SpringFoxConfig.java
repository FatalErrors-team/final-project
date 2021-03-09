package com.gama.finalproject.core.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import io.swagger.models.auth.In;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;

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
                .useDefaultResponseMessages(false)
                .securitySchemes(Arrays.asList(new ApiKey("Token de Acesso", HttpHeaders.AUTHORIZATION, In.HEADER.name())));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "Documentaçao da API",
            "Se trata de uma <b>API Spring Boot criada para gerenciar alunos</b>. Proposta como projeto de conclusão de Java solicitado pelo professor <b>Marcos</b> no treinamento da <b>Gama Academy</b>. Vale ressaltar que para ter acesso aos endpoints da API é necessário estar autenticado, ou seja, passar o token JWT pelo header da requisição.",
            "1.0",
            "Termos de Uso",
            null,
            "Licença",
            "https://github.com/FatalErrors-team/final-project/blob/main/LICENSE", new ArrayList<>());
    }
}
