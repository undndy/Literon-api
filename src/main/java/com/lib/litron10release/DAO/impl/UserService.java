package com.lib.litron10release.DAO.impl;

import com.lib.litron10release.dto.UserDTO;
import com.lib.litron10release.entity.UserLiter;
import com.lib.litron10release.entity.enums.ERole;
//import com.lib.litron10release.exeptions.UserExistException;
//import com.lib.litron10release.payload.request.SignupRequest;
import com.lib.litron10release.exception.UserExistException;
import com.lib.litron10release.payload.request.SignupRequest;
import com.lib.litron10release.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@AllArgsConstructor
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserLiter createUser(SignupRequest userIn){
        UserLiter userLiter = new UserLiter();
        userLiter.setEmail(userIn.getEmail());
        userLiter.setLastName(userIn.getLastname());
        userLiter.setFirstName(userIn.getFirstname());
        userLiter.setPassword(passwordEncoder.encode(userIn.getPassword()));
        userLiter.getRole().add(ERole.ROLE_USER);
        try {
            return userRepository.save(userLiter);
        }catch (Exception e){
            throw new UserExistException("The user " + userLiter.getUsername() + " already exist. Please check credentials");
        }
    }

    public UserLiter updateUser(UserDTO userDTO, Principal principal) {
        UserLiter user = getUserByPrincipal(principal);
        user.setFirstName(userDTO.getFirstname());
        user.setLastName(userDTO.getLastname());

        return userRepository.save(user);
    }

    public UserLiter getCurrentUser(Principal principal) {
        return getUserByPrincipal(principal);
    }

    private UserLiter getUserByPrincipal(Principal principal) {
        String username = principal.getName();
        return userRepository.findUserLiterByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found with username " + username));

    }

    public UserLiter getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
