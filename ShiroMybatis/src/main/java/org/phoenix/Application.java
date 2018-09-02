package org.phoenix;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



import static org.springframework.boot.SpringApplication.run;

@ComponentScan(basePackages = "org.phoenix")
@SpringBootApplication
@Configuration
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = run(Application.class, args);
    }

}
