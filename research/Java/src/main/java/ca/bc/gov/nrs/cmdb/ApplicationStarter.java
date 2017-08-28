package ca.bc.gov.nrs.cmdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// This application shell is based on the reference OpenShift application available at
//  https://blog.openshift.com/using-spring-boot-on-openshift/

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication

public class ApplicationStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        // run as a web application.
        //new SpringApplicationBuilder(ApplicationStarter.class).web(false).run(args);
        SpringApplication.run(ApplicationStarter.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationStarter.class);
    }

}