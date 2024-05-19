package banking.app.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class Apierror{

    private HttpStatus status;
    private String message;
    
	public Apierror(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	
	}
	public Apierror() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}