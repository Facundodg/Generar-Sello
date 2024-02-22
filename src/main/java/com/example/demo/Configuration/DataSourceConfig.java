package com.example.demo.Configuration;




import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "postgresDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.postgres")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlServerDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sqlserver")
    public DataSource sqlServerDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "postgresEntityManager")
    public LocalContainerEntityManagerFactoryBean postgresEntityManager(EntityManagerFactoryBuilder builder,
                                                                        @Qualifier("postgresDataSource") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages("com.example.demo.Model.Entity.postgres") // Paquete donde están las entidades de PostgreSQL
                .persistenceUnit("postgresPU")
                .build();
    }

    @Bean(name = "sqlServerEntityManager")
    public LocalContainerEntityManagerFactoryBean sqlServerEntityManager(EntityManagerFactoryBuilder builder,
                                                                         @Qualifier("sqlServerDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.demo.Model.Entity.sqlserver") // Paquete donde están las entidades de SQL Server
                .persistenceUnit("sqlServerPU")
                .build();
    }

    @Primary
    @Bean(name = "postgresTransactionManager")
    public PlatformTransactionManager postgresTransactionManager(
            @Qualifier("postgresEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = "sqlServerTransactionManager")
    public PlatformTransactionManager sqlServerTransactionManager(
            @Qualifier("sqlServerEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
