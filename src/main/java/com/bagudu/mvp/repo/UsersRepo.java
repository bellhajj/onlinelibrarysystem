/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bagudu.mvp.repo;

import com.bagudu.mvp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bbagudu
 */
@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    
    Users findByUsername(String username);
}
