package com.almousleck.spring3.service.impl;

import com.almousleck.spring3.models.UserAccount;
import com.almousleck.spring3.service.UserAccountService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountService userAccountService;

    public UserDetailsServiceImpl(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount account = userAccountService.findByUsername(username);
        if ( account == null ) {
            throw new UsernameNotFoundException("User " + username + " not found.");
        }
        if ( account.getRoles() == null || account.getRoles().isEmpty()) {
            throw new UsernameNotFoundException("User has no role.");
        }
        Collection<GrantedAuthority> authorities = account.getRoles()
                .stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return new User(account.getUsername(), account.getPassword(),
                account.isEnable(), !account.isExpired(), !account.isCredentialsExpired(),
                !account.isLocked(), authorities);
    }
}
