package helloTd1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

public class Salutation {
	static int count = 1;
	@Autowired
	Hello hello;

	public String saluer (String word){
		String message = hello.sayHello (word).toUpperCase ();
		return message;
	}
	public Salutation (){
		System.out.println ("salutation n°" + count);
		count++;
	}
	@PostConstruct // HelloConfig reconnait les annotations
	public void init (){
		System.out.println ("création du bean salutation n°" + (count - 1));
	}
	@PreDestroy
	public void destroy (){
		System.out.println ("destruction du bean salutation n°" + (count - 1));
	}
}
