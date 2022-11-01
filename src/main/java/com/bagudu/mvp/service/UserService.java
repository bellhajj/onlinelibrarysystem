/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.mvp.service;

import com.bagudu.mvp.model.Users;
import com.bagudu.mvp.repo.UsersRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author bbagudu
 */
@Service
public class UserService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    //Save New User
    public void addUser(Users user) {

        user.setPassword(encoder.encode(user.getPassword()));
        usersRepo.save(user);
    }

    //Get User By Id
    public Users findById(long id) {
        return usersRepo.findById(id).orElse(null);
    }

    //Get All Users
    public List<Users> findAll() {
        return usersRepo.findAll();
    }

    //Delete User
    public void delete(Long id) {
        usersRepo.deleteById(id);
    }

    //Update User
    public void save(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        usersRepo.save(user);
    }

}
