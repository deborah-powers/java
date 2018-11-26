package configuration;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource ("classpath:application.properties")
@EnableJpaRepositories (basePackages = { "repository" })
public class CfgRepo {
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	@Resource
	private Environment env;
	@Bean
	public DataSource dataSource (){
		DriverManagerDataSource dataSource = new DriverManagerDataSource ();
		dataSource.setUrl (env.getRequiredProperty (PROPERTY_NAME_DATABASE_URL));
		dataSource.setDriverClassName (env.getRequiredProperty (PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setPassword (env.getRequiredProperty (PROPERTY_NAME_DATABASE_PASSWORD));
		dataSource.setUsername (env.getRequiredProperty (PROPERTY_NAME_DATABASE_USERNAME));
		return dataSource;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory (){
		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean ();
		emfBean.setDataSource (dataSource ());
		emfBean.setPersistenceProviderClass (HibernatePersistenceProvider.class);
		// Hibernate will be used as JPA implementation.
		emfBean.setPackagesToScan (env.getRequiredProperty (PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
		emfBean.setJpaProperties (hibProperties ());
		return emfBean;
	}
	private Properties hibProperties (){
		Properties properties = new Properties ();
		properties.put (PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty (PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put (PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty (PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		return properties;
	}
	@Bean
	public JpaTransactionManager transactionManager (){
		JpaTransactionManager transactionManager = new JpaTransactionManager ();
		transactionManager.setEntityManagerFactory (entityManagerFactory ().getObject ());
		return transactionManager;
	}
}
