package banking.app.entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class TotalBalance{
	private String accountNumber;
    private Double creditTotal;
    private Double debitTotal;
    private Double netBalance;
    
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getCreditTotal() {
		return creditTotal;
	}
	public void setCreditTotal(Double creditTotal) {
		this.creditTotal = creditTotal;
	}
	public Double getDebitTotal() {
		return debitTotal;
	}
	public void setDebitTotal(Double debitTotal) {
		this.debitTotal = debitTotal;
	}
	public Double getNetBalance() {
		return netBalance;
	}
	public void setNetBalance(Double netBalance) {
		this.netBalance = netBalance;
	}
}
