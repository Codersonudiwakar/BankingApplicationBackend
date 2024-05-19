package banking.app.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StatementDto {
	long s_id;
	String name;
	String accountNumber;
	LocalDateTime transactionDate;
	String transactionID;
	String transactionType;
	String referanceFrom;
	BigDecimal amount;
	public long getS_id() {
		return s_id;
	}
	public void setS_id(long s_id) {
		this.s_id = s_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getReferanceFrom() {
		return referanceFrom;
	}
	public void setReferanceFrom(String referanceFrom) {
		this.referanceFrom = referanceFrom;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


}
