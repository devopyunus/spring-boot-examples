package com.yunus.spring.pagination.api;

import com.yunus.spring.pagination.entity.User;
import com.yunus.spring.pagination.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/list")
    public ResponseEntity<List<User>> list(){
        return ResponseEntity.ok(userRepo.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userRepo.save(user));
    }

}