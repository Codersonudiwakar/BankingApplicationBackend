package banking.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import banking.app.entity.Account;
import banking.app.repository.AccountOpenRepository;

@Service
public class UserLoginService implements UserDetailsService{
	
	@Autowired
	AccountOpenRepository userRepo;

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = userRepo.findByAccountNumber(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getAccountNumber(), user.getPassword(), new ArrayList<>());
    }

}
