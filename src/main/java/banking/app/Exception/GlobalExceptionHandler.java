package banking.app.Exception;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	    @ExceptionHandler(DontHaveSufficentAmount.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public Apierror handleResourceNotFoundException(DontHaveSufficentAmount ex) {
	        return new Apierror(HttpStatus.NOT_FOUND, ex.getMessage());
	    }
//	    
//	    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//	    @ResponseStatus(HttpStatus.NOT_FOUND)
//	    public Apierror handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
//	        return new Apierror(HttpStatus.NOT_FOUND, ex.getMessage());
//	    }
//	    
//	    @ExceptionHandler(TransactionSystemException.class)
//	    @ResponseStatus(HttpStatus.NOT_FOUND)
//	    public Apierror handleTransactionSystemException(TransactionSystemException ex) {
//	        return new Apierror(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
//	    }
//	    
//	    @ExceptionHandler(TaskIDAlreadyExistsException.class)
//	    @ResponseStatus(HttpStatus.NOT_FOUND)
//	    public Apierror handleTaskIDAlreadyExistsException(TaskIDAlreadyExistsException ex) {
//	        return new Apierror(HttpStatus.NOT_FOUND, ex.getMessage());
//	    }
//	    
	    
	    
		// using java 8 lambda expression 
		 @ExceptionHandler(MethodArgumentNotValidException.class) public
		  ResponseEntity<Map<String, String>>
		  handleValidationExceptions(MethodArgumentNotValidException ex) { Map<String,
		  String> resp=new HashMap<>();
		  ex.getBindingResult().getAllErrors().forEach((error)-> { String
		  fieldName=((FieldError)error).getField(); String errorMessages
		  =error.getDefaultMessage(); resp.put(fieldName, errorMessages); }); return
		  new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST); }
		 
	    
	      // using java 8 stream API
		/*
		 * @ExceptionHandler(MethodArgumentNotValidException.class) public
		 * ResponseEntity<String>
		 * handleValidationExceptions(MethodArgumentNotValidException ex) {
		 * BindingResult result = ex.getBindingResult(); String errorMessages =
		 * result.getAllErrors() .stream() .map(error -> error.getDefaultMessage())
		 * .reduce("", (accumulator, errorMessage) -> accumulator + errorMessage +
		 * "\n");
		 * 
		 * return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages); }
		 */
	     

}
