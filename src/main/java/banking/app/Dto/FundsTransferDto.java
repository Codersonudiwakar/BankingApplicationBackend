package banking.app.Dto;

public class FundsTransferDto {
	long f_id;
	String accountNumberPayee;
	String accountNumberPayer;
	String Comment;
	long amount;
	
	public FundsTransferDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FundsTransferDto(long f_id, String accountNumberPayee, String accountNumberPayer, String comment,
			long amount) {
		super();
		this.f_id = f_id;
		this.accountNumberPayee = accountNumberPayee;
		this.accountNumberPayer = accountNumberPayer;
		Comment = comment;
		this.amount = amount;
	}
	public long getF_id() {
		return f_id;
	}
	public void setF_id(long f_id) {
		this.f_id = f_id;
	}
	public String getAccountNumberPayee() {
		return accountNumberPayee;
	}
	public void setAccountNumberPayee(String accountNumberPayee) {
		this.accountNumberPayee = accountNumberPayee;
	}
	public String getAccountNumberPayer() {
		return accountNumberPayer;
	}
	public void setAccountNumberPayer(String accountNumberPayer) {
		this.accountNumberPayer = accountNumberPayer;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
}
