package com.ameya.configs;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	@Value("${db.driver}")
	private String DB_DRIVER;
	@Value("${db.password}")
	private String DB_PASSWORD;
	@Value("${db.username}")
	private String DB_USERNAME;
	@Value("${db.url}")
	private String DB_URL;
	
	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;
	@Value("${hibernate.show_sql}")
	private String HIBERNATE_SHOW_SQL;
	@Value("${hibernate.hbm2dll.auto}")
	private String HBM2DLL;
	@Value("${entitymanager.packagesToScan}")
	private String ENTITYMANAGE_PKGSCAN;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(DB_DRIVER);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		return dataSource;
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		Properties hProp=new Properties();
		hProp.put("hibernate.dialect", HIBERNATE_DIALECT);
		hProp.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		hProp.put("hibernate.hbm2dll.auto", HBM2DLL);
		sessionFactory.setPackagesToScan(ENTITYMANAGE_PKGSCAN);
		sessionFactory.setHibernateProperties(hProp);
		return sessionFactory;
	}
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager txManager=new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory().getObject());
		return txManager;
	}
}
