package tu_1114_td1;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.ExceptionEmptyPassword;
import exceptions.ExceptionEmptyUser;
import junit.framework.Assert;

public class TestLogin {
	private Login login;
	@Test
	public void test (){
		fail ("Not yet implemented");
	}
	@Test
	public void testIsValidGood () throws ExceptionEmptyUser, ExceptionEmptyPassword{
		String	username		= "Laravel";
		String	password		= "coucou";
		String	confirmation	= "coucou";
		boolean	valid			= login.isValid (username, password, confirmation);
		// Assert.assertEquals (true, valid);
		// Assert.assertTrue (valid); // réussi si valid est vrai
		// Assert.assertFalse (valid);// réussi si valid est false
		Assert.assertTrue ("Bon résultat, la validation marche pour username=" + username + ", password=" + password + ", confirmation=" + confirmation, valid);
	}
	@Test
	public void testIsValidUnmatchingPassword () throws ExceptionEmptyUser, ExceptionEmptyPassword{
		String	username		= "Laravel";
		String	password		= "coucou";
		String	confirmation	= "doudou";
		boolean	valid			= login.isValid (username, password, confirmation);
		Assert.assertFalse ("Bon résultat, la validation bloque pour username=" + username + ", password=" + password + ", confirmation=" + confirmation, valid);
	}
	@Test
	public void testIsValidShortUsername () throws ExceptionEmptyUser, ExceptionEmptyPassword{
		String	username		= "Toto";
		String	password		= "coucou";
		String	confirmation	= "doudou";
		boolean	valid			= login.isValid (username, password, confirmation);
		Assert.assertFalse ("Bon résultat, la validation bloque pour username=" + username + ", password=" + password + ", confirmation=" + confirmation, valid);
	}
	@Test (expected = ExceptionEmptyPassword.class)
	// j'attend la levée de l'exception
	public void testIsValidEmptyPassword () throws ExceptionEmptyUser, ExceptionEmptyPassword{
		String	username		= "Laravel";
		String	password		= "";
		String	confirmation	= "doudou";
		boolean	valid			= login.isValid (username, password, confirmation);
	}
	@Test (expected = ExceptionEmptyUser.class)
	public void testIsValidEmptyUser () throws ExceptionEmptyUser, ExceptionEmptyPassword{
		String	username		= "";
		String	password		= "coucou";
		String	confirmation	= "doudou";
		boolean	valid			= login.isValid (username, password, confirmation);
	}
	@Test (expected = ExceptionEmptyPassword.class)
	public void testIsValidEmptyConfirmation () throws ExceptionEmptyUser, ExceptionEmptyPassword{
		// pb, pas d'exception prévu en cas de confirmation vide
		String	username		= "Laravel";
		String	password		= "coucou";
		String	confirmation	= "";
		boolean	valid			= login.isValid (username, password, confirmation);
		Assert.assertFalse ("Bon résultat, la validation bloque pour username=" + username + ", password=" + password + ", confirmation=" + confirmation, valid);
	}
	@Before
	public void beforeTest (){
		System.out.println ("début du test");
		login = new Login ();
	}
	@After
	public void afterTest (){
		System.out.println ("fin du test");
	}
}
