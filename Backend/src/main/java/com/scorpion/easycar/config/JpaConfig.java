package com.scorpion.easycar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.scorpion.easycar.repository")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class JpaConfig {

    @Autowired
    Environment environment;

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource source, JpaVendorAdapter vendor) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setJpaVendorAdapter(vendor);
        bean.setDataSource(source);
        bean.setPackagesToScan(environment.getRequiredProperty("app.entity.package"));
        return bean;
    }

    @Bean
    public DataSource dataSource() throws NamingException {
        DriverManagerDataSource source= new DriverManagerDataSource();
        source.setUrl(environment.getRequiredProperty("app.db.url"));
        source.setUsername(environment.getRequiredProperty("app.db.username"));
        source.setPassword(environment.getRequiredProperty("app.db.password"));
        source.setDriverClassName(environment.getRequiredProperty("app.driver.classname"));
        return source;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        vendor.setDatabasePlatform(environment.getRequiredProperty("app.db.platform"));
        vendor.setDatabase(Database.MYSQL);
        vendor.setShowSql(true);
        vendor.setGenerateDdl(true);
        return vendor;
    }
}
