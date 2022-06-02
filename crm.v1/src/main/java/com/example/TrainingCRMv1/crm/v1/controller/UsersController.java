package com.example.TrainingCRMv1.crm.v1.controller;

import com.example.TrainingCRMv1.crm.v1.entity.Users;
import com.example.TrainingCRMv1.crm.v1.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {
    private UsersService usersService;
    public UsersController(UsersService userService){
        this.usersService = userService;
    }
    @GetMapping("/all")
    public List<Users> findAll(@RequestBody String email){
        return usersService.findAll(email);
    }


    @PostMapping("/add")
    public ResponseEntity<Users> add(@RequestBody Users user){
        if(user.getUserId() != null)
            return new ResponseEntity("user ID have to be empty", HttpStatus.NOT_ACCEPTABLE);
        if(user.getEmail()==null || user.getUsername()==null ||user.getPassword()==null)
            return new ResponseEntity("email, username and password cannot be empty", HttpStatus.NOT_ACCEPTABLE);
        return ResponseEntity.ok(usersService.add(user));
    }
    @PutMapping("/update")
    public ResponseEntity<Users> update(@RequestBody Users user){
        if(user.getUserId()==null)
            return new ResponseEntity("please insert ID of a user you want to update",HttpStatus.NOT_ACCEPTABLE);
        if(user.getEmail()==null || user.getUsername()==null || user.getPassword()==null)
            return new ResponseEntity("fields username, password and  email cannot be empty", HttpStatus.NOT_ACCEPTABLE);
        usersService.update(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Users user){
        usersService.delete(user);
    }

    @DeleteMapping("/deletebyid")
    public void delete(@RequestBody Long id){
        usersService.deleteById(id);
    }


}
