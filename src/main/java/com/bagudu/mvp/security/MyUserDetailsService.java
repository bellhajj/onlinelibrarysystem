/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.mvp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bagudu.mvp.model.Users;
import com.bagudu.mvp.repo.UsersRepo;

/**
 *
 * @author bbagudu
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        return new UserPrincipal(user);
    }
}
