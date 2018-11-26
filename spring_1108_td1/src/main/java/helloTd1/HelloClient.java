package helloTd1;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class HelloClient {
	public static void main (String args[]) throws Exception{
		try {
			System.out.println ("Début ….");
			Hello hello = getBeanByCfgClass ();
			String s = hello.sayHello ("Mad");
			System.out.println (s);
			Salutation salut1 = getBeanSalut ();
			System.out.println (salut1.saluer ("Deborah"));
			Salutation salut2 = getBeanSalut ();
			System.out.println (salut2.saluer ("Anne"));
		}
		catch (Exception e) {
			e.printStackTrace ();
		}
	}
	// retrouver le bean salut
	static Salutation getBeanSalut (){
		// configuration du bean par classe
		AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext (CfgBean.class);
		Salutation hello = (Salutation) ctxt.getBean (Salutation.class);
		ctxt.close ();
		return hello;
	}
	// retrouver le bean helloTd1
	static Hello getBeanByLambda (){
		// configuration du bean par classe lambda
		AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext ();
		ctxt.registerBean ("helloBean", Hello.class, ()-> new HelloImpl ());
		ctxt.refresh ();
		Hello hello = (Hello) ctxt.getBean ("helloBean", Hello.class);
		ctxt.close ();
		return hello;
	}
	static Hello getBeanByCfgClass (){
		// configuration du bean par classe
		AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext (CfgBean.class);
		Hello hello = (Hello) ctxt.getBean (Hello.class);
		ctxt.close ();
		return hello;
	}
	static Hello getBeanByCfgXml2 (){
		// configuration du bean par xml
		ConfigurableApplicationContext ctxt = new ClassPathXmlApplicationContext ("springTd1.xml");
		Hello hello = (Hello) ctxt.getBean (Hello.class);
		ctxt.close ();
		return hello;
	}
	static Hello getBeanByCfgXml (){
		// configuration du bean par xml
		DefaultListableBeanFactory bf = new DefaultListableBeanFactory ();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader (bf);
		reader.loadBeanDefinitions (new ClassPathResource ("springTd1.xml"));
		// ds main/resources/
		Hello hello = (Hello) bf.getBean ("helloTd1"); // id du bean
		return hello;
	}
}