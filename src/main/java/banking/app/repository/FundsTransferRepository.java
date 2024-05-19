package banking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import banking.app.entity.FundsTransfer;

public interface FundsTransferRepository extends JpaRepository<FundsTransfer, Long>{

}
