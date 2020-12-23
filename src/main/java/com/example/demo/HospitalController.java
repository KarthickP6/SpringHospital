package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	public List<Hospital> getAllHospital(){
		return hospitalService.getAllHospital();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hospital> getHospital(@PathVariable int id) throws HospitalNotFoundException {
		return hospitalService.getHospital(id);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> addHospital(@RequestBody Hospital hospital) {
		return hospitalService.addHospital(hospital);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital, @PathVariable int id) throws HospitalNotFoundException {
		return hospitalService.updateHospital(hospital,id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHospital(int id) throws HospitalNotFoundException {
		return hospitalService.deleteHospital(id);
	}

}
