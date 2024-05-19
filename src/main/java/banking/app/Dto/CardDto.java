package banking.app.Dto;
public class CardDto {
	private long c_id;
	private String accountNumber;
	private String cardNumber;
	private String cardHolderName;
	private String cardExpiryData;
	private int cvv;
	
	public CardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getC_id() {
		return c_id;
	}
	public void setC_id(long c_id) {
		this.c_id = c_id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardExpiryData() {
		return cardExpiryData;
	}
	public void setCardExpiryData(String cardExpiryData) {
		this.cardExpiryData = cardExpiryData;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
}
