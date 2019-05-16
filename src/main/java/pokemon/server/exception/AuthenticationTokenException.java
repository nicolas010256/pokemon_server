package pokemon.server.exception;

public class AuthenticationTokenException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AuthenticationTokenException() {
        super();
    }

    public AuthenticationTokenException(String message) {
        super(message);
    }
}