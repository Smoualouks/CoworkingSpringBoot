package com.spacecoworking.service;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.spacecoworking.exception.ResourceNotFoundException;
import com.spacecoworking.model.User;
import com.spacecoworking.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	/* la méthode findById renvoi l'utilisateur via son Id sinon un message d'érreur s'il est introuvable*/
	
	public User findById(Integer user_id) throws ResourceNotFoundException{
		
		User user = this.userRepository.findById(user_id)
				.orElseThrow(() -> new ResourceNotFoundException(" Sorry the User is not found for the id : " + user_id));
		return user;	
	}
	
	/* la méthode finAll renvoie tous les utilisateurs de table user*/
	
	public Page<User> findAll(Pageable pageable) {
		
		return this.userRepository.findAll(pageable);
				
	}
	
	/* la méthode create ajouter un utilisateur dans la table user*/
	
	public User create(User userToCreate) {
		return this.userRepository.save(userToCreate);
	}
	
	/* la méthode update permet de modifier les informations d'un utilisateur sur la stable*/
	
	public User update(User userToUpdate) {
		return this.userRepository.save(userToUpdate);
	}
	
	/* la méthode deleteUser surpime un utilisateur avec confirmation via son Id sinon elle  renvoi un message d'érreur 
	 * si l'utilisateur est introuvable.
	 */
	
	public Map<String, Boolean> deleteUser( Integer user_id)
			throws ResourceNotFoundException {
		User user = userRepository.findById(user_id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id : " + user_id));

		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	/* la méthode atchingPasswordsAndEmail nous renvoi l'utilisateur dont l'email et le mot de pass son dans la base*/
	
	public User matchingPasswordsAndEmail(String password,String email)  {
		
		return this.userRepository.matchingPasswordsAndEmail(password, email);
				
	}
}
