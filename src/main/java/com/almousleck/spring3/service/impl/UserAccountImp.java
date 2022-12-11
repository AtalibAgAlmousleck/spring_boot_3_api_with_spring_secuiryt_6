package com.almousleck.spring3.service.impl;

import com.almousleck.spring3.models.Role;
import com.almousleck.spring3.models.UserAccount;
import com.almousleck.spring3.repository.RoleRepository;
import com.almousleck.spring3.repository.UserAccountRepository;
import com.almousleck.spring3.service.UserAccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserAccountImp implements UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountImp(UserAccountRepository userAccountRepository,
                          RoleRepository roleRepository,
                          PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount createAccount(UserAccount userAccount) {
       userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        userAccount.setRoles(roles);
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount findByUsername(String username) {
        return userAccountRepository.findByUsername(username);
    }

    @Override
    public List<UserAccount> fetchAccounts() {
        return userAccountRepository.findAll();
    }
}
