package com.spacecoworking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spacecoworking.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/* la méthode matchingPasswordsAndEmail renvoi l'utilisateur possédant l'email et password fournit*/
	
	@Query("SELECT u from User u where u.password=:password AND u.email=:email")
	public User  matchingPasswordsAndEmail(String password,String email);
}
