package edu.RetailPosApplication.repository;
import edu.RetailPosApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
