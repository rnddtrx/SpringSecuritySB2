package be.ipam.SpringSecuritySB2.security;

//Exception d'authentification
public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = -898198370372253864L;

	public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}

