/*package net.javaguides.springboot.controller;

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
import net.javaguides.springboot.model.Employe;
import net.javaguides.springboot.repository.EmployeRepository;

@RestController
@RequestMapping("/api")
public class EmployeController {
	
	@Autowired
	private EmployeRepository employeRepository;
	
	//get employes
	
	@GetMapping("/employes")
	public List<Employe> getAllEmploye(){
		return this.employeRepository.findAll();
	}
	
	
	//get employes by id
	
	@GetMapping("/employes/{id}")
	public ResponseEntity<Employe> getEmployeById(@PathVariable(value="id") Long employeId)
	      throws ResourceNotFoundException{
		Employe employe = employeRepository.findById(employeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employe not found for this id"
				+ " :: "+employeId));
				return ResponseEntity.ok().body(employe);
		
		
	}
	
	//save employes
	@PostMapping("employes")
	public Employe createEmploye(@RequestBody Employe employe) {
		return this.employeRepository.save(employe);
	}
	//update employes
	
	@PutMapping("employes/{id}")
	public ResponseEntity<Employe> updateEmploye(@PathVariable(value = "id") Long employeId,@Validated @RequestBody Employe employeDetails)
	throws ResourceNotFoundException{
		Employe employe = employeRepository.findById(employeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employe not found for this id"
				+ " :: "+employeId));
		employe.setEmail(employeDetails.getEmail());
		employe.setFirstName(employeDetails.getFirstName());
		employe.setLastName(employeDetails.getLastName());
		
		return ResponseEntity.ok(this.employeRepository.save(employe));
		
	}
	
	
	//delete employes
	@DeleteMapping("employes/{id}")
	public Map<String, Boolean> deleteEmploye(@PathVariable(value = "id") Long employeId) throws ResourceNotFoundException{
		
		Employe employe = employeRepository.findById(employeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employe not found for this id"
				+ " :: "+employeId));
		
		this.employeRepository.delete(employe);
		
		Map<String ,Boolean> response =new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}

}*/
