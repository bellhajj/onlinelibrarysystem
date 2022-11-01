/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bagudu.mvp.controller;

import com.bagudu.mvp.model.Users;
import com.bagudu.mvp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author bbagudu
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/addnew")
    public String viewRegisterPage() {
        return "register";
    }

    @PostMapping(value = "/addnew")
    public RedirectView addNew(Users user, RedirectAttributes redir) {

        userService.addUser(user);
        RedirectView redirectView = new RedirectView("/login", true);
        redir.addFlashAttribute("message", "You successfully registered! You can now login");

        return redirectView;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }

}
