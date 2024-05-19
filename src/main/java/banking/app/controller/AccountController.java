package banking.app.controller;

import java.util.List;

import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import banking.app.Dto.AccountDto;
import banking.app.Dto.CardDto;
import banking.app.Dto.StatementDto;
import banking.app.Exception.DontHaveSufficentAmount;
import banking.app.entity.Account;
import banking.app.entity.TotalBalance;
import banking.app.service.AccountService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    
    @GetMapping("/hi")
    public String getMethodName() {
        return "This application running";
    }
    
    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDto> getAccountByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        AccountDto accountDTO = accountService.getAccountByAccountNumber(accountNumber);
        if (accountDTO != null) {
            return ResponseEntity.ok().body(accountDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  
    
    @PostMapping("/funds-transfer/{debitAccountNumber}")
    public StatementDto fundsTransfer(@RequestBody StatementDto Statement, @PathVariable("debitAccountNumber") String payerAccount) {
    	String PayeeAccount=Statement.getAccountNumber();
    	TotalBalance bal=accountService.getStatementSummary(payerAccount);
    	double dbamt=bal.getNetBalance().doubleValue();
    	double uamt=Statement.getAmount().doubleValue();
    	
    	if (dbamt>=uamt) {
    		  StatementDto transition=accountService.fundsTransfer(Statement, Statement, PayeeAccount, payerAccount);
    	        return transition;
		}
    	else {
    		System.out.println("You Don't have Sufficent amount");
			throw new DontHaveSufficentAmount("You Don't have Sufficent amount");
		}
      
    } 
    
    @GetMapping("card/{accountNumber}")
    public ResponseEntity<CardDto> getCardByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        CardDto cardDto = accountService.getCard(accountNumber);
        if (cardDto != null) {
            return ResponseEntity.ok().body(cardDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("statement/{accountNumber}")
    public ResponseEntity<List<StatementDto>> getStatementByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
     List<StatementDto> statementDto=accountService.getAllStatementByAccountNumber(accountNumber);
        if (statementDto != null) {
            return ResponseEntity.ok().body(statementDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("balance/{accountNumber}")
    public TotalBalance getStatementSummary(@PathVariable String accountNumber){
        return accountService.getStatementSummary(accountNumber);
    }

    

}
