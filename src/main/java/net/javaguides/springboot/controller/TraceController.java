package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import net.javaguides.springboot.entity.Trace;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.TraceRepository;



@RestController
@RequestMapping("/jofeapi")
public class TraceController {


	@Autowired
	private TraceRepository traceRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/traces")
	public List<Trace> getAllTrace(){
		return this.traceRepository.findAll();
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/trace/{id}")
	public ResponseEntity<Trace> getTraceById(@PathVariable(value="id") Long TraceId)
	      throws ResourceNotFoundException{
		Trace trace = traceRepository.findById(TraceId)
				.orElseThrow(() -> new ResourceNotFoundException("Aucune trace de paiement pour ce numero"
				+ " :: "+TraceId));
				return ResponseEntity.ok().body(trace);
		
		
	}
	
}
