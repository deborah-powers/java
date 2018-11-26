package helloTd1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CfgBean {
	@Bean
	@Scope (value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Hello getHello (){
		return new HelloImpl ();
	}
	@Bean
	@Scope (value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Salutation getSalutation (){
		return new Salutation ();
	}
}
