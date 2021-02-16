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
import net.javaguides.springboot.entity.IdConnexion;
import net.javaguides.springboot.repository.IdConnexionRepository;

@RestController
@RequestMapping("/jofeapi")
public class IdConnexionController {
	
	@Autowired
	private IdConnexionRepository idConnexionRepository;
	
	//get historique
	
	@GetMapping("/idConnexion")
	public List<IdConnexion> getAllIdConnexion(){
		return this.idConnexionRepository.findAll();
	}
	
	
	//get historique by id
	
	@GetMapping("/idConnexion/{id}")
	public ResponseEntity<IdConnexion> getIdConnexionById(@PathVariable(value="id") Long hId)
	      throws ResourceNotFoundException{
		IdConnexion htq = idConnexionRepository.findById(hId)
				.orElseThrow(() -> new ResourceNotFoundException("Historique not found for this id"
				+ " :: "+hId));
				return ResponseEntity.ok().body(htq);
		
		
	}
	
	//save historique
	@PostMapping("idConnexion")
	public IdConnexion createIdConnexion(@RequestBody IdConnexion htq) {
		return this.idConnexionRepository.save(htq);
	}
	//update historique
	
	@PutMapping("idConnexion/{id}")
	public ResponseEntity<IdConnexion> updateIdConnexion(@PathVariable(value = "id") Long cId,@Validated @RequestBody IdConnexion cDetails)
	throws ResourceNotFoundException{
		IdConnexion idc = idConnexionRepository.findById(cId)
				.orElseThrow(() -> new ResourceNotFoundException("idConnexion not found for this id"
				+ " :: "+cId));
		idc.setUsername(cDetails.getUsername());
		idc.setPassword(cDetails.getPassword());
		//idc.setCreated_at(cDetails.getCreated_at());
		//idc.setUpdated_at(cDetails.getUpdated_at());
		
		return ResponseEntity.ok(this.idConnexionRepository.save(idc));
		
	}
	
	
	//delete idConnexion
	@DeleteMapping("idConnexion/{id}")
	public Map<String, Boolean> deleteIdConnexion(@PathVariable(value = "id") Long cId) throws ResourceNotFoundException{
		
		IdConnexion idc = idConnexionRepository.findById(cId)
				.orElseThrow(() -> new ResourceNotFoundException("Historique not found for this id"
				+ " :: "+cId));
		
		this.idConnexionRepository.delete(idc);
		
		Map<String ,Boolean> response =new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}

}