package com.adobe.prj;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.adobe.prj")
public class AppConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();        
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/ADOBE_JUN_DB");
        ds.setUsername("root");
        ds.setPassword("1234");        
        return ds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean factoryBean(DataSource ds) {
		LocalContainerEntityManagerFactoryBean factory = 
				new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		factory.setJpaProperties(properties);
		factory.setDataSource(ds);
		factory.setPackagesToScan("com.adobe.prj.entity");
		return factory;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		PlatformTransactionManager txManager = new JpaTransactionManager(emf);
		return txManager;
	}
}