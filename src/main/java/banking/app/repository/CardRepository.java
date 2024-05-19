package banking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import banking.app.Dto.CardDto;
import banking.app.entity.Account;
import banking.app.entity.Card;


public interface CardRepository extends JpaRepository<Card, Long>{
	
	@Query("SELECT c FROM Card c WHERE c.accountNumber = :accountNumber")
	 Card findCardByAccountNumber(String accountNumber);

}
