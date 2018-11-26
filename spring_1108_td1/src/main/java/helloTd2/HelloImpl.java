package helloTd2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloImpl implements Hello {
	private String greeting = "Hello";
	static int count = 1;

	public String sayHello (String a){
		String message = greeting + " " + a;
		return message;
	}
	@PostConstruct // HelloConfig reconnait les annotations
	public void init (){
		System.out.println ("création du bean helloTd1 n°" + count);
	}
	@PreDestroy
	public void destroy (){
		System.out.println ("destruction d'un bean helloTd1");
	}

	public HelloImpl (String greeting){
		super ();
		this.greeting = greeting;
	}

	public HelloImpl (){
		this ("Hello");
	}

	public void setGreeting (String greeting){
		this.greeting = greeting;
	}
	public int getCount (){
		return count;
	}
}
