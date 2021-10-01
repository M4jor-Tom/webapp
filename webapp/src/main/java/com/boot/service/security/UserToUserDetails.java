
package com.boot.service.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.boot.entities.User;

@Component
public class UserToUserDetails implements Converter<User, UserDetails> {
    @Override
    public UserDetails convert(User user) {
        UserDetailsImpl userDetails = new UserDetailsImpl();

        if (user != null) {
            userDetails.setEnabled(user.getEnabled());
            userDetails.setPassword(user.getEncryptedPassword());
            userDetails.setUsername(user.getUsername());
            
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
            });
            
            userDetails.setAuthorities(authorities);
        }

        return userDetails;
    }
}