package com.inotalcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inotalcommerce.entity.Role;
import com.inotalcommerce.service.impl.RoleServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private final RoleServiceImpl roleServiceImpl;
	
	@GetMapping("/list")
	public String findRoleList(Model model) {
		model.addAttribute("role", roleServiceImpl.findRoleList());
		return "be/role/role";
	}
	
	@GetMapping("/new")
	public String loadRoleForm(Model model) {
		Role role = new Role();
		model.addAttribute("addRole", role);
		return "be/role/addRole";
	}
	
	@PostMapping("/submit")
	public String saveRole(@RequestParam("description") String description) {
		roleServiceImpl.saveRole(description);
		return "redirect:/role/list";
	}
	
	@GetMapping("/edit/{kd}")
	public String loadEditRoleForm(Model model, @PathVariable(value = "kd")String kd) {
		Role role = roleServiceImpl.findRoleBykd(kd).orElseThrow(() -> new IllegalArgumentException("Gagal mendapatkan id: " + kd));;
		model.addAttribute("editRole", role);
		System.out.println(role);
		return "be/role/editRole";
	}
	
	@PostMapping("/update/{kd}")
	public String updateRole(@ModelAttribute(value = "role")Role role) {
		roleServiceImpl.saveUpdateRole(role);
		return "redirect:/role/list";
	}
	
	@GetMapping("delete/{kd}")
	public String deleteRole(@PathVariable(value = "kd")String kd) {
		roleServiceImpl.deleteRole(kd);
		System.out.println(kd);
		return "redirect:/role/list";
	}
}
