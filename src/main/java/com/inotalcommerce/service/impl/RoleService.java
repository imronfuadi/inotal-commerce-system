package com.inotalcommerce.service.impl;

import java.util.List;
import java.util.Optional;

import com.inotalcommerce.entity.Role;

public interface RoleService {

	public List<Role> findRoleList();
	
	public Optional<Role> findRoleBykd(String kd);
	
	public Role saveRole(String description);
	
	public Role saveUpdateRole(Role role);
	
	public Optional<Role> updateRole(String kd);
	
	public void deleteRole(String kd);
}
