package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class ReaderController {
    private UserService userService;

    public ReaderController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.fetchData();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Integer userId){
        Optional<User> userOptional = userService.fetchData().stream().filter(u-> u.getId() == userId).findFirst();

        if(!userOptional.isPresent()){
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok(userOptional.get());
        }
    }
}
