package banking.app.Exception;

public class DontHaveSufficentAmount extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	
	
	public DontHaveSufficentAmount() {}


	public DontHaveSufficentAmount(String message) {
		super();
		this.message = message;
	}

}
