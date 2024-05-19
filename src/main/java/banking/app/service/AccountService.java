package banking.app.service;

import java.util.List;

import banking.app.Dto.AccountDto;
import banking.app.Dto.CardDto;
import banking.app.Dto.StatementDto;
import banking.app.entity.Account;
import banking.app.entity.TotalBalance;

public interface AccountService {
	AccountDto getAccountByAccountNumber(String accountNumber);
	Account createAccount(AccountDto accountDTO);
	CardDto getCard(String accountNumber);
//	StatementDto getStatement(String accountNumber);
	 List<StatementDto> getAllStatementByAccountNumber(String accountNumber);
	StatementDto fundsTransfer(StatementDto debitAccount,StatementDto creditAccount,String payeeAccount,String payerAccount);
	TotalBalance getStatementSummary(String accountNumber);
}
