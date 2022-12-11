package com.almousleck.spring3.controller;

import com.almousleck.spring3.models.UserAccount;
import com.almousleck.spring3.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping
    public ResponseEntity<List<UserAccount>> fetchAccounts() {
        return ResponseEntity.ok(userAccountService.fetchAccounts());
    }

    @PostMapping("/register")
    public ResponseEntity<UserAccount> registerAccount(@RequestBody UserAccount userAccount) {
        return ResponseEntity.ok(userAccountService.createAccount(userAccount));
    }


}
