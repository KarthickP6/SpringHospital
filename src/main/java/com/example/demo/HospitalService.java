package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	List<Hospital> list = new ArrayList<Hospital>();

	public List<Hospital> getAllHospital() {
		hospitalRepository.findAll().forEach(list::add);
		return list;
	}

	public ResponseEntity<Hospital> getHospital(int id) throws HospitalNotFoundException  {
		Hospital h = hospitalRepository.findById(id).orElseThrow(()-> new HospitalNotFoundException("Hospital id not found:"+id));
		if(h==null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		else
		return new ResponseEntity<>(h,HttpStatus.OK);
	}

	public ResponseEntity<String> addHospital(Hospital hospital) {
		
		if(hospital== null)
			return new ResponseEntity<>("Doesnt contain object", HttpStatus.BAD_REQUEST);
		else {
			hospitalRepository.save(hospital);
			return new ResponseEntity<String>("Successfully inserted", HttpStatus.CREATED);
		}
	}

	public ResponseEntity<String> updateHospital(Hospital hospital, int id) throws HospitalNotFoundException {
		Hospital h = hospitalRepository.findById(id).orElseThrow(()-> new HospitalNotFoundException("Hospital id not found"));
		
		if(h!=null) {
			h.setId(hospital.getId());
			h.setName(hospital.getName());
			
			h.setAddress(hospital.getAddress());
			hospitalRepository.save(h);
			
			return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Id not found", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<String> deleteHospital(int id) throws HospitalNotFoundException {
		
		Hospital h = hospitalRepository.findById(id).orElseThrow(()-> new HospitalNotFoundException("Hospital not found"));
		
		if(h!=null) {
		   	hospitalRepository.deleteById(id);
		   	return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Not found Found", HttpStatus.NOT_FOUND);
		}
	}

}
