package configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
// basePackages liste les packages où sont mes interfaces-repository, qui appellent les fonctions des interfaces springxyRepository
@EnableJpaRepositories (basePackages = { "repository" })
public class CfgRepo {
	// cette fonction récupère l'attribut entityManagerFactory
	@Bean
	public EntityManagerFactory entityManagerFactory (){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean ();
		emf.setDataSource (dataSource ());
		emf.setPersistenceUnitName ("spring_1109_td2");
		emf.setPackagesToScan ("entities"); // package où sont les classes-entity
		emf.setJpaVendorAdapter (new HibernateJpaVendorAdapter ());
		Properties jpaProperties = new Properties ();
		jpaProperties.put (Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		emf.setJpaProperties (jpaProperties);
		emf.afterPropertiesSet ();
		return emf.getObject ();
	}
	@Autowired
	EntityManagerFactory entityManagerFactory;
	@Bean
	public JpaTransactionManager transactionManager (){
		JpaTransactionManager jpaT = new JpaTransactionManager ();
		jpaT.setEntityManagerFactory (entityManagerFactory);
		return jpaT;
	}
	@Bean
	public DataSource dataSource (){
		DriverManagerDataSource dataSource = new DriverManagerDataSource ();
		dataSource.setUrl ("jdbc:mysql://localhost:3306/gestcom?serverTimezone=UTC");
		dataSource.setDriverClassName ("com.mysql.jdbc.Driver");
		dataSource.setPassword ("root");
		dataSource.setUsername ("root");
		return dataSource;
	}

}
