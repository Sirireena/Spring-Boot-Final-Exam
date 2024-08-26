package com.springboot.restapi.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.onetomany.model.Checkin;
import com.springboot.restapi.onetomany.service.CheckinService;

@RestController
@RequestMapping("/api/check-in")
public class CheckinController {
	
	@Autowired
	 private CheckinService checkInService;
	
	@GetMapping("/page")
    public Page<Checkin> getAllCheckIns(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        return checkInService.getAllCheckins(page, size);
    }
	
	 @GetMapping("/sort")
	    public List<Checkin> getAllCheckInsSorted(@RequestParam(defaultValue = "id") String sortBy,
	                                              @RequestParam(defaultValue = "asc") String sortDir) {
	        return checkInService.getAllCheckInsSorted(sortBy, sortDir);
	    }

	 @PostMapping
	    public ResponseEntity<Checkin> createALLCheckins(@RequestBody Checkin checkIn) {
	        Checkin createdCheckIn = checkInService.createALLCheckins(checkIn);
	        return new ResponseEntity<>(createdCheckIn, HttpStatus.CREATED);
	    }

    @GetMapping("/{id}")
    public Checkin getCheckInById(@PathVariable Long id) {
        return checkInService.getCheckinById(id);
    }

    @PutMapping("/{id}")
    public Checkin updateCheckIn(@PathVariable Long id, @RequestBody Checkin checkIn) {
        return checkInService.updateChechin(id, checkIn);
    }

    @DeleteMapping("/{id}")
    public void deleteCheckIn(@PathVariable Long id) {
        checkInService.deleteCheckin(id);
    }

}
