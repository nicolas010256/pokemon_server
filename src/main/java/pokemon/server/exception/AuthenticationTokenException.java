package pokemon.server.exception;

public class AuthenticationTokenException extends RuntimeException {
    private static final long serialVersionUID = -8122436880916949518L;

    public AuthenticationTokenException() {
        super();
    }

    public AuthenticationTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationTokenException(String message) {
        super(message);
    }

    public AuthenticationTokenException(Throwable cause) {
        super(cause);
    }
}