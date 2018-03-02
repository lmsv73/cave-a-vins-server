package com.reference.api;

import static springfox.documentation.builders.PathSelectors.regex;

import com.reference.api.models.Bottle;
import com.reference.api.models.BottleType;
import com.reference.api.models.Compartment;
import com.reference.api.models.User;
import com.reference.api.repository.BottleRepository;
import com.reference.api.repository.BottleTypeRepository;
import com.reference.api.repository.CompartmentRepository;
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
    public CommandLineRunner fullSeed(UserRepository user_repo,CompartmentRepository compartment_repo,BottleTypeRepository bottletype_repo, BottleRepository bottle_repo) {
        return (args) -> {
            BottleType bt1 = (new BottleType("Bordeaux supérieur",false));
            bottletype_repo.save(bt1);
            bottletype_repo.save(new BottleType("saumur-champigny",true));
            bottletype_repo.save(new BottleType("sainte-croix-du-mont",false));
            bottletype_repo.save(new BottleType("vacqueyras",false));
            User u1 = new User("ludo","asticot");
            Compartment c1 = new Compartment("A1");
            user_repo.save(u1);
            user_repo.save(new User("trima","asticot"));
            compartment_repo.save(c1);
            compartment_repo.save(new Compartment("A2"));
            bottle_repo.save(new Bottle(new Long(14121996),"rhone alpes",u1,bt1,c1));

        };
    }


}
