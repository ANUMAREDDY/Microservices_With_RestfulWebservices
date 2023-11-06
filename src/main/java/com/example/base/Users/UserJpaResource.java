package com.example.base.Users;

import com.example.base.exception.UserNotDefinedException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {
    @Autowired
    private UserDaoService service;

    public UserJpaResource(UserDaoService service) {
        this.service = service;
    }
    @GetMapping(path="/jpa/users")
    public List<User> findAllUsers(){
        return service.findAll();
    }

    @GetMapping(path="/jpa/users/{id}")
    public EntityModel<User> findUsers(@PathVariable int id){
        User user=service.findOne(id);

        if(user==null){
            throw new UserNotDefinedException("id:"+id);}

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).findAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping(path="/jpa/users")
    public ResponseEntity<User> findUsers(@Valid @RequestBody User user){
        User saved= service.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);

    }
}



