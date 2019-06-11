package pokemon.server.exception;

public class ConflictException extends RuntimeException {
    private static final long serialVersionUID = -1979589344133264900L;

    public ConflictException() {
        super();
    }

    public ConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConflictException(String message) {
        super(message);
    }

    public ConflictException(Throwable cause) {
        super(cause);
    }

}