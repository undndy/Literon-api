package com.lib.litron10release.DAO.impl;

import com.lib.litron10release.entity.UserLiter;
import com.lib.litron10release.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserLiter loadUserById(Long id) {
        return userRepository.findUserById(id).orElse(null);
    }


    public static UserLiter build(UserLiter userLiter) {
        List<GrantedAuthority> authorities = userLiter.getRole().stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());

        return new UserLiter(
                userLiter.getId(),
                userLiter.getEmail(),
                userLiter.getPassword(),
                authorities);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLiter userLiter = userRepository.findUserLiterByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
        return build(userLiter);
    }
}

