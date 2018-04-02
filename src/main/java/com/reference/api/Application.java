package com.reference.api;

import static springfox.documentation.builders.PathSelectors.regex;

import com.reference.api.models.*;
import com.reference.api.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication(
        exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
)
//@EnableResourceServer
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
    public CommandLineRunner fullSeed(UserRepository user_repo,
                                      CompartmentRepository compartment_repo,
                                      BottleTypeRepository bottletype_repo,
                                      BottleRepository bottle_repo,
                                      RoleRepository roleRepository) {
        return (args) -> {

            roleRepository.save(new Role("ADMIN_ROLE"));
            roleRepository.save(new Role("USER_ROLE"));

            Role adminRole = roleRepository.findByName("ADMIN_ROLE");
            Role userRole = roleRepository.findByName("USER_ROLE");

            BottleType bt1 = (new BottleType("Bordeaux supérieur",true));
            BottleType bt2 = new BottleType("saumur-champigny",true);
            BottleType bt3 = new BottleType("sainte-croix-du-mont",true);
            BottleType bt4 = new BottleType("vacqueyras",false);
            bottletype_repo.save(bt1);
            bottletype_repo.save(bt2);
            bottletype_repo.save(bt3);
            bottletype_repo.save(bt4);

            User u1 = new User("ludo","asticot");
            User u2 = new User("trima","asticot");
            User u3 = new User("admin", "admin");

            u1.setRoles(Arrays.asList(userRole));
            u2.setRoles(Arrays.asList(userRole));
            u3.setRoles(Arrays.asList(adminRole));

            user_repo.save(u1);
            user_repo.save(u2);
            user_repo.save(u3);

            Compartment c1 = new Compartment("A1",u1);
            Compartment c2 = new Compartment("A2",u1);
            compartment_repo.save(c1);
            compartment_repo.save(c2);

            bottle_repo.save(new Bottle(new Long(1957),"rhone alpes",u1,bt1,c2,38,"jaune","http://localhost:8080/images/rouge-bordeaux-bordeaux-superieur-aoc-2007"));
        };
    }


}
