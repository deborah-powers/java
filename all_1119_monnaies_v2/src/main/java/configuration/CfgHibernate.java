package configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class CfgHibernate {
	@Bean
	public LocalSessionFactoryBean sessionFactory (){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean ();
		sessionFactory.setDataSource (dataSource ());
        sessionFactory.setPackagesToScan ({"entities"});
		sessionFactory.setHibernateProperties (hibernateProperties ());
		return sessionFactory;
	}
	@Bean
	public DataSource dataSource (){
		BasicDataSource dataSource = new BasicDataSource ();
		dataSource.setDriverClassName ("com.mysql.jdbc.Driver");
		dataSource.setUrl ("jdbc:mysql://localhost:3306/m2idb?serverTimezone=UTC");
		dataSource.setUsername ("root");
		dataSource.setPassword ("root");
		return dataSource;
	}
	@Bean
	public PlatformTransactionManager hibernateTransactionManager (){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager ();
		transactionManager.setSessionFactory (sessionFactory ().getObject ());
		return transactionManager;
	}
	private final Properties hibernateProperties (){
		Properties hibernateProperties = new Properties ();
		hibernateProperties.setProperty ("hibernate.hbm2ddl.auto", "create-drop");
		hibernateProperties.setProperty ("hibernate.dialect", "org.hibernate.dialect.InnoDBDialect");
		return hibernateProperties;
	}
}
