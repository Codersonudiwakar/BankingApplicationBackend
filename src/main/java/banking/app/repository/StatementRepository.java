package banking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import banking.app.Dto.StatementDto;
import banking.app.entity.Card;
import banking.app.entity.Statement;

public interface StatementRepository extends JpaRepository<Statement, Long> {

	@Query("SELECT s FROM Statement s WHERE s.accountNumber = :accountNumber")
	 Statement findStatementByAccountNumber(String accountNumber);
	
	List<Statement>  getAllStatementByAccountNumber(String accountNumber);

}
 