package banking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import banking.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
	
//	User findByUsername(String username);
}
