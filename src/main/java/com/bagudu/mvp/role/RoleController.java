package com.bagudu.mvp.role;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bagudu.mvp.model.Users;
import com.bagudu.mvp.service.UserService;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping("/security/user/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {

        Users user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("userRoles", roleService.getUserRoles(user));
        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
        return "/useredit";
    }

    @RequestMapping("/security/role/assign/{userId}/{roleId}")
    public String assignRole(@PathVariable Long userId, @PathVariable Long roleId) {

        roleService.assignUserRole(userId, roleId);
        return "redirect:/security/user/edit/" + userId;
    }

    @RequestMapping("/security/role/unassign/{userId}/{roleId}")
    public String unassignRole(@PathVariable Long userId, @PathVariable Long roleId) {

        roleService.unassignUserRole(userId, roleId);
        return "redirect:/security/user/edit/" + userId;
    }

    @GetMapping("/roles")
    public String getRoles(Model model) {

        List<Role> roleList = roleService.getRoles();
        model.addAttribute("roles", roleList);

        return "role";
    }

    @PostMapping("/roles/addnew")
    public String addRole(Role role) {

        roleService.addRole(role);
        return "redirect:/roles";
    }

    @RequestMapping("/roles/findbyid")
    @ResponseBody
    public Optional<Role> findById(Long id) {

        return roleService.findById(id);
    }

    @RequestMapping(value = "/roles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateRole(Role role) {

        roleService.addRole(role);
        return "redirect:/roles";
    }

    @RequestMapping(value = "/roles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteRole(Long id) {
        roleService.delete(id);
        return "redirect:/roles";
    }

}
