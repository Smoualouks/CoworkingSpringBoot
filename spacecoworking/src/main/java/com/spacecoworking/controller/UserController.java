package com.spacecoworking.controller;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spacecoworking.exception.ResourceNotFoundException;
import com.spacecoworking.model.User;
import com.spacecoworking.service.UserService;


@RestController
@RequestMapping("/rest/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/{id}")
	public User findOne(@PathVariable("id") Integer id) throws ResourceNotFoundException {
		return this.userService.findById(id);
	}
	
	@GetMapping
	public Page<User> findAll(Pageable pageable) {
		return this.userService.findAll(pageable);
	}
	
	@PostMapping
	public User createUser(@RequestBody @Valid User userToCreate) {
		return this.userService.create(userToCreate);
	}
	
	@PutMapping
	public User update(@RequestBody User updateUser) {
		return this.userService.update(updateUser);
	}
	
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer user_id)
			throws ResourceNotFoundException{
	   return this.userService.deleteUser(user_id);
	}
	
	@GetMapping("/{email}/{password}")
	
        public User  matchingPasswordsAndEmail (@PathVariable("password")String password,@PathVariable("email") String email) {
		
		return this.userService.matchingPasswordsAndEmail(password, email);
	}
}