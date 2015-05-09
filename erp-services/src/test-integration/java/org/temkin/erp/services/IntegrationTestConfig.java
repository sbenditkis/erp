package org.temkin.erp.services;

import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactoryBean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class IntegrationTestConfig {
	@Autowired
	DataSource dataSource;


	@Autowired
	ArrayList<Class<?>> annotatedClasses;

	@Bean
	public EmbeddedDatabaseFactoryBean dataSource() throws Exception {
		EmbeddedDatabaseFactoryBean bean = new EmbeddedDatabaseFactoryBean();
		bean.setDatabaseType(EmbeddedDatabaseType.HSQL);
		return bean;
	}

	@Bean
	public SessionFactory sessionFactory() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.HSQLDialect");
		
		org.hibernate.cfg.Configuration configuration = new LocalSessionFactoryBuilder(
				dataSource).addProperties(hibernateProperties);
		for (Class<?> cl : annotatedClasses) {
			configuration.addAnnotatedClass(cl);
		}
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}
	
    @Bean
    public PlatformTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory());
    }
}
