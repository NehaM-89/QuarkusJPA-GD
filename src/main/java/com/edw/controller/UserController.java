package com.edw.controller;

import com.edw.entity.User;
import com.edw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <pre>
 *     com.edw.controller.UserController
 * </pre>
 *
 */
@RestController
@RequestMapping("/quarkus")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id).orElse(null);
    }

    @GetMapping("/")
    public String index() {
        return "hello world";
    }

    @PostMapping("/")
    public User create(@RequestBody User user) {
        return userService.insert(user);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return Boolean.TRUE;
    }

    @GetMapping("/exist/{id}")
    public Boolean exist(@PathVariable("id") Long id) {
        return userService.exist(id);
    }

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

}
