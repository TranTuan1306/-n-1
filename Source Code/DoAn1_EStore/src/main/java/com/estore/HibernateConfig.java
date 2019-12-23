package com.estore;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfig {
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://localhost;database=DataW");
		dataSource.setUsername("sa");
		dataSource.setPassword("123");
		return dataSource;
	}
	
	@Bean @Autowired
	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("com.estore.entity");
		
		Properties props = factoryBean.getHibernateProperties();
		props.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2008Dialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.ddl-auto", "none");
		props.put("current_session_context_class", 
				"org.springframework.orm.hibernate5.SpringSessionContext");
		factoryBean.afterPropertiesSet();

		return factoryBean.getObject();
	}
	
	@Bean @Autowired
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
}