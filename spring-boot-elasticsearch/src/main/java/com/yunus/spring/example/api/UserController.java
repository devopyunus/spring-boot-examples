package com.yunus.spring.example.api;

import com.yunus.spring.example.entity.User;
import com.yunus.spring.example.repo.UserElascticRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserElascticRepo userElascticRepo;

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getList(@PathVariable String search){
        List<User> userList = userElascticRepo.getByCustomQuery(search);

        return ResponseEntity.ok(userList);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userElascticRepo.save(user));
    }

}
