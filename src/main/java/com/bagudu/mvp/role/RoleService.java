package com.bagudu.mvp.role;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.mvp.model.Users;
import com.bagudu.mvp.repo.UsersRepo;


@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UsersRepo usersRepo;
	
	//Return List of role
	public List<Role> getRoles(){
		return roleRepository.findAll();
	}
	
	//Save New Role
	public void addRole(Role role) {
		roleRepository.save(role);
	}
	
	//Edit role
	public Optional<Role> findById(Long id) {
		return roleRepository.findById(id);
	}

	//Delete role
	public void delete(Long id) {
		roleRepository.deleteById(id);
		
	}	
	
	public void assignUserRole(Long userId, Long roleId) {
		
		Users user = usersRepo.findById(userId).orElse(null);
		Role role = roleRepository.findById(roleId).orElse(null);
		
		Set<Role> userRoles = user.getRoles();
		userRoles.add(role);
		user.setRoles(userRoles);
		
		usersRepo.save(user);
	}
	
	public void unassignUserRole(Long userId, Long roleId) {
		
		Users user = usersRepo.findById(userId).orElse(null);
		Set<Role> userRoles = user.getRoles();
		
		userRoles.removeIf(x -> x.getId() == roleId);
		usersRepo.save(user);
	}
	
	public Set<Role> getUserRoles(Users user){
		return user.getRoles();
	}
	
	//Roles that are not assigned to the user
	public Set<Role> getUserNotRoles(Users user){
		
		return roleRepository.getUserNotRoles(user.getId());
	}
	
	
}
