package com.project.algocomparator.configurations;

import java.beans.PropertyVetoException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.project.algocomparator.constants.MySQLDBConfigurationConstants;

@Configuration
@EnableTransactionManagement
@EnableCaching
@EnableJpaRepositories(entityManagerFactoryRef = MySQLDBConfigurationConstants.ENTITY_MANAGER, transactionManagerRef = MySQLDBConfigurationConstants.TRANSACTION_MANAGER, basePackages = MySQLDBConfigurationConstants.BASE_PACKAGES)
public class MySQLDBConfiguration {

	@Autowired
	private Environment env;

	@Bean(name = MySQLDBConfigurationConstants.ENTITY_MANAGER)
	public LocalContainerEntityManagerFactoryBean getMysqlEntityManagerFactoryBean(
			EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource()).packages(MySQLDBConfigurationConstants.BASE_PACKAGES)
				.persistenceUnit(MySQLDBConfigurationConstants.PERSISTENCE_UNIT).build();
	}

	@Bean(name = MySQLDBConfigurationConstants.TRANSACTION_MANAGER)
	public PlatformTransactionManager transactionManager(
			@Qualifier(MySQLDBConfigurationConstants.ENTITY_MANAGER) EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Bean(name = MySQLDBConfigurationConstants.DATA_SOURCE_BEAN)
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty(MySQLDBConfigurationConstants.DB_DRIVER));
		} catch (PropertyVetoException e) {
			System.out.println("DB INITIALIZATION ERROR!");
		}
		dataSource.setJdbcUrl(env.getProperty(MySQLDBConfigurationConstants.DB_URL));
		dataSource.setUser(env.getProperty(MySQLDBConfigurationConstants.DB_USERNAME));
		dataSource.setPassword(env.getProperty(MySQLDBConfigurationConstants.DB_PASSWORD));
		dataSource.setMinPoolSize(Integer.parseInt(env.getProperty(MySQLDBConfigurationConstants.DB_MIN_POOL_SIZE)));
		dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty(MySQLDBConfigurationConstants.DB_MAX_POOL_SIZE)));
		dataSource.setIdleConnectionTestPeriod(Integer.parseInt(env.getProperty(MySQLDBConfigurationConstants.DB_IDLE_TEST_PERIOD)));
		dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty(MySQLDBConfigurationConstants.DB_TIMEOUT)));
		dataSource.setMaxStatements(Integer.parseInt(env.getProperty(MySQLDBConfigurationConstants.DB_MAX_STATEMENTS)));
		dataSource.setAutoCommitOnClose(false);
		
		return dataSource;
	}
	
	@Bean(name = MySQLDBConfigurationConstants.SCHEMA_INITIALIZER_BEAN)
	@DependsOn(MySQLDBConfigurationConstants.DATA_SOURCE_BEAN)
	public DataSourceInitializer schemaInitializer(@Qualifier(MySQLDBConfigurationConstants.DATA_SOURCE_BEAN) DataSource dataSource) {
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		Resource initSchema = new ClassPathResource(env.getProperty(MySQLDBConfigurationConstants.DB_SCHEMA));
		resourceDatabasePopulator.addScripts(initSchema);
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
		return dataSourceInitializer;
	}
	
	@Bean(name = MySQLDBConfigurationConstants.DATA_INITIALIZER_BEAN)
	@DependsOn(MySQLDBConfigurationConstants.SCHEMA_INITIALIZER_BEAN)
	public DataSourceInitializer dataInitializer(@Qualifier(MySQLDBConfigurationConstants.DATA_SOURCE_BEAN) DataSource dataSource) {
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		Resource initData = new ClassPathResource(env.getProperty(MySQLDBConfigurationConstants.DB_INIT_DATA));
		resourceDatabasePopulator.addScripts(initData);
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
		return dataSourceInitializer;
	}
}
