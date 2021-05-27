package com.hackathon.demoapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class PersistanceConfiguration {
    
    @Primary
    @Bean(name ="postgreDs")
    //@ConfigurationProperties(prefix="demoapp.datasource.azureds")
    public DataSource postgresDataSource() {
        //spring batch related metada data will be stored in postgress.
        
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        
       // dataSourceBuilder.username("demoappadmin");
       // dataSourceBuilder.password("Doon@123");
        
        dataSourceBuilder.url("jdbc:postgresql://demoapp-hackathon.postgres.database.azure.com:5432/azuredemo");
        dataSourceBuilder.username("demoappadmin@demoapp-hackathon.postgres.database.azure.com");
        dataSourceBuilder.password("Doon@123");
       /* 
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/azuredemo?currentschema=demoappadmin");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("admin");*/
       return  dataSourceBuilder.build();
    }
    
    @Primary              
    @Bean(name = "postgreJdbc")
    public JdbcTemplate postgresJdbcTemplate(@Qualifier("postgreDs") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Primary
    @Bean(name = "postgreNamedJdbc")
    public NamedParameterJdbcTemplate postgresNamedJdbcTemplate(@Qualifier("postgreDs") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

  
    
 /*   @Bean("LisaTM")
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(lisaDs);
    }
*/
 
    

    


    
}