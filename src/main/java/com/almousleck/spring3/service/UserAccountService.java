package com.almousleck.spring3.service;

import com.almousleck.spring3.models.UserAccount;

import java.util.List;

public interface UserAccountService {

    // create an account
    UserAccount createAccount(UserAccount userAccount);
    // find an account by username
    UserAccount findByUsername(String username);
    // Accounts
    List<UserAccount> fetchAccounts();
}
