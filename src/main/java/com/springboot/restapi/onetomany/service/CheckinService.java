package com.springboot.restapi.onetomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.restapi.onetomany.model.Checkin;
import com.springboot.restapi.onetomany.repository.CheckinRepository;

@Service
public class CheckinService {
	
	@Autowired
	private CheckinRepository cRepository;
	
	public Checkin createALLCheckins(Checkin checkIn) {
		return cRepository.save(checkIn);
	}
	
	public Checkin getCheckinById(Long id)
	{
		return cRepository.findById(id).orElse(null);
	}
	
	public Checkin updateChechin(Long id,Checkin checkIn) {
		if(cRepository.existsById(id)) {
			checkIn.setId(id);
			return cRepository.save(checkIn);
		}
		return null;
	}
	
	public  void deleteCheckin(Long id) {
		cRepository.deleteById(id);
	}

	public Page<Checkin> getAllCheckins(int page, int size) {
        return cRepository.findAll(PageRequest.of(page, size));
    }
	
	 public List<Checkin> getAllCheckInsSorted(String sortBy, String sortDir) {
	        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
	        return cRepository.findAll(sort);
	    }
}
