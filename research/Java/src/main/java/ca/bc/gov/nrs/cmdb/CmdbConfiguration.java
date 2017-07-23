package ca.bc.gov.nrs.cmdb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author George
 */

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.orient.commons.repository.config.EnableOrientRepositories;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.data.orient.commons.core.OrientTransactionManager;
import org.springframework.data.orient.object.OrientObjectTemplate;
import ca.bc.gov.nrs.cmdb.model.Application;
import ca.bc.gov.nrs.cmdb.model.Module;

@Configuration
@EnableTransactionManagement
@EnableOrientRepositories(basePackages = "ca.bc.gov.nrs.cmdb.repository")
public class CmdbConfiguration {

    @Bean
    public OrientObjectDatabaseFactory factory() {
        OrientObjectDatabaseFactory factory =  new OrientObjectDatabaseFactory();

        factory.setUrl("remote:127.0.0.1/cmdb");
        factory.setUsername("admin");
        factory.setPassword("admin");

        return factory;
    }

    @Bean
    public OrientTransactionManager transactionManager() {
        return new OrientTransactionManager(factory());
    }

    @Bean
    public OrientObjectTemplate objectTemplate() {
        return new OrientObjectTemplate(factory());
    }


    @PostConstruct
    public void registerEntities() {
        factory().db().getEntityManager().registerEntityClass(Application.class);
    }
}