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
import net.javaguides.springboot.entity.Clients;
import net.javaguides.springboot.repository.ClientsRepository;

@RestController
@RequestMapping("/jofeapi")
public class ClientsController {
	
	@Autowired
	private ClientsRepository clientsRepository;
	
	//get clients
	
	@GetMapping("/clients")
	public List<Clients> getAllClients(){
		return this.clientsRepository.findAll();
	}
	
	
	//get client by id
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<Clients> getClientsById(@PathVariable(value="id") Long clientsId)
	      throws ResourceNotFoundException{
		Clients clients = clientsRepository.findById(clientsId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id"
				+ " :: "+clientsId));
				return ResponseEntity.ok().body(clients);
		
		
	}
	
	//save admin
	@PostMapping("clients")
	public Clients createClients(@RequestBody Clients clients) {
		return this.clientsRepository.save(clients);
	}
	//update clients
	
	@PutMapping("clients/{id}")
	public ResponseEntity<Clients> updateClients(@PathVariable(value = "id") Long clientsId,@Validated @RequestBody Clients clientsDetails)
	throws ResourceNotFoundException{
		Clients clients = clientsRepository.findById(clientsId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id"
				+ " :: "+clientsId));
		clients.setNom(clientsDetails.getNom());
		clients.setPrenom(clientsDetails.getPrenom());
		clients.setEmail(clientsDetails.getEmail());
		clients.setTelephone(clientsDetails.getTelephone());
		clients.setNumero_compte(clientsDetails.getNumero_compte());
		clients.setPassword(clientsDetails.getPassword());
		//clients.setCreated_at(clientsDetails.getCreated_at());
		//clients.setUpdated_at(clientsDetails.getUpdated_at());
		
		return ResponseEntity.ok(this.clientsRepository.save(clients));
		
	}
	
	
	//delete client
	@DeleteMapping("clients/{id}")
	public Map<String, Boolean> deleteClients(@PathVariable(value = "id") Long clientsId) throws ResourceNotFoundException{
		
		Clients clients = clientsRepository.findById(clientsId)
				.orElseThrow(() -> new ResourceNotFoundException("Api not found for this id"
				+ " :: "+clientsId));
		
		this.clientsRepository.delete(clients);
		
		Map<String ,Boolean> response =new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}

}