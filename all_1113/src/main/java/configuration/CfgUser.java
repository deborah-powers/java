package configuration;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement // ??
@ComponentScan ({ "services", "controllers" }) // package de l'interface
@PropertySource ("classpath:application.properties") // fichiers des propriétés du projet
@EnableJpaRepositories ("repositories")
public class CfgUser {
	// db properties
	private static final String nameDbUser = "db.username";
	private static final String nameDbPassword = "db.password";
	private static final String nameDbDriver = "db.driver";
	private static final String nameDbUrl = "db.url";
	// other properties
	private static final String nameHDialect = "hibernate.dialect";
	private static final String nameHShowSql = "hibernate.show_sql";
	private static final String nameToScan = "entitymanager.packages.to.scan"; // entities
	@Resource // retrouver une dépendence
	private Environment env;
	@Bean
	public DataSource dataSource (){
		DriverManagerDataSource dataSource = new DriverManagerDataSource ();
		dataSource.setUrl (env.getRequiredProperty (nameDbUrl));
		dataSource.setDriverClassName (env.getRequiredProperty (nameDbDriver));
		dataSource.setPassword (env.getRequiredProperty (nameDbPassword));
		dataSource.setUsername (env.getRequiredProperty (nameDbUser));
		return dataSource;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory (){
		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean ();
		emfBean.setDataSource (dataSource ());
		emfBean.setPersistenceProviderClass (HibernatePersistenceProvider.class);
		// Hibernate will be used as JPA implementation.
		emfBean.setPackagesToScan (env.getRequiredProperty (nameToScan));
		emfBean.setJpaProperties (hibProperties ());
		return emfBean;
	}
	private Properties hibProperties (){
		Properties properties = new Properties ();
		properties.put (nameHDialect, env.getRequiredProperty (nameHDialect));
		properties.put (nameHShowSql, env.getRequiredProperty (nameHShowSql));
		return properties;
	}
	@Bean
	public JpaTransactionManager transactionManager (){
		JpaTransactionManager transactionManager = new JpaTransactionManager ();
		transactionManager.setEntityManagerFactory (entityManagerFactory ().getObject ());
		return transactionManager;
	}
	@Bean
	public UrlBasedViewResolver setupViewResolver (){
		// remplace src/main/webapp/WEB-INF/mvc-config.xml
		UrlBasedViewResolver resolver = new UrlBasedViewResolver ();
		resolver.setPrefix ("/WEB-INF/view/");
		resolver.setSuffix (".jsp");
		resolver.setViewClass (JstlView.class);
		return resolver;
	}
}
