package com.yunus.spring.event.api;

import com.yunus.spring.event.dto.UserDto;
import com.yunus.spring.event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> list(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/listPaging")
    public Page<UserDto> listPaging(@RequestParam Integer pageSize,
                                    @RequestParam Integer page){
        Pageable pageable = PageRequest.of(pageSize,page);
        return userService.getAll(pageable);
    }

    @GetMapping("/listSlicing")
    public Slice<UserDto> listSlicing(@RequestParam Integer pageSize,
                                     @RequestParam Integer page){
        Pageable pageable = PageRequest.of(pageSize,page);
        return userService.getAll(pageable);
    }

    @PostMapping("/save")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
