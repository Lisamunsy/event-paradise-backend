package co.simplon.eventparadise.errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandler
	extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	    MethodArgumentNotValidException ex,
	    HttpHeaders headers, HttpStatus status,
	    WebRequest request) {
	System.out.println(
		"handle method argument not valid");
	List<FieldError> errors = ex.getFieldErrors();
	List<CustomError> customErrors = new ArrayList<>();
	for (FieldError error : errors) {
	    String code = error.getCode();
	    String fieldName = error.getField();
	    String message = error.getDefaultMessage();
	    CustomError customError = new CustomError(code,
		    fieldName, message);
	    customErrors.add(customError);
	}
	return handleExceptionInternal(ex, customErrors,
		headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
	    Exception ex, Object body, HttpHeaders headers,
	    HttpStatus status, WebRequest request) {
	return super.handleExceptionInternal(ex, body,
		headers, status, request);
    }
}