package com.fireayehu.taco.api;

import com.fireayehu.taco.domains.User;
import com.fireayehu.taco.repositories.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping(path="/user", produces="application/json")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository newsRepository) {
        this.userRepository = newsRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> newsById(@PathVariable("id") int id) {
        Optional<User> optTaco = userRepository.findById(id);
        if(optTaco.isPresent()) {
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<User> newsByEmail(@PathVariable("email") String email) {
        Optional<User> optTaco = userRepository.findUserByEmail(email);
        if(optTaco.isPresent()) {
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> allNews() {
        Iterable<User> optTaco = userRepository.findAll();
        return new ResponseEntity<>(optTaco,HttpStatus.OK);

    }

    @GetMapping("/role")
    public ResponseEntity<Iterable<User>> findByCategory(@RequestParam(name="role",defaultValue = "MEMBER") String role) {
        Iterable<User> optTaco = userRepository.findUsersByRole(role);
        return new ResponseEntity<>(optTaco,HttpStatus.OK);

    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveTaco(@RequestBody User news) {
        return userRepository.save(news);
    }

    @PutMapping(path="/{id}", consumes="application/json")
    public User wholesaleTacoUpdate(@PathVariable("id") int id, @RequestBody User news) {
        return userRepository.save(news);
    }


    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaco(@PathVariable("id") int id) {
        try {
            userRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e) {

        }
    }

}
