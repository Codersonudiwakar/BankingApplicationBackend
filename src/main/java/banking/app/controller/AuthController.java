package banking.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import banking.app.Configuration.AuthenticationResponse;
import banking.app.Configuration.JwtHelper;
import banking.app.Dto.AccountDto;
import banking.app.entity.Account;
import banking.app.service.AccountService;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
	
	@Autowired
	AccountService accountService;

	 @Autowired
	    private UserDetailsService userDetailsService;

	    @Autowired
	    private AuthenticationManager manager;


	    @Autowired
	    private JwtHelper helper;

	    private Logger logger = LoggerFactory.getLogger(AuthController.class);


	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody JwtRequest request) {
	    	
	    	System.out.println(request.getAccountNum());
	    	System.out.println(request.getPassword());

	        this.doAuthenticate(request.getAccountNum(), request.getPassword());


	        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getAccountNum());
	        
	        final String username = userDetails.getUsername();
	       final String token = this.helper.generateToken(userDetails);
	        return ResponseEntity.ok(new AuthenticationResponse(token, username));
	    }

	    private void doAuthenticate(String email, String password) {

	        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
	        try {
	            manager.authenticate(authentication);


	        } catch (BadCredentialsException e) {
	            throw new BadCredentialsException(" Invalid Username or Password  !!");
	        }

	    }

    

    
    @PostMapping("/signup")
    public Account createAccount(@RequestBody AccountDto AccountDto) {
    	Account createdAccountDto=accountService.createAccount(AccountDto);
        return createdAccountDto ;
    }

}
