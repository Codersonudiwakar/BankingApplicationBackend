package banking.app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import banking.app.Dto.AccountDto;
import banking.app.Dto.AddressDto;
import banking.app.Dto.CardDto;
import banking.app.Dto.StatementDto;
import banking.app.Dto.BalanceDto;
import banking.app.Dto.UsersDto;
import banking.app.entity.Account;
import banking.app.entity.Address;
import banking.app.entity.Card;
import banking.app.entity.GenerateUniqueNumber;
import banking.app.entity.Statement;
import banking.app.entity.TotalBalance;
import banking.app.entity.User;
import banking.app.repository.AccountOpenRepository;
import banking.app.repository.CardRepository;
import banking.app.repository.StatementRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountOpenRepository accountRepo;
	
	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	CardRepository cardRepo;
	
	@Autowired
	StatementRepository statementRepo;

	private final ModelMapper modelMapper;
	GenerateUniqueNumber ac=new GenerateUniqueNumber();

	@Autowired
	public AccountServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
	//	this.passwordEncoder = null;
        this.passwordEncoder = passwordEncoder;

		this.modelMapper = modelMapper;
	}

	@Override
	public AccountDto getAccountByAccountNumber(String accountNumber) {
		Account account = accountRepo.findByAccountNumber(accountNumber);
		if (account != null) {
			return convertToDTO(account);
		}
		return null;
	}

	@Override
	public Account createAccount(AccountDto accountDto) {
		GenerateUniqueNumber ac=new GenerateUniqueNumber();
		String accNum=ac.generateAccountNumber();
		accountDto.setPassword(passwordEncoder.encode(accountDto.getPassword()));
		accountDto.setAccountNumber(accNum);
	//	account.setPassword(passwordEncoder.encode(account.getPassword()));
		CardDto cardDto=new CardDto();
		cardDto.setAccountNumber(accNum);
		cardDto.setCardNumber(ac.generateCardNumber());
		cardDto.setCardHolderName(accountDto.getFullName());
		cardDto.setCvv(ac.generateCvvNumber());
		accountDto.setCardDto(cardDto);
		Account account=convertToEntity(accountDto);
		accountRepo.save(account);
	    return account;
	}

	public AccountDto convertToDTO(Account account) {
		AddressDto addressDto=convertEntityToAddressDto(account.getAddress());
		CardDto cardDto=convertToCardDTO(account.getCard());
		AccountDto accountDto = modelMapper.map(account, AccountDto.class);
		accountDto.setCardDto(cardDto);
		accountDto.setAddressDto(addressDto);
	    return accountDto;
	}	

	public Account convertToEntity(AccountDto accountDto) {
		 Address address=convertAddressDtoToEntity(accountDto.getAddressDto());
		 Card card=mapCardEntity(accountDto.getCardDto()); 
		 Account account=modelMapper.map(accountDto, Account.class);
		 account.setAddress(address);
		 account.setCard(card);
	    return account;
	}
	
	public AddressDto convertEntityToAddressDto(Address address) {
		AddressDto dto=new AddressDto();
		dto.setHomeNo(address.getHomeNo());
		dto.setAreaTwon(address.getAreaTwon());
		dto.setCity(address.getCity());
		dto.setState(address.getState());
		dto.setZipCode(address.getZipCode());
		return dto;
	}
	
	public Address convertAddressDtoToEntity(AddressDto addressDto) {
		Address address=new Address();
		address.setHomeNo(addressDto.getHomeNo());
		address.setAreaTwon(addressDto.getAreaTwon());
		address.setCity(addressDto.getCity());
		address.setState(addressDto.getState());
		address.setZipCode(addressDto.getZipCode());
		return address;
	}

	public StatementDto convertToStatementDTO(Statement statement) {
		StatementDto statementDto = modelMapper.map(statement, StatementDto.class);
		return statementDto;
	}


	@Override
	public CardDto getCard(String accountNumber) {
		Card card = cardRepo.findCardByAccountNumber(accountNumber);
		if (card != null) {
			return convertToCardDTO(card);
		}
		return null;
	}
	
	public Card mapCardEntity(CardDto cardDto) {
		Card card = new Card();
        card.setAccountNumber(cardDto.getAccountNumber());
        card.setCardNumber(cardDto.getCardNumber());
        card.setCardHolderName(cardDto.getCardHolderName());
        card.setCardExpiryData(cardDto.getCardExpiryData());
        card.setCvv(cardDto.getCvv());
		return card;
    }
	
	public CardDto convertToCardDTO(Card card) {
        CardDto cardDto = new CardDto();
        cardDto.setAccountNumber(card.getAccountNumber());
        cardDto.setCardNumber(card.getCardNumber());
        cardDto.setCardHolderName(card.getCardHolderName());
        cardDto.setCardExpiryData(card.getCardExpiryData());
        cardDto.setCvv(card.getCvv());
		return cardDto;
	}
	
	
	public static Statement mapCreditEntity(StatementDto statementDto) {
		Statement statement=new Statement();
		statement.setName(statementDto.getName());
		statement.setAccountNumber(statementDto.getAccountNumber());
		statement.setTransactionData(statementDto.getTransactionDate());
		statement.setTransactionID(statementDto.getTransactionID());
		statement.setTransactionType("Credit");
		statement.setReferanceFrom(statementDto.getReferanceFrom());
		statement.setAmount(statementDto.getAmount());
		return statement;
    }
	
	public static StatementDto mapCreditDto(Statement statement){
		StatementDto statementDto=new StatementDto();
		statementDto.setName(statement.getName());
		statementDto.setAccountNumber(statement.getAccountNumber());
		statementDto.setTransactionDate(statement.getTransactionDate());
		statementDto.setTransactionID(statement.getTransactionID());
		statementDto.setTransactionType("Credit");
		statementDto.setReferanceFrom(statement.getReferanceFrom());
		statementDto.setAmount(statement.getAmount());
		return statementDto; 
    }
	
	public static Statement mapDebitEntity(StatementDto statementDto) {
		Statement statement=new Statement();
		statement.setName(statementDto.getName());
		statement.setAccountNumber(statementDto.getAccountNumber());
		statement.setTransactionData(statementDto.getTransactionDate());
		statement.setTransactionID(statementDto.getTransactionID());
		statement.setTransactionType("Debit");
		statement.setReferanceFrom(statementDto.getReferanceFrom());
		statement.setAmount(statementDto.getAmount());
		return statement;
    }
	
	public static StatementDto mapDebitDto(Statement statement){
		StatementDto statementDto=new StatementDto();
		statementDto.setName(statement.getName());
		statementDto.setAccountNumber(statement.getAccountNumber());
		statementDto.setTransactionDate(statement.getTransactionDate());
		statementDto.setTransactionID(statement.getTransactionID());
		statementDto.setTransactionType("Debit");
		statementDto.setReferanceFrom(statement.getReferanceFrom());
		statementDto.setAmount(statement.getAmount());
		return statementDto; 
    }
	public StatementDto fundsTransfer(StatementDto debitAccount,StatementDto creditAccount,String payeeAccount,String payerAccount) {
		String transID=ac.generateTransitionID();
		Statement statement1=mapCreditEntity(creditAccount);
		statement1.setReferanceFrom(payerAccount+"user");
		statement1.setTransactionID("trns"+transID);
		Statement statement2=mapDebitEntity(debitAccount);
		statement2.setTransactionID("trns"+transID);
		statement2.setAccountNumber(payerAccount);
		statement2.setReferanceFrom(payeeAccount);
		Account checkAccount=accountRepo.findByAccountNumber(payeeAccount);
		System.out.println(checkAccount);
		if (checkAccount!=null) {	
		Statement saveCreditAccount=statementRepo.save(statement1);
		Statement saveDebitAccount=statementRepo.save(statement2);
		}
		return mapCreditDto(statement1);
	}
	
	 @Override
	    public List<StatementDto> getAllStatementByAccountNumber(String accountNumber) {
	        List<Statement> statements = statementRepo.getAllStatementByAccountNumber(accountNumber);
	        List<StatementDto> statementDtos = new ArrayList<>();
	        for (Statement statement : statements) {
	            StatementDto statementDTO =convertToStatementDTO(statement);
	            statementDtos.add(statementDTO);
	        }
	        return statementDtos;
	    }

	@Override
	public TotalBalance getStatementSummary(String accountNumber){
		List<Object[]> resultList =accountRepo.getStatementSummary(accountNumber);
		TotalBalance summary = new TotalBalance();
        for (Object[] result : resultList) {
            summary.setAccountNumber((String) result[0]);
            summary.setCreditTotal(((BigDecimal) result[1]).doubleValue());
            summary.setDebitTotal(((BigDecimal) result[2]).doubleValue());
            summary.setNetBalance(((BigDecimal) result[3]).doubleValue());
        }
        return summary;
	}
    

}
