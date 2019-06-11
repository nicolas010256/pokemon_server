package pokemon.server.configuration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pokemon.server.exception.AuthenticationTokenException;
import pokemon.server.exception.ConflictException;
import pokemon.server.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value = { ResourceNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(
      RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {AuthenticationTokenException.class})
    protected ResponseEntity<Object> handlerInvalideToken(
      RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler(value = {ConflictException.class})
    protected ResponseEntity<Object> handlerConflict(
      RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
