package basecode;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class AuthenticatorApplicationTest {

	@Test
	public void autheticateUserTest() {
		AuthenticatorInterface authenticatorMock;
		AuthenticatorApplication authenticator;
		String username = "test";
		String password = "passwordcode";
		
		authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
		authenticator = new AuthenticatorApplication(authenticatorMock);
		
		when(authenticatorMock.authenticateUser(username, password)).thenReturn(false);
				
				
		boolean actual = authenticator.authenticate(username, password);
		System.out.println("acutal ==> " + actual);
		assertFalse(actual);
		
		boolean actual1 = authenticator.authenticate("username1", "pass");
		System.out.println("acutal1 ==> " + actual1);
		assertFalse(actual1);
		//verify(authenticatorMock).authenticateUser(username,"password");
		
		
	}
}
