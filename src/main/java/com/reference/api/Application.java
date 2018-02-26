package com.reference.api;

import static springfox.documentation.builders.PathSelectors.regex;

import com.reference.api.models.BottleType;
import com.reference.api.models.User;
import com.reference.api.repository.BottleTypeRepository;
import com.reference.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


   @Bean
    public Docket Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("spring-swagger-api")
                .apiInfo(apiInfo())
                .select()
                .paths(regex ("/*.*"))
                .build();
    }
    
   private ApiInfo apiInfo() {
       return new ApiInfoBuilder()
               .title("Spring REST Sample with Swagger")
               .description("Spring REST Sample with Swagger")
               .license("Apache License Version 2.0")
               .licenseUrl("https://github.com/afajem/afajem.github.io/blob/master/LICENSE")
               .version("1.0")
               .build();
   }

    @Bean
    public CommandLineRunner seedBottle(BottleTypeRepository repository) {
        return (args) -> {
            // save a couple of person
            repository.save(new BottleType("Bordeaux supérieur",false));
            repository.save(new BottleType("saumur-champigny",true));
            repository.save(new BottleType("sainte-croix-du-mont",false));
            repository.save(new BottleType("vacqueyras",false));
        };
    }

    @Bean
    public CommandLineRunner seedUser(UserRepository repository) {
        return (args) -> {
            repository.save(new User("ludo","asticot"));
            repository.save(new User("trima","asticot"));
        };
    }


}
