package dev.Aditi.Splitwise.repository;

import dev.Aditi.Splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
 User findUserByEmail(String email);
}
