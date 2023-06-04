package com.lib.litron10release.controller;

import com.lib.litron10release.DAO.impl.UserService;
import com.lib.litron10release.exception.ErrorResponse;
import com.lib.litron10release.payload.request.LoginRequest;
import com.lib.litron10release.payload.request.SignupRequest;
import com.lib.litron10release.payload.response.JWTTokenSuccessResponse;
import com.lib.litron10release.security.JWWTTokenProvider;
import com.lib.litron10release.security.SecurityConstants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("api/auth")
public class AuthController {
    public static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private JWWTTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<Object> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = SecurityConstants.TOKEN_PREFIX + jwtTokenProvider.generateToken(authentication);
        System.out.println(jwt);
        return ResponseEntity.ok(new JWTTokenSuccessResponse(true, jwt));
    }


    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody SignupRequest signupRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            LOG.error("Validation errors: {}", errors);
            return ResponseEntity.badRequest().body(new ErrorResponse("Validation errors", errors));
        }

        userService.createUser(signupRequest);
        LOG.info("User registered successfully!");
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signupRequest.getEmail(), signupRequest.getPassword())
        );

        // Generate JWT token
        String jwt = SecurityConstants.TOKEN_PREFIX + jwtTokenProvider.generateToken(authentication);

        // Return the token to the client
        return ResponseEntity.ok(new JWTTokenSuccessResponse(true, jwt));
    }
}
