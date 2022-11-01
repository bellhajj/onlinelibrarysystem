/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.mvp.model;

import com.bagudu.mvp.role.Role;
import java.util.HashSet;
import java.util.Set;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author bbagudu
 */
@Entity
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String username;
    private String password;
    private String name;
    private String imageUrl;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {
                @JoinColumn(name = "user_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "role_id")}
    )
    Set<Role> roles = new HashSet<>();

    public Users() {

    }

    public Users(String email, String username, String password, String name, String imageUrl) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {

        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
