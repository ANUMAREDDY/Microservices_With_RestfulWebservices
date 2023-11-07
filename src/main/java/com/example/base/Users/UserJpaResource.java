package com.example.base.Users;

import com.example.base.exception.UserNotDefinedException;
import com.example.base.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {
    @Autowired
    private UserRepository repository;

    public UserJpaResource(UserRepository repository) {
        this.repository=repository;
    }
    @GetMapping(path="/jpa/users")
    public List<User> findAllUsers(){
        return repository.findAll();
    }

    @GetMapping(path="/jpa/users/{id}")
    public EntityModel<User> findUsers(@PathVariable int id){
        Optional<User> user=repository.findById(id);

        if(user.isEmpty()){
            throw new UserNotDefinedException("id:"+id);}

        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).findAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping(path="/jpa/users")
    public ResponseEntity<User> findUsers(@Valid @RequestBody User user){
        User saved= repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);

    }
    @GetMapping(path="/jpa/users/{id}/posts")
    public List<Post> retrieveAllThePostsOfAUser(@PathVariable int id){
        Optional<User> user=repository.findById(id);

        if(user.isEmpty()){
            throw new UserNotDefinedException("id:"+id);}

        return user.get().getPosts();


    }
}



