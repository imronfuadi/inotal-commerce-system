package com.inotalcommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inotalcommerce.entity.Role;
import com.inotalcommerce.generator.IdGenerator;
import com.inotalcommerce.repository.RoleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

	@Autowired
	public final RoleRepository roleRepository;
	
	@Override
	public List<Role> findRoleList() {
		return roleRepository.findAll();
	}

	@Override
	public Optional<Role> findRoleBykd(String kd) {
		// TODO Auto-generated method stub
		return roleRepository.findById(kd);
	}

	@Override
	public Role saveRole(String description) {
		String roleId = IdGenerator.generateRoleId();
		Role newRole = new Role();
		newRole.setKd(roleId);
		newRole.setDescription(description);
		return roleRepository.save(newRole);
	}

	@Override
	public Optional<Role> updateRole(String kd) {
		// TODO Auto-generated method stub
		return roleRepository.findById(kd);
	}

	@Override
	public void deleteRole(String kd) {
		roleRepository.deleteById(kd);
	}

	@Override
	public Role saveUpdateRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

}
