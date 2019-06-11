package pokemon.server.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 70088314957780439L;
    
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}