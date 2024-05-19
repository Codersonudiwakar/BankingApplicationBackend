package banking.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.google.protobuf.Option;

import banking.app.Dto.AccountDto;
import banking.app.entity.Account;
import banking.app.entity.TotalBalance;

import java.util.List;
import java.util.Optional;


public interface AccountOpenRepository extends JpaRepository<Account, Long> {
	
	 Account findByAccountNumber(String accountNumber); 
	 @Query("SELECT s.accountNumber, " +
	            "SUM(CASE WHEN s.transactionType = 'credit' THEN s.amount ELSE 0 END) AS creditTotal, " +
	            "SUM(CASE WHEN s.transactionType = 'debit' THEN s.amount ELSE 0 END) AS debitTotal, " +
	            "SUM(CASE WHEN s.transactionType = 'credit' THEN s.amount ELSE -s.amount END) AS netBalance " +
	            "FROM Statement s " +
	            "WHERE s.accountNumber = :accountNumber " +
	            "GROUP BY s.accountNumber")
	  List<Object[]> getStatementSummary(String accountNumber);
}
