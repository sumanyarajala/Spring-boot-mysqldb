package com.techprimers.db.resource;

import com.techprimers.db.model.Users;
import com.techprimers.db.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {

	@Autowired
	UsersRepository usersRepository;

	@GetMapping(value = "/get")
	public List<Users> getAll() {
		return usersRepository.findAll();
	}

	@PostMapping(value = "/post")
    public List<Users> persistPost(@RequestBody Users users) {
        usersRepository.save(users);
        return usersRepository.findAll();
    }

	@DeleteMapping(value = "/delete/{id}")
    public void persistDelete(@PathVariable int id) {
        usersRepository.delete(id);
       
    }

}
