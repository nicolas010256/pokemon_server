package pokemon.server.exception;

public class UserException extends RuntimeException {

    private static final long serialVersionUID = -1300072580642529732L;

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }
    
}