package com.yunus.spring.swagger.api;

import com.yunus.spring.swagger.dto.UserDto;
import com.yunus.spring.swagger.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value ="Use API")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @ApiOperation(value = "Show user list", notes = "Show all users")
    public ResponseEntity<List<UserDto>> list(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/save")
    @ApiOperation(value = "Add user model", notes = "insert user item")
    public ResponseEntity<UserDto> save(@RequestBody @ApiParam(value = "UserDto") UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
