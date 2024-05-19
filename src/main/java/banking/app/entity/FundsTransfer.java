package banking.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "funds_transfer")
public class FundsTransfer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long f_id;
	String accountNumberPayee;
	String accountNumberPayer;
	String Comment;
	long amount;
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
