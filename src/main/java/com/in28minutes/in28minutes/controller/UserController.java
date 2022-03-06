package com.in28minutes.in28minutes.controller;

import com.in28minutes.in28minutes.entity.User;
import com.in28minutes.in28minutes.repository.UserRepository;
import com.in28minutes.in28minutes.util.UserNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public EntityModel<User> findById(@PathVariable long userId) {
        return Optional.of(userRepository.findById(userId))
                .map(user -> EntityModel.of(user)
                        .add(linkTo(
                                methodOn(this.getClass()).findAll()).withRel("all users"))
                ).orElseThrow(() -> new UserNotFoundException(userId));
    }

    @PostMapping("/")
    public EntityModel<User> save(@RequestBody User user) {
        return Optional.of(userRepository.save(user))
                .map(savedUser -> EntityModel.of(savedUser).add(linkTo(
                        methodOn(this.getClass()).findAll()).withRel("all users")))
                .get();
    }

    @PutMapping("/")
    public EntityModel<User> update(@RequestBody User user) {
        return Optional.of(userRepository.save(user))
                .map(savedUser -> EntityModel.of(savedUser).add(linkTo(
                        methodOn(this.getClass()).findAll()).withRel("all users")))
                .get();
    }

    @DeleteMapping("/{userId}")
    public EntityModel<?> deleteById(@PathVariable long userId) {
        userRepository.deleteById(userId);
//    EntityModel<User> model = new EntityModel.;
//    WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).findAll());
//    model.add(linkToUsers.withRel("all users"));
//
        return null;
    }
}
