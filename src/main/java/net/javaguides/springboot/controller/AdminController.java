package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.entity.Admin;
import net.javaguides.springboot.repository.AdminRepository;

@RestController
@RequestMapping("/jofeapi")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	//get admins
	
	@GetMapping("/admins")
	public List<Admin> getAllAdmin(){
		return this.adminRepository.findAll();
	}
	
	
	//get admin by id
	
	@GetMapping("/admins/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable(value="id") Long AdminId)
	      throws ResourceNotFoundException{
		Admin admin = adminRepository.findById(AdminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id"
				+ " :: "+AdminId));
				return ResponseEntity.ok().body(admin);
		
		
	}
	
	//save admin
	@PostMapping("admins")
	public Admin createAdmin(@RequestBody Admin admin) {
		return this.adminRepository.save(admin);
	}
	//update admins
	
	@PutMapping("admins/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable(value = "id") Long adminId,@Validated @RequestBody Admin adminDetails)
	throws ResourceNotFoundException{
		Admin admin = adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id"
				+ " :: "+adminId));
		admin.setEmail(adminDetails.getEmail());
		admin.setNom(adminDetails.getNom());
		admin.setPrenom(adminDetails.getPrenom());
		admin.setPassword(adminDetails.getPassword());
		
		
		return ResponseEntity.ok(this.adminRepository.save(admin));
		
	}
	
	
	//delete admin
	@DeleteMapping("admins/{id}")
	public Map<String, Boolean> deleteAdmin(@PathVariable(value = "id") Long adminId) throws ResourceNotFoundException{
		
		Admin admin = adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id"
				+ " :: "+adminId));
		
		this.adminRepository.delete(admin);
		
		Map<String ,Boolean> response =new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}

}