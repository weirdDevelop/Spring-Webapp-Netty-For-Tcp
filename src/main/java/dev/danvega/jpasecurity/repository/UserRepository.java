package dev.danvega.jpasecurity.repository;

import dev.danvega.jpasecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmailAddress(String emailAddress);

}
