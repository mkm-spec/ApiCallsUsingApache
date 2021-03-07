package basecode;

public class AuthenticatorApplication {
	
	private AuthenticatorInterface authenticateInterface;
	
	public AuthenticatorApplication(AuthenticatorInterface authenticateInterface) {
	
		this.authenticateInterface = authenticateInterface;
	}

	/**
	 * 
	 * @param  username
	 * @param password 
	 * 
	 * 
	 */
	public boolean authenticate(String username, String password) {
		boolean authenticate = this.authenticateInterface.authenticateUser(username, password);
		return authenticate;
		
	}
}
