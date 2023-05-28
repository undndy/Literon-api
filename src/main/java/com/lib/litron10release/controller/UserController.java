package com.lib.litron10release.controller;

import com.lib.litron10release.DAO.impl.UserService;
import com.lib.litron10release.entity.UserLiter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.security.Principal;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{user_id}")
    public ResponseEntity<UserLiter> getUserById(@PathVariable("user_id") Long userId){
        UserLiter userLiter = userService.getUserById(userId);
        return new ResponseEntity<>(userLiter, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<UserLiter> getCurrentUser(Principal principal) {
        UserLiter user = userService.getCurrentUser(principal);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
