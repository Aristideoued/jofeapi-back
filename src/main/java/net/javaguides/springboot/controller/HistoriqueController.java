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
import net.javaguides.springboot.entity.Historique;
import net.javaguides.springboot.repository.HistoriqueRepository;

@RestController
@RequestMapping("/jofeapi")
public class HistoriqueController {
	
	@Autowired
	private HistoriqueRepository historiqueRepository;
	
	//get historique
	
	@GetMapping("/historique")
	public List<Historique> getAllHistorique(){
		return this.historiqueRepository.findAll();
	}
	
	
	//get historique by id
	
	@GetMapping("/historique/{id}")
	public ResponseEntity<Historique> getHistoriqueById(@PathVariable(value="id") Long hId)
	      throws ResourceNotFoundException{
		Historique htq = historiqueRepository.findById(hId)
				.orElseThrow(() -> new ResourceNotFoundException("Historique not found for this id"
				+ " :: "+hId));
				return ResponseEntity.ok().body(htq);
		
		
	}
	
	//save historique
	@PostMapping("historiques")
	public Historique createHistorique(@RequestBody Historique htq) {
		return this.historiqueRepository.save(htq);
	}
	//update historique
	
	@PutMapping("historique/{id}")
	public ResponseEntity<Historique> updateHistorique(@PathVariable(value = "id") Long hId,@Validated @RequestBody Historique htqDetails)
	throws ResourceNotFoundException{
		Historique htq = historiqueRepository.findById(hId)
				.orElseThrow(() -> new ResourceNotFoundException("Historique not found for this id"
				+ " :: "+hId));
	
		//htq.setCreated_at(htqDetails.getCreated_at());
		//htq.setUpdated_at(htqDetails.getUpdated_at());
		
		return ResponseEntity.ok(this.historiqueRepository.save(htq));
		
	}
	
	
	//delete historique
	@DeleteMapping("historique/{id}")
	public Map<String, Boolean> deleteHistorique(@PathVariable(value = "id") Long hId) throws ResourceNotFoundException{
		
		Historique htq = historiqueRepository.findById(hId)
				.orElseThrow(() -> new ResourceNotFoundException("Historique not found for this id"
				+ " :: "+hId));
		
		this.historiqueRepository.delete(htq);
		
		Map<String ,Boolean> response =new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}

}