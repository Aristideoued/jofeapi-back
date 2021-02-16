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
import net.javaguides.springboot.entity.IdConnectApi;
import net.javaguides.springboot.repository.IdConnectApiRepository;

@RestController
@RequestMapping("/jofeapi")
public class IdConnectApiController {
	
	@Autowired
	private IdConnectApiRepository idConnectApiRepository;
	
	//get clients
	
	@GetMapping("/idConnectApi")
	public List<IdConnectApi> getAllIdConnectApi(){
		return this.idConnectApiRepository.findAll();
	}
	
	
	//get IdConnectApi by id
	
	@GetMapping("/idConnectApi/{id}")
	public ResponseEntity<IdConnectApi> getIdConnectApiById(@PathVariable(value="id") Long cId)
	      throws ResourceNotFoundException{
		IdConnectApi idc = idConnectApiRepository.findById(cId)
				.orElseThrow(() -> new ResourceNotFoundException("IdConnectApi not found for this id"
				+ " :: "+cId));
				return ResponseEntity.ok().body(idc);
		
		
	}
	
	//save admin
	@PostMapping("idConnectApi")
	public IdConnectApi createIdConnectApi(@RequestBody IdConnectApi idc) {
		return this.idConnectApiRepository.save(idc);
	}
	//update clients
	
	@PutMapping("idConnectApi/{id}")
	public ResponseEntity<IdConnectApi> updateIdConnectApi(@PathVariable(value = "id") Long cId,@Validated @RequestBody IdConnectApi cDetails)
	throws ResourceNotFoundException{
		IdConnectApi idc = idConnectApiRepository.findById(cId)
				.orElseThrow(() -> new ResourceNotFoundException("IdConnectApi not found for this id"
				+ " :: "+cId));
		idc.setUsername(cDetails.getUsername());
		idc.setUrl(cDetails.getUrl());
		idc.setNumero_compte(cDetails.getNumero_compte());
		idc.setPassword(cDetails.getPassword());
		//idc.setCreated_at(cDetails.getCreated_at());
		//idc.setUpdated_at(cDetails.getUpdated_at());
		
		return ResponseEntity.ok(this.idConnectApiRepository.save(idc));
		
	}
	
	
	//delete historique
	@DeleteMapping("idConnectApi/{id}")
	public Map<String, Boolean> deleteIdConnectApi(@PathVariable(value = "id") Long cId) throws ResourceNotFoundException{
		
		IdConnectApi idc = idConnectApiRepository.findById(cId)
				.orElseThrow(() -> new ResourceNotFoundException("idConnectApi not found for this id"
				+ " :: "+cId));
		
		this.idConnectApiRepository.delete(idc);
		
		Map<String ,Boolean> response =new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}

}