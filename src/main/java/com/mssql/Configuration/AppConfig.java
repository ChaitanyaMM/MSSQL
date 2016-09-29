package com.mssql.Configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mssql.Objects.User;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.mssql" })
@PropertySource("classpath:com/mssql/Configuration/config.properties")
public class AppConfig {

	// sql server drive= com.microsoft.sqlserver.jdbc.SQLServerDriver

 

	// @Bean
	// public DataSource dataSource() {
	// DriverManagerDataSource dataSource = new DriverManagerDataSource();
	// dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	// dataSource.setUrl("jdbc:sqlserver://localhost:1443/SQLMONITOR");
	// dataSource.setUsername("sa");
	// dataSource.setPassword("mm@1234");
	//
	// return dataSource;
	// }

//	@Bean(name = "sessionFactory")
//	public SessionFactory getSessionFactory(DataSource dataSource) {
//
//		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
//
//		sessionBuilder.addAnnotatedClasses(User.class);
//
//		return sessionBuilder.buildSessionFactory();
//	}
//
//	@Bean(name = "dataSource")
//	public DataSource getDataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		dataSource.setUrl("jdbc:sqlserver://localhost:1443/SQLMONITOR");
//		dataSource.setUsername("sa");
//		dataSource.setPassword("mm@1234");
//		return dataSource;
//	}
//
//	private Properties getHibernateProperties() {
//		Properties properties = new Properties();
//		properties.put("hibernate.show_sql", "true");
//		properties.put("hibernate.dialect", "org.hibernate.dialect.sqlserverDialect");
//		return properties;
//	}
//
//	@Bean
//	public HibernateTransactionManager transactionManager(SessionFactory s) {
//		HibernateTransactionManager txManager = new HibernateTransactionManager();
//		txManager.setSessionFactory(s);
//		return txManager;
//	}

}
